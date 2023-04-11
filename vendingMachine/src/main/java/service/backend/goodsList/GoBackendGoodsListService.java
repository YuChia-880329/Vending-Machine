package service.backend.goodsList;

import bean.dto.vo.backend.goodsList.readin.BGLPageParameterRIVODTO;
import bean.dto.vo.backend.goodsList.writeout.BackendGoodsListWOVODTO;
import dao.memory.repository.GoodsTablePagesDAO;

public class GoBackendGoodsListService {
	
	private GoodsTablePagesService goodsTablePagesService;
	

	private static final GoBackendGoodsListService INSTANCE = new GoBackendGoodsListService();
	
	private GoBackendGoodsListService() {
		
		goodsTablePagesService = GoodsTablePagesService.getInstance();
	}
	
	public static GoBackendGoodsListService getInstance() {
		
		return INSTANCE;
	}
	
	public BackendGoodsListWOVODTO prepare(BGLPageParameterRIVODTO pageParameter, GoodsTablePagesDAO goodsTablePagesDAO) {
		
		Integer currentPage = pageParameter.getPage();
		if(currentPage == null) {
			
			currentPage = 1;
			pageParameter.setPage(currentPage);
		}
		
		BackendGoodsListWOVODTO backendGoodsListWOVODTO = new BackendGoodsListWOVODTO();

		backendGoodsListWOVODTO.setGoodsTablePage(goodsTablePagesService.prepare(pageParameter, goodsTablePagesDAO));
		
		return backendGoodsListWOVODTO;
	}
}
