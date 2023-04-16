package service.backend.orderList.prepare;

import java.util.List;
import java.util.stream.Collectors;

import bean.dto.backend.orderList.obj.repository.orderTablePages.readin.OrderTablePagesInputOBJDTO;
import bean.dto.backend.orderList.obj.repository.orderTablePages.writeout.OrderTablePagesOBJDTO;
import bean.dto.backend.orderList.obj.repository.orderTablePages.writeout.OrderTableRowOBJDTO;
import bean.dto.backend.orderList.vo.readin.PageParameterVODTO;
import bean.dto.backend.orderList.vo.writeout.OrderTableRowVODTO;
import dao.memory.repository.backend.orderList.OrderTablePagesDAO;

public class OrderTableRowsService {

	private static final OrderTableRowsService INSTANCE = new OrderTableRowsService();
	
	private OrderTableRowsService() {
	}
	
	public static OrderTableRowsService getInstance() {
		
		return INSTANCE;
	}
	
	public List<OrderTableRowVODTO> prepare(PageParameterVODTO pageParameterVODTO, OrderTablePagesDAO orderTablePagesDAO){
		
		OrderTablePagesInputOBJDTO orderTablePagesInputOBJDTO = pageParameterVOToOrderTablePagesInputOBJ(pageParameterVODTO);
		OrderTablePagesOBJDTO orderTablePagesOBJDTO = orderTablePagesDAO.getObjDto(orderTablePagesInputOBJDTO);
		int currentPage = pageParameterVODTO.getPage();
		List<OrderTableRowOBJDTO> orderTableRowOBJDTOs = orderTablePagesOBJDTO.getOrderTablePageMap().get(currentPage).getOrderTable().getOrderTableRows();
		return orderTableRowOBJsToOrderTableRowVOs(orderTableRowOBJDTOs);
	}
	
	
	private OrderTablePagesInputOBJDTO pageParameterVOToOrderTablePagesInputOBJ(PageParameterVODTO pageParameterVODTO) {
		
		OrderTablePagesInputOBJDTO orderTablePagesInputOBJDTO = new OrderTablePagesInputOBJDTO();
		
		orderTablePagesInputOBJDTO.setCurrentPage(pageParameterVODTO.getPage().intValue());
		orderTablePagesInputOBJDTO.setCustomerName(pageParameterVODTO.getCustomerName());
		orderTablePagesInputOBJDTO.setStartDate(pageParameterVODTO.getStartDate());
		orderTablePagesInputOBJDTO.setEndDate(pageParameterVODTO.getEndDate());
		orderTablePagesInputOBJDTO.setGoodsName(pageParameterVODTO.getGoodsName());
		orderTablePagesInputOBJDTO.setGoodsPriceMin(pageParameterVODTO.getGoodsPriceMin());
		orderTablePagesInputOBJDTO.setGoodsPriceMax(pageParameterVODTO.getGoodsPriceMax());
		orderTablePagesInputOBJDTO.setBuyQuantityMin(pageParameterVODTO.getBuyQuantityMin());
		orderTablePagesInputOBJDTO.setBuyQuantityMax(pageParameterVODTO.getBuyQuantityMax());
		orderTablePagesInputOBJDTO.setTotalPriceMin(pageParameterVODTO.getTotalPriceMin());
		orderTablePagesInputOBJDTO.setTotalPriceMax(pageParameterVODTO.getTotalPriceMax());
		
		return orderTablePagesInputOBJDTO;
	}
	
	private List<OrderTableRowVODTO> orderTableRowOBJsToOrderTableRowVOs(List<OrderTableRowOBJDTO> orderTableRowOBJDTOs){
		
		return orderTableRowOBJDTOs.stream()
				.map(orderTableRowOBJDTO -> orderTableRowOBJToOrderTableRowVO(orderTableRowOBJDTO))
				.collect(Collectors.toList());
	}
	
	private OrderTableRowVODTO orderTableRowOBJToOrderTableRowVO(OrderTableRowOBJDTO orderTableRowOBJDTO) {
		
		OrderTableRowVODTO orderTableRowVODTO = new OrderTableRowVODTO();
		
		orderTableRowVODTO.setCustomerName(orderTableRowOBJDTO.getCustomerName());
		orderTableRowVODTO.setDate(orderTableRowOBJDTO.getDate());
		orderTableRowVODTO.setGoodsName(orderTableRowOBJDTO.getGoodsName());
		orderTableRowVODTO.setGoodsPrice(orderTableRowOBJDTO.getGoodsPrice());
		orderTableRowVODTO.setBuyQuantity(orderTableRowOBJDTO.getBuyQuantity());
		orderTableRowVODTO.setTotalPrice(orderTableRowOBJDTO.getTotalPrice());
		
		return orderTableRowVODTO;
	}

}
