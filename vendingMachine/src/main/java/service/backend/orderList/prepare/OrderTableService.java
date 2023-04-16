package service.backend.orderList.prepare;

import bean.dto.backend.orderList.vo.readin.PageParameterVODTO;
import bean.dto.backend.orderList.vo.writeout.OrderTableVODTO;
import dao.memory.repository.backend.orderList.OrderTablePagesDAO;

public class OrderTableService {

	private OrderTableRowsService orderTableRowsService;
	
	
	private static final OrderTableService INSTANCE = new OrderTableService();
	
	private OrderTableService() {
		
		orderTableRowsService = OrderTableRowsService.getInstance();
	}
	
	public static OrderTableService getInstance() {
		
		return INSTANCE;
	}
	
	public OrderTableVODTO prepare(PageParameterVODTO pageParameterVODTO, OrderTablePagesDAO orderTablePagesDAO) {
		
		OrderTableVODTO orderTableVODTO = new OrderTableVODTO();
		
		orderTableVODTO.setOrderTableRows(orderTableRowsService.prepare(pageParameterVODTO, orderTablePagesDAO));
		
		return orderTableVODTO;
	}
}
