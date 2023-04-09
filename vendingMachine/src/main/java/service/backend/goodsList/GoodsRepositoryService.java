package service.backend.goodsList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bean.dto.model.GoodsModelDTO;
import bean.dto.vo.backend.goodsList.BGLRParameterDTO;
import bean.dto.vo.backend.goodsList.readin.BGLPageParameterRIVODTO;
import database.goods.GoodsModelDAO;
import database.goods.GoodsModelTransformer;
import bean.dto.vo.backend.goodsList.BGLRepositoryObj;
import bean.dto.vo.backend.goodsList.BGLGoodsRepositoryDTO;
import service.dao.QueryObj;
import util.PaginationUtil;

public class GoodsRepositoryService {
	
	public static final int PAGES_PER_GROUP = 3;
	public static final int GOODS_PER_PAGE = 10;
	
	private BGLGoodsRepositoryDTO repository;
	private boolean needUpdate;
	
	private GoodsModelDAO goodsDAO;
	private GoodsModelTransformer goodsModelTransformer;
	private BGLRParameterService bglrParameterService;
	
	private static final GoodsRepositoryService INSTANCE = new GoodsRepositoryService();
	
	private GoodsRepositoryService() {
		
		goodsDAO = GoodsModelDAO.getInstance();
		goodsModelTransformer = GoodsModelTransformer.getInstance();
		bglrParameterService = BGLRParameterService.getInstance();
		
		BGLRParameterDTO parameter = new BGLRParameterDTO();
		parameter.setIdMin(null);
		parameter.setIdMax(null);
		parameter.setName(null);
		parameter.setPriceMin(null);
		parameter.setPriceMax(null);
		parameter.setQuantityMin(null);
		parameter.setQuantityMax(null);
		parameter.setStatus(null);
		repository = getRepository(parameter, 1);
		
		needUpdate = false;
	}
	
	public static GoodsRepositoryService getInstance() {
		
		return INSTANCE;
	}
	
	public BGLRepositoryObj getRepositoryObj(BGLRParameterDTO parameter, int page) {
		
		if(!bglrParameterService.equals(parameter, repository.getParameter())
				|| repository.getGoodsPages().get(page)==null
				|| needUpdate) {
			
			repository = getRepository(parameter, page);
			needUpdate = false;
		}
		
		BGLRepositoryObj repositoryObj = new BGLRepositoryObj();
		repositoryObj.setGoodsPage(repository.getGoodsPages().get(page));
		repositoryObj.setMaxPage(repository.getMaxPage());
		repositoryObj.setParameter(parameter);
		
		return repositoryObj;
	}

	
	public BGLGoodsRepositoryDTO getRepository(BGLRParameterDTO parameter, int page) {
		
		BGLGoodsRepositoryDTO repository = new BGLGoodsRepositoryDTO();
		
		repository.setParameter(parameter);
		
		QueryObj[] queryObjs = bglrParameterService.getQueryObjs(parameter);
		int maxPage = PaginationUtil.getMaxPage(goodsDAO.searchRowNumber(queryObjs), GOODS_PER_PAGE);
		repository.setMaxPage(maxPage);
		
		
		Map<Integer, List<GoodsModelDTO>> goodsPages = new HashMap<>();
		int startPage = PaginationUtil.getStartPage(page, PAGES_PER_GROUP);
		int endPage = PaginationUtil.getEndPage(page, PAGES_PER_GROUP, maxPage);
		for(int i=startPage; i<=endPage; i++) {
			
			goodsPages.put(i, goodsModelTransformer.modelListToDtoList(goodsDAO.searchByQueryObjPage(i, GOODS_PER_PAGE, queryObjs)));
		}
		repository.setGoodsPages(goodsPages);

		return repository;
	}
	
	public void needUpdate() {
		
		needUpdate = true;
	}

	
	public static BGLRParameterDTO transform(BGLPageParameterRIVODTO pageParameter) {
		
		BGLRParameterDTO bglrParameterDTO = new BGLRParameterDTO();
		
		bglrParameterDTO.setIdMin(pageParameter.getIdMin());
		bglrParameterDTO.setIdMax(pageParameter.getIdMax());
		bglrParameterDTO.setName(pageParameter.getName());
		bglrParameterDTO.setPriceMin(pageParameter.getPriceMin());
		bglrParameterDTO.setPriceMax(pageParameter.getPriceMax());
		bglrParameterDTO.setQuantityMin(pageParameter.getQuantityMin());
		bglrParameterDTO.setQuantityMax(pageParameter.getQuantityMax());
		bglrParameterDTO.setStatus(pageParameter.getStatus());
		
		return bglrParameterDTO;
	}
}
