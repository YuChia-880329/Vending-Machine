package service.backend.orderList;

import bean.dto.backend.orderList.vo.readin.PageParameterVODTO;
import bean.dto.backend.orderList.vo.writeout.BackendOrderListVODTO;
import dao.memory.repository.backend.orderList.OrderTablePagesDAO;

public class GoBackendOrderListService {

	private OrderTablePageService orderTablePageService;
	private FilterFormService filterFormService;
	
	
	private static final GoBackendOrderListService INSTANCE = new GoBackendOrderListService();
	
	private GoBackendOrderListService() {
		
		orderTablePageService = OrderTablePageService.getInstance();
		filterFormService = FilterFormService.getInstance();
	}
	
	public static GoBackendOrderListService getInstance() {
		
		return INSTANCE;
	}
	
	public BackendOrderListVODTO prepare(PageParameterVODTO pageParameterVODTO, OrderTablePagesDAO orderTablePagesDAO) {
		
		Integer currentPage = pageParameterVODTO.getPage();
		if(currentPage == null) {
			
			currentPage = 1;
			pageParameterVODTO.setPage(currentPage);
		}
		
		BackendOrderListVODTO backendOrderListWOVODTO = new BackendOrderListVODTO();
		
		backendOrderListWOVODTO.setOrderTablePage(orderTablePageService.prepare(pageParameterVODTO, orderTablePagesDAO));
		backendOrderListWOVODTO.setFilterForm(filterFormService.prepare(pageParameterVODTO));
		
		return backendOrderListWOVODTO;
	}
}
