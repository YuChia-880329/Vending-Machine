package transformer.model;

import bean.dto.model.OrderModelDTO;
import bean.model.OrderModel;
import template.transformer.bean.model.ModelTransformerTemplate;
import util.DateTimeUtil;

public class OrderModelTransformer extends ModelTransformerTemplate<OrderModel, OrderModelDTO> {

	private static final OrderModelTransformer INSTANCE = new OrderModelTransformer();
	
	private OrderModelTransformer() {
	}
	
	public static OrderModelTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	protected OrderModelDTO modelToDtoTransform(OrderModel model) {

		OrderModelDTO dto = new OrderModelDTO();
		
		dto.setId(model.getId());
		dto.setDateTime(DateTimeUtil.timestampToLocalDateTime(model.getTimestamp()));
		dto.setCustomerId(model.getCustomerId());
		dto.setGoodsId(model.getGoodsId());
		dto.setGoodsPrice(model.getGoodsPrice());
		dto.setBuyQuantity(model.getBuyQuantity());
		
		return dto;
	}

	@Override
	protected OrderModel dtoToModelTransform(OrderModelDTO dto) {

		OrderModel model = new OrderModel();
		
		model.setId(dto.getId());
		model.setTimestamp(DateTimeUtil.localDateTimeToTimestamp(dto.getDateTime()));
		model.setCustomerId(dto.getCustomerId());
		model.setGoodsId(dto.getGoodsId());
		model.setGoodsPrice(dto.getGoodsPrice());
		model.setBuyQuantity(dto.getBuyQuantity());
		
		return model;
	}
}
