package service.backend.orderList.prepare;

import bean.dto.backend.orderList.vo.readin.PageParameterVODTO;
import bean.dto.backend.orderList.vo.writeout.BackendOrderListVODTO;
import bean.dto.virtualMachine.obj.memoryDAOKitVM.AccountOBJDTO;
import dao.memory.repository.backend.orderList.OrderTablePagesRepositoryDAO;
import dao.virtualDevice.memoryDAOKit.MemoryDAOKitVMDAO;

public class GoBackendOrderListService {

	private OrderTablePageService orderTablePageService;
	private FilterFormService filterFormService;
	private MemoryDAOKitVMDAO memoryDAOKitVMDAO;
	
	
	private static final GoBackendOrderListService INSTANCE = new GoBackendOrderListService();
	
	private GoBackendOrderListService() {
		
		orderTablePageService = OrderTablePageService.getInstance();
		filterFormService = FilterFormService.getInstance();
		memoryDAOKitVMDAO = MemoryDAOKitVMDAO.getInstance();
	}
	
	public static GoBackendOrderListService getInstance() {
		
		return INSTANCE;
	}
	
	public BackendOrderListVODTO prepare(PageParameterVODTO pageParameterVODTO, AccountOBJDTO accountOBJDTO) {
		
		OrderTablePagesRepositoryDAO orderTablePagesRepositoryDAO = memoryDAOKitVMDAO.getOrderTablePagesRepositoryDAO(accountOBJDTO);
		
		Integer currentPage = pageParameterVODTO.getPage();
		if(currentPage == null) {
			
			currentPage = 1;
			pageParameterVODTO.setPage(currentPage);
		}
		
		BackendOrderListVODTO backendOrderListWOVODTO = new BackendOrderListVODTO();
		
		backendOrderListWOVODTO.setOrderTablePage(orderTablePageService.prepare(pageParameterVODTO, orderTablePagesRepositoryDAO));
		backendOrderListWOVODTO.setFilterForm(filterFormService.prepare(pageParameterVODTO));
		
		return backendOrderListWOVODTO;
	}
}
