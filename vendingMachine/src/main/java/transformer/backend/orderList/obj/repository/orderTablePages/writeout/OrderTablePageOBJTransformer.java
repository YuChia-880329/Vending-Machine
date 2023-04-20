package transformer.backend.orderList.obj.repository.orderTablePages.writeout;

import bean.dto.backend.orderList.obj.repository.orderTablePages.writeout.OrderTablePageOBJDTO;
import bean.obj.backend.orderList.repository.orderTablePages.writein.OrderTablePageOBJ;
import template.memory.repository.RepositoryObjTransformerTemplate;

public class OrderTablePageOBJTransformer extends RepositoryObjTransformerTemplate<OrderTablePageOBJ, OrderTablePageOBJDTO> {

	private OrderTableOBJTransformer orderTableOBJTransformer;
	
	
	private static final OrderTablePageOBJTransformer INSTANCE = new OrderTablePageOBJTransformer();
	
	private OrderTablePageOBJTransformer() {
		
		orderTableOBJTransformer = OrderTableOBJTransformer.getInstance();
	}
	
	public static OrderTablePageOBJTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	protected OrderTablePageOBJDTO objToDtoTransform(OrderTablePageOBJ obj) {
		
		OrderTablePageOBJDTO dto = new OrderTablePageOBJDTO();
		
		dto.setOrderTable(orderTableOBJTransformer.objToDto(obj.getOrderTable()));
		
		return dto;
	}
}
