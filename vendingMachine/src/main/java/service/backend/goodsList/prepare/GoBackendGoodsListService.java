package service.backend.goodsList.prepare;

import bean.dto.backend.goodsList.vo.readin.PageParameterVODTO;
import bean.dto.backend.goodsList.vo.writeout.BackendGoodsListVODTO;
import dao.memory.repository.backend.goodsList.GoodsTablePagesDAO;

public class GoBackendGoodsListService {
	
	private GoodsTablePageService goodsTablePageService;
	private FilterFormService filterFormService;

	private static final GoBackendGoodsListService INSTANCE = new GoBackendGoodsListService();
	
	private GoBackendGoodsListService() {
		
		goodsTablePageService = GoodsTablePageService.getInstance();
		filterFormService = FilterFormService.getInstance();
	}
	
	public static GoBackendGoodsListService getInstance() {
		
		return INSTANCE;
	}
	
	public BackendGoodsListVODTO prepare(PageParameterVODTO pageParameterVODTO, GoodsTablePagesDAO goodsTablePagesDAO) {
		
		Integer currentPage = pageParameterVODTO.getPage();
		if(currentPage == null) {
			
			currentPage = 1;
			pageParameterVODTO.setPage(currentPage);
		}
		
		BackendGoodsListVODTO backendGoodsListVODTO = new BackendGoodsListVODTO();

		backendGoodsListVODTO.setGoodsTablePage(goodsTablePageService.prepare(pageParameterVODTO, goodsTablePagesDAO));
		backendGoodsListVODTO.setFilterForm(filterFormService.prepare(pageParameterVODTO));
		
		return backendGoodsListVODTO;
	}
}
