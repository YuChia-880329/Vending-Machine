package service.backend.goodsList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bean.dto.model.GoodsModelDTO;
import bean.dto.vo.backend.goodsList.BGLRParameterDTO;
import bean.dto.vo.writeout.PaginationWOVODTO;
import bean.dto.vo.backend.goodsList.BGLGoodsRepositoryDTO;
import dao.GoodsDAO;
import dao.QueryObj;
import service.PaginationService;
import transformer.model.GoodsModelTransformer;
import util.PaginationUtil;

public class GoodsRepositoryService {
	
	public static final int PAGES_PER_GROUP = 3;
	public static final int GOODS_PER_PAGE = 10;
	
	private BGLGoodsRepositoryDTO repository;
	private boolean needUpdate;
	
	private GoodsDAO goodsDAO;
	private GoodsModelTransformer goodsModelTransformer;
	private BGLRParameterService bglrParameterService;
	private PaginationService paginationService;
	
	private static final GoodsRepositoryService INSTANCE = new GoodsRepositoryService();
	
	private GoodsRepositoryService() {
		
		goodsDAO = GoodsDAO.getInstance();
		goodsModelTransformer = GoodsModelTransformer.getInstance();
		bglrParameterService = BGLRParameterService.getInstance();
		paginationService = PaginationService.getInstance();
		
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
	
	public void updateRepository(BGLRParameterDTO parameter, int page) {
		
		if(!bglrParameterService.equals(parameter, repository.getParameter())
				|| repository.getPages().get(page) == null
				|| needUpdate)
			repository = getRepository(parameter, page);
	}
	public List<GoodsModelDTO> getPage(int page){
		
		return repository.getPages().get(page);
	}
	public PaginationWOVODTO getPagination() {
		
		return repository.getPagination();
	}
	
	public BGLGoodsRepositoryDTO getRepository(BGLRParameterDTO parameter, int currentPage) {
		
		BGLGoodsRepositoryDTO repository = new BGLGoodsRepositoryDTO();
		
		repository.setParameter(parameter);
		
		QueryObj[] queryObjs = bglrParameterService.getQueryObjs(parameter);

		
		Map<Integer, List<GoodsModelDTO>> pages = new HashMap<>();
		int maxPage = PaginationUtil.getMaxPage(goodsDAO.searchRowNumber(queryObjs), GOODS_PER_PAGE);
		int startPage = PaginationUtil.getStartPage(currentPage, PAGES_PER_GROUP);
		int endPage = PaginationUtil.getEndPage(currentPage, PAGES_PER_GROUP, maxPage);
		for(int i=startPage; i<=endPage; i++) {
			
			pages.put(i, goodsModelTransformer.modelListToDtoList(goodsDAO.searchByQueryObjPage(i, GOODS_PER_PAGE, queryObjs)));
		}
		repository.setPages(pages);
		
		repository.setPagination(paginationService.getPagination(currentPage, startPage, endPage, maxPage));
		return repository;
	}
	
	public void needUpdate() {
		
		needUpdate = true;
	}
}
