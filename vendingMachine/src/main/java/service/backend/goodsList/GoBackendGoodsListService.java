package service.backend.goodsList;

import java.util.List;
import java.util.stream.Collectors;

import bean.dto.model.GoodsModelDTO;
import bean.dto.vo.backend.goodsList.BGLRParameterDTO;
import bean.dto.vo.backend.goodsList.BGLRepositoryObj;
import bean.dto.vo.backend.goodsList.readin.BGLPageParameterRIVODTO;
import bean.dto.vo.backend.goodsList.writeout.BGLGTGoodsWOVODTO;
import bean.dto.vo.backend.goodsList.writeout.BGLGoodsTableWOVODTO;
import bean.dto.vo.backend.goodsList.writeout.BGLSearchParameterWOVODTO;
import bean.dto.vo.backend.goodsList.writeout.BackendGoodsListWOVODTO;
import controller.servlet.backend.go.GoBackendGoodsListServlet;
import service.PaginationService;
import util.PaginationUtil;

public class GoBackendGoodsListService {
	
	private GoodsRepositoryService goodsRepositoryService;
	private PaginationService paginationService;
	private BGLUrlService bglUrlService;
	

	private static final GoBackendGoodsListService INSTANCE = new GoBackendGoodsListService();
	
	private GoBackendGoodsListService() {
		
		goodsRepositoryService = GoodsRepositoryService.getInstance();
		paginationService = PaginationService.getInstance();
		bglUrlService = BGLUrlService.getInstance();
	}
	
	public static GoBackendGoodsListService getInstance() {
		
		return INSTANCE;
	}
	
	public BackendGoodsListWOVODTO prepare(BGLPageParameterRIVODTO pageParameter) {
		
		BackendGoodsListWOVODTO backendGoodsListWOVODTO = new BackendGoodsListWOVODTO();
		
		Integer page = pageParameter.getPage();
		if(page == null)
			page = 1;
		
		BGLRepositoryObj repositoryObj = goodsRepositoryService
				.getRepositoryObj(GoodsRepositoryService.transform(pageParameter), page);
		
		backendGoodsListWOVODTO.setGoodsTable(transform(repositoryObj.getGoodsPage()));
		backendGoodsListWOVODTO.setSearchParameter(transform(repositoryObj.getParameter()));
		backendGoodsListWOVODTO.setPagination(paginationService.getPagination(
				page, 
				PaginationUtil.getStartPage(page, GoodsRepositoryService.PAGES_PER_GROUP), 
				PaginationUtil.getEndPage(page, GoodsRepositoryService.PAGES_PER_GROUP, repositoryObj.getMaxPage()), 
				repositoryObj.getMaxPage(),
				bglUrlService.getUrlFctn(GoBackendGoodsListServlet.URL, pageParameter)));
		
		return backendGoodsListWOVODTO;
	}
	
	private BGLGTGoodsWOVODTO transform(GoodsModelDTO goodsModelDTO) {
		
		BGLGTGoodsWOVODTO bglgtGoodsWOVODTO = new BGLGTGoodsWOVODTO();
		
		bglgtGoodsWOVODTO.setId(goodsModelDTO.getId());
		bglgtGoodsWOVODTO.setName(goodsModelDTO.getName());
		bglgtGoodsWOVODTO.setPrice(goodsModelDTO.getPrice());
		bglgtGoodsWOVODTO.setQuantity(goodsModelDTO.getQuantity());
		bglgtGoodsWOVODTO.setStatus(goodsModelDTO.getStatus());
		
		return bglgtGoodsWOVODTO;
	}
	
	private BGLGoodsTableWOVODTO transform(List<GoodsModelDTO> goodsModelDTOs) {
		
		List<BGLGTGoodsWOVODTO> bglgtGoodsWOVODTOs = goodsModelDTOs.stream()
				.map(dto -> transform(dto))
				.collect(Collectors.toList());
		
		BGLGoodsTableWOVODTO bglGoodsTableWOVODTO = new BGLGoodsTableWOVODTO();
		
		bglGoodsTableWOVODTO.setGoods(bglgtGoodsWOVODTOs);
		
		return bglGoodsTableWOVODTO;
	}
	private BGLSearchParameterWOVODTO transform(BGLRParameterDTO parameter) {
		
		BGLSearchParameterWOVODTO searchParamter = new BGLSearchParameterWOVODTO();
		
		searchParamter.setIdMin(parameter.getIdMin());
		searchParamter.setIdMax(parameter.getIdMax());
		searchParamter.setName(parameter.getName());
		searchParamter.setPriceMin(parameter.getPriceMin());
		searchParamter.setPriceMax(parameter.getPriceMax());
		searchParamter.setQuantityMin(parameter.getQuantityMin());
		searchParamter.setQuantityMax(parameter.getQuantityMax());
		searchParamter.setStatus(parameter.getStatus());
		
		return searchParamter;
	}
	
}
