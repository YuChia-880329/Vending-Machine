package transformer.backend.orderList.vo.writeout;

import bean.dto.backend.orderList.vo.writeout.OrderTablePageVODTO;
import bean.vo.backend.orderList.writeout.OrderTablePageVO;
import template.transformer.bean.vo.VOWriteOutTransformerTemplate;
import transformer.vo.writeout.PaginationWOVOTransformer;

public class OrderTablePageVOTransformer extends VOWriteOutTransformerTemplate<OrderTablePageVODTO, OrderTablePageVO> {

	private OrderTableVOTransformer orderTableVOTransformer;
	private PaginationWOVOTransformer paginationWOVOTransformer;
	
	private static final OrderTablePageVOTransformer INSTANCE = new OrderTablePageVOTransformer();
	
	private OrderTablePageVOTransformer() {
		
		orderTableVOTransformer = OrderTableVOTransformer.getInstance();
		paginationWOVOTransformer = PaginationWOVOTransformer.getInstance();
	}
	
	public static OrderTablePageVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	public OrderTablePageVO dtoToVo(OrderTablePageVODTO dto) {
		
		OrderTablePageVO vo = new OrderTablePageVO();
		
		vo.setOrderTable(orderTableVOTransformer.dtoToVo(dto.getOrderTable()));
		vo.setPagination(paginationWOVOTransformer.dtoToVo(dto.getPagination()));
		
		return vo;
	}
	
	
}
