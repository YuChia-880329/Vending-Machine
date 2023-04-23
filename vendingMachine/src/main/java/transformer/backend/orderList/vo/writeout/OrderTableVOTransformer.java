package transformer.backend.orderList.vo.writeout;

import bean.dto.backend.orderList.vo.writeout.OrderTableVODTO;
import bean.vo.backend.orderList.writeout.OrderTableRowVO;
import bean.vo.backend.orderList.writeout.OrderTableVO;
import template.transformer.bean.vo.VOWriteOutTransformerTemplate;

public class OrderTableVOTransformer extends VOWriteOutTransformerTemplate<OrderTableVODTO, OrderTableVO> {

	private OrderTableRowVOTransformer orderTableRowVOTransformer;
	
	
	private static final OrderTableVOTransformer INSTANCE = new OrderTableVOTransformer();
	
	private OrderTableVOTransformer() {
		
		orderTableRowVOTransformer = OrderTableRowVOTransformer.getInstance();
	}
	
	public static OrderTableVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	protected OrderTableVO dtoToVoTransform(OrderTableVODTO dto) {

		OrderTableVO vo = new OrderTableVO();
		
		vo.setOrderTableRows(orderTableRowVOTransformer.dtoListToVoArray(dto.getOrderTableRows(), size -> new OrderTableRowVO[size]));
		
		return vo;
	}
}
