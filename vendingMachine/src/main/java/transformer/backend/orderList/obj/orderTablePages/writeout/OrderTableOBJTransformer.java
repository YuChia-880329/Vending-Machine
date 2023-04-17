package transformer.backend.orderList.obj.orderTablePages.writeout;

import bean.dto.backend.orderList.obj.repository.orderTablePages.writeout.OrderTableOBJDTO;
import bean.obj.backend.orderList.repository.orderTablePages.writein.OrderTableOBJ;
import template.memory.repository.RepositoryObjTransformerTemplate;

public class OrderTableOBJTransformer extends RepositoryObjTransformerTemplate<OrderTableOBJ, OrderTableOBJDTO> {

	private OrderTableRowOBJTransformer orderTableRowOBJTransformer;
	
	
	private static final OrderTableOBJTransformer INSTANCE = new OrderTableOBJTransformer();
	
	private OrderTableOBJTransformer() {
		
		orderTableRowOBJTransformer = OrderTableRowOBJTransformer.getInstance();
	}
	
	public static OrderTableOBJTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	protected OrderTableOBJDTO objToDtoTransform(OrderTableOBJ obj) {
		
		OrderTableOBJDTO dto = new OrderTableOBJDTO();
		
		dto.setOrderTableRows(orderTableRowOBJTransformer.objListToDtoList(obj.getOrderTableRows()));
		
		return dto;
	}
}
