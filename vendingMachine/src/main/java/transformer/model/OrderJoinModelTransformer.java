package transformer.model;

import bean.dto.model.OrderJoinModelDTO;
import bean.model.OrderJoinModel;
import template.transformer.bean.model.ModelTransformerTemplate;
import util.DateTimeUtil;

public class OrderJoinModelTransformer extends ModelTransformerTemplate<OrderJoinModel, OrderJoinModelDTO> {

	private static final OrderJoinModelTransformer INSTANCE = new OrderJoinModelTransformer();
	
	private OrderJoinModelTransformer() {
	}
	
	public static OrderJoinModelTransformer getInstance() {
		
		return INSTANCE;
	}

	
	@Override
	protected OrderJoinModelDTO modelToDtoTransform(OrderJoinModel model) {
		
		OrderJoinModelDTO dto = new OrderJoinModelDTO();
		
		dto.setCustomerName(model.getCustomerName());
		dto.setDateTime(DateTimeUtil.timestampToLocalDateTime(model.getTimestamp()));
		dto.setGoodsName(model.getGoodsName());
		dto.setGoodsPrice(model.getGoodsPrice());
		dto.setBuyQuantity(model.getBuyQuantity());
		dto.setTotalPrice(model.getTotalPrice());
		
		return dto;
	}
	@Override
	protected OrderJoinModel dtoToModelTransform(OrderJoinModelDTO dto) {
		
		OrderJoinModel model = new OrderJoinModel();
		
		model.setCustomerName(dto.getCustomerName());
		model.setTimestamp(DateTimeUtil.localDateTimeToTimestamp(dto.getDateTime()));
		model.setGoodsName(dto.getGoodsName());
		model.setGoodsPrice(dto.getGoodsPrice());
		model.setBuyQuantity(dto.getBuyQuantity());
		model.setTotalPrice(dto.getTotalPrice());
		
		return model;
	}
}
