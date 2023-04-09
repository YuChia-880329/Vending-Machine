package transformer.model;

import bean.dto.model.OrderModelDTO;
import bean.model.OrderModel;
import template.database.ModelTransformerTemplate;
import util.DateTimeUtil;

public class OrderModelTransformer extends ModelTransformerTemplate<OrderModel, OrderModelDTO> {

	private static final OrderModelTransformer INSTANCE = new OrderModelTransformer();
	
	private OrderModelTransformer() {
	}
	
	public static OrderModelTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	public OrderModelDTO modelToDto(OrderModel model) {

		OrderModelDTO dto = new OrderModelDTO();
		
		dto.setId(model.getId());
		dto.setDateTime(DateTimeUtil.timestampToLocalDateTime(model.getDateTime()));
		dto.setCustomerId(model.getCustomerId());
		dto.setGoodId(model.getGoodId());
		dto.setPrice(model.getPrice());
		dto.setQuantity(model.getQuantity());
		
		return dto;
	}

	@Override
	public OrderModel dtoToModel(OrderModelDTO dto) {

		OrderModel model = new OrderModel();
		
		model.setId(dto.getId());
		model.setDateTime(DateTimeUtil.localDateTimeToTimestamp(dto.getDateTime()));
		model.setCustomerId(dto.getCustomerId());
		model.setGoodId(dto.getGoodId());
		model.setPrice(dto.getPrice());
		model.setQuantity(dto.getQuantity());
		
		return model;
	}
}
