package service.backend.goodsList.prepare;

import bean.dto.backend.goodsList.vo.readin.PageParameterVODTO;
import bean.dto.backend.goodsList.vo.writeout.BackendGoodsListVODTO;
import bean.dto.virtualMachine.obj.memoryDAOKitVM.AccountOBJDTO;
import dao.memory.repository.backend.goodsList.GoodsTablePagesRepositoryDAO;
import dao.virtualDevice.memoryDAOKit.MemoryDAOKitVMDAO;

public class GoBackendGoodsListService {
	
	private GoodsTablePageService goodsTablePageService;
	private FilterFormService filterFormService;
	private MemoryDAOKitVMDAO memoryDAOKitVMDAO;

	private static final GoBackendGoodsListService INSTANCE = new GoBackendGoodsListService();
	
	private GoBackendGoodsListService() {
		
		goodsTablePageService = GoodsTablePageService.getInstance();
		filterFormService = FilterFormService.getInstance();
		memoryDAOKitVMDAO = MemoryDAOKitVMDAO.getInstance();
	}
	
	public static GoBackendGoodsListService getInstance() {
		
		return INSTANCE;
	}
	
	public BackendGoodsListVODTO prepare(PageParameterVODTO pageParameterVODTO, AccountOBJDTO accountOBJDTO) {
		
		GoodsTablePagesRepositoryDAO goodsTablePagesRepositoryDAO = memoryDAOKitVMDAO.getGoodsTablePagesRepositoryDAO(accountOBJDTO);
		
		
		Integer currentPage = pageParameterVODTO.getPage();
		if(currentPage == null) {
			
			currentPage = 1;
			pageParameterVODTO.setPage(currentPage);
		}
		
		BackendGoodsListVODTO backendGoodsListVODTO = new BackendGoodsListVODTO();

		backendGoodsListVODTO.setGoodsTablePage(goodsTablePageService.prepare(pageParameterVODTO, goodsTablePagesRepositoryDAO));
		backendGoodsListVODTO.setFilterForm(filterFormService.prepare(pageParameterVODTO));
		
		return backendGoodsListVODTO;
	}
}
