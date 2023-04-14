package service.backend.orderList;

import java.util.List;
import java.util.stream.Collectors;

import bean.dto.backend.orderList.obj.repository.orderTablePages.readin.OrderTablePagesInputOBJDTO;
import bean.dto.backend.orderList.obj.repository.orderTablePages.writeout.OrderTableRowOBJDTO;
import bean.dto.backend.orderList.vo.readin.PageParameterVODTO;
import bean.dto.backend.orderList.vo.writeout.OrderTableRowVODTO;
import bean.dto.model.OrderJoinModelDTO;
import util.DateTimeUtil;

public class DTOTransformService {

	private static final DTOTransformService INSTANCE = new DTOTransformService();
	
	private DTOTransformService() {
	}
	
	public static DTOTransformService getInstance() {
		
		return INSTANCE;
	}
	
	public OrderTableRowOBJDTO orderJoinModelToOrderTableRowOBJ(OrderJoinModelDTO orderJoinModelDTO) {
		
		OrderTableRowOBJDTO orderTableRowOBJDTO = new OrderTableRowOBJDTO();
		
		orderTableRowOBJDTO.setCustomerName(orderJoinModelDTO.getCustomerName());
		orderTableRowOBJDTO.setDate(DateTimeUtil.localDateTimeToLocalDate(orderJoinModelDTO.getDateTime()));
		orderTableRowOBJDTO.setGoodsName(orderJoinModelDTO.getGoodsName());
		orderTableRowOBJDTO.setGoodsPrice(orderJoinModelDTO.getGoodsPrice());
		orderTableRowOBJDTO.setBuyQuantity(orderJoinModelDTO.getBuyQuantity());
		orderTableRowOBJDTO.setTotalPrice(orderJoinModelDTO.getTotalPrice());
		
		return orderTableRowOBJDTO;
	}
	public List<OrderTableRowOBJDTO> orderJoinModelsToOrderTableRowOBJs(List<OrderJoinModelDTO> orderJoinModelDTOs){
		
		return orderJoinModelDTOs.stream()
				.map(orderJoinModel -> orderJoinModelToOrderTableRowOBJ(orderJoinModel))
				.collect(Collectors.toList());
	}
	
	public OrderTablePagesInputOBJDTO pageParameterVOToOrderTablePagesInputOBJ(PageParameterVODTO pageParameterVODTO) {
		
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
	
	public OrderTableRowVODTO orderTableRowOBJToOrderTableRowVO(OrderTableRowOBJDTO orderTableRowOBJDTO) {
		
		OrderTableRowVODTO orderTableRowVODTO = new OrderTableRowVODTO();
		
		orderTableRowVODTO.setCustomerName(orderTableRowOBJDTO.getCustomerName());
		orderTableRowVODTO.setDate(orderTableRowOBJDTO.getDate());
		orderTableRowVODTO.setGoodsName(orderTableRowOBJDTO.getGoodsName());
		orderTableRowVODTO.setGoodsPrice(orderTableRowOBJDTO.getGoodsPrice());
		orderTableRowVODTO.setBuyQuantity(orderTableRowOBJDTO.getBuyQuantity());
		orderTableRowVODTO.setTotalPrice(orderTableRowOBJDTO.getTotalPrice());
		
		return orderTableRowVODTO;
	}
	public List<OrderTableRowVODTO> orderTableRowOBJsToOrderTableRowVOs(List<OrderTableRowOBJDTO> orderTableRowOBJDTOs){
		
		return orderTableRowOBJDTOs.stream()
				.map(orderTableRowOBJDTO -> orderTableRowOBJToOrderTableRowVO(orderTableRowOBJDTO))
				.collect(Collectors.toList());
	}
}
