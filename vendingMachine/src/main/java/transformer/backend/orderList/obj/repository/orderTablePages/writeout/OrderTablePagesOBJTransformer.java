package transformer.backend.orderList.obj.repository.orderTablePages.writeout;

import java.util.Map;
import java.util.stream.Collectors;

import bean.dto.backend.orderList.obj.repository.orderTablePages.writeout.OrderTablePageOBJDTO;
import bean.dto.backend.orderList.obj.repository.orderTablePages.writeout.OrderTablePagesOBJDTO;
import bean.obj.backend.orderList.repository.orderTablePages.writein.OrderTablePageOBJ;
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
		
		Map<Integer, OrderTablePageOBJ> orderTablePageOBJMap = obj.getOrderTablePageMap();
		Map<Integer, OrderTablePageOBJDTO> orderTablePageOBJDTOMap = 
				orderTablePageOBJMap==null ? null : obj.getOrderTablePageMap().entrySet().stream()
						.collect(Collectors.toMap(
								entry -> entry.getKey(), 
								entry -> orderTablePageOBJTransformer.objToDto(entry.getValue())));
		dto.setOrderTablePageMap(orderTablePageOBJDTOMap);
		dto.setMaxPage(obj.getMaxPage());
		dto.setFilterParameter(filterParameterOBJTransformer.objToDto(obj.getFilterParameter()));
		
		return dto;
	}
}
