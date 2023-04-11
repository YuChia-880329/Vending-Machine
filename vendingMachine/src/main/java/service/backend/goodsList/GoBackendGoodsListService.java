package service.backend.goodsList;

import bean.dto.backend.goodsList.vo.readin.PageParameterVODTO;
import bean.dto.backend.goodsList.vo.writeout.BackendGoodsListVODTO;
import dao.memory.repository.backend.goodsList.GoodsTablePagesDAO;

public class GoBackendGoodsListService {
	
	private GoodsTablePagesService goodsTablePagesService;
	

	private static final GoBackendGoodsListService INSTANCE = new GoBackendGoodsListService();
	
	private GoBackendGoodsListService() {
		
		goodsTablePagesService = GoodsTablePagesService.getInstance();
	}
	
	public static GoBackendGoodsListService getInstance() {
		
		return INSTANCE;
	}
	
	public BackendGoodsListVODTO prepare(PageParameterVODTO pageParameter, GoodsTablePagesDAO goodsTablePagesDAO) {
		
		Integer currentPage = pageParameter.getPage();
		if(currentPage == null) {
			
			currentPage = 1;
			pageParameter.setPage(currentPage);
		}
		
		BackendGoodsListVODTO backendGoodsListVODTO = new BackendGoodsListVODTO();

		backendGoodsListVODTO.setGoodsTablePage(goodsTablePagesService.prepare(pageParameter, goodsTablePagesDAO));
		
		return backendGoodsListVODTO;
	}
}
