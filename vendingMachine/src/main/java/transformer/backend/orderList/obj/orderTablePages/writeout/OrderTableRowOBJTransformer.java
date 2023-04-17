package transformer.backend.orderList.obj.orderTablePages.writeout;

import java.util.List;

import bean.dto.backend.orderList.obj.repository.orderTablePages.writeout.OrderTableRowOBJDTO;
import bean.obj.backend.orderList.repository.orderTablePages.writein.OrderTableRowOBJ;
import template.transformer.BiTransformerTemplate;

public class OrderTableRowOBJTransformer extends BiTransformerTemplate<OrderTableRowOBJDTO, OrderTableRowOBJ> {

	private static final OrderTableRowOBJTransformer INSTANCE = new OrderTableRowOBJTransformer();
	
	private OrderTableRowOBJTransformer() {
		
	}
	
	public static OrderTableRowOBJTransformer getInstance() {
		
		return INSTANCE;
	}
	
	
	public OrderTableRowOBJDTO objToDto(OrderTableRowOBJ obj) {
		
		return bToA(obj);
	}
	public OrderTableRowOBJ dtoToObj(OrderTableRowOBJDTO dto) {
		
		return aToB(dto);
	}
	public List<OrderTableRowOBJDTO> objListToDtoList(List<OrderTableRowOBJ> objList) {
		
		return bListToAList(objList);
	}
	public List<OrderTableRowOBJ> dtoListToObjList(List<OrderTableRowOBJDTO> dtoList) {
		
		return aListToBList(dtoList);
	}
	
	
	private OrderTableRowOBJDTO objToDtoTransform(OrderTableRowOBJ obj) {
		
		OrderTableRowOBJDTO dto = new OrderTableRowOBJDTO();
		
		dto.setCustomerName(obj.getCustomerName());
		dto.setDate(obj.getDate());
		dto.setGoodsName(obj.getGoodsName());
		dto.setGoodsPrice(obj.getGoodsPrice());
		dto.setBuyQuantity(obj.getBuyQuantity());
		dto.setTotalPrice(obj.getTotalPrice());
		
		return dto;
	}
	private OrderTableRowOBJ dtoToObjTransform(OrderTableRowOBJDTO dto) {
		
		OrderTableRowOBJ obj = new OrderTableRowOBJ();
		
		obj.setCustomerName(dto.getCustomerName());
		obj.setDate(dto.getDate());
		obj.setGoodsName(dto.getGoodsName());
		obj.setGoodsPrice(dto.getGoodsPrice());
		obj.setBuyQuantity(dto.getBuyQuantity());
		obj.setTotalPrice(dto.getTotalPrice());
		
		return obj;
	}
	
	
	@Override
	protected OrderTableRowOBJDTO bToATransform(OrderTableRowOBJ obj) {
		
		return objToDtoTransform(obj);
	}
	@Override
	protected OrderTableRowOBJ aToBTransform(OrderTableRowOBJDTO dto) {
		
		return dtoToObjTransform(dto);
	}
}
