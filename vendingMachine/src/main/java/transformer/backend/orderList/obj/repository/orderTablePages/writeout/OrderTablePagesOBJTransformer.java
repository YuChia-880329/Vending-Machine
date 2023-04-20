package transformer.backend.orderList.obj.repository.orderTablePages.writeout;

import java.util.stream.Collectors;

import bean.dto.backend.orderList.obj.repository.orderTablePages.writeout.OrderTablePagesOBJDTO;
import bean.obj.backend.orderList.repository.orderTablePages.writein.OrderTablePagesOBJ;
import template.memory.repository.RepositoryObjTransformerTemplate;

public class OrderTablePagesOBJTransformer extends RepositoryObjTransformerTemplate<OrderTablePagesOBJ, OrderTablePagesOBJDTO> {

	private OrderTablePageOBJTransformer orderTablePageOBJTransformer;
	private FilterParameterOBJTransformer filterParameterOBJTransformer;
	
	
	private static final OrderTablePagesOBJTransformer INSTANCE = new OrderTablePagesOBJTransformer();
	
	private OrderTablePagesOBJTransformer() {
		
		orderTablePageOBJTransformer = OrderTablePageOBJTransformer.getInstance();
		filterParameterOBJTransformer = FilterParameterOBJTransformer.getInstance();
	}
	
	public static OrderTablePagesOBJTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	protected OrderTablePagesOBJDTO objToDtoTransform(OrderTablePagesOBJ obj) {
		
		OrderTablePagesOBJDTO dto = new OrderTablePagesOBJDTO();
		
		dto.setOrderTablePageMap(obj.getOrderTablePageMap().entrySet().stream()
				.collect(Collectors.toMap(
						entry -> entry.getKey(), 
						entry -> orderTablePageOBJTransformer.objToDto(entry.getValue()))));
		dto.setMaxPage(obj.getMaxPage());
		dto.setFilterParameter(filterParameterOBJTransformer.objToDto(obj.getFilterParameter()));
		
		return dto;
	}
}
