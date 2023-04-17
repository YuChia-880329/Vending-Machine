package transformer.backend.orderList.vo.writeout;

import bean.dto.backend.orderList.vo.writeout.OrderTableRowVODTO;
import bean.vo.backend.orderList.writeout.OrderTableRowVO;
import template.transformer.bean.vo.VOWriteOutTransformerTemplate;
import util.DateTimeUtil;

public class OrderTableRowVOTransformer extends VOWriteOutTransformerTemplate<OrderTableRowVODTO, OrderTableRowVO> {

	private static final OrderTableRowVOTransformer INSTANCE = new OrderTableRowVOTransformer();
	
	private OrderTableRowVOTransformer() {
	}
	
	public static OrderTableRowVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	protected OrderTableRowVO dtoToVoTransform(OrderTableRowVODTO dto) {
		
		OrderTableRowVO vo = new OrderTableRowVO();
		
		vo.setCustomerName(dto.getCustomerName());
		vo.setDate(DateTimeUtil.localDateToString(dto.getDate()));
		vo.setGoodsName(dto.getGoodsName());
		vo.setGoodsPrice(String.valueOf(dto.getGoodsPrice()));
		vo.setBuyQuantity(String.valueOf(dto.getBuyQuantity()));
		vo.setTotalPrice(String.valueOf(dto.getTotalPrice()));
		
		return vo;
	}
}
