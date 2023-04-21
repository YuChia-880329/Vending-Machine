package transformer.model;

import bean.dto.model.GoodsModelDTO;
import bean.model.GoodsModel;
import enumeration.Status;
import template.transformer.bean.model.ModelTransformerTemplate;

public class GoodsModelTransformer extends ModelTransformerTemplate<GoodsModel, GoodsModelDTO> {

	private static final GoodsModelTransformer INSTANCE = new GoodsModelTransformer();
	
	private GoodsModelTransformer() {
	}
	
	public static GoodsModelTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	protected GoodsModelDTO modelToDtoTransform(GoodsModel model) {
		
		GoodsModelDTO dto = new GoodsModelDTO();
		
		dto.setId(model.getId());
		dto.setName(model.getName());
		dto.setDescription(model.getDescription());
		dto.setPrice(model.getPrice());
		dto.setQuantity(model.getQuantity());
		dto.setImageName(model.getImageName());
		dto.setStatus(Status.getByValue(Integer.parseInt(model.getStatus())));
		
		return dto;
	}

	@Override
	protected GoodsModel dtoToModelTransform(GoodsModelDTO dto) {
		
		GoodsModel model = new GoodsModel();
		
		Status status = dto.getStatus();
		
		model.setId(dto.getId());
		model.setName(dto.getName());
		model.setDescription(dto.getDescription());
		model.setPrice(dto.getPrice());
		model.setQuantity(dto.getQuantity());
		model.setImageName(dto.getImageName());
		model.setStatus(String.valueOf(status==null ? Status.OFF.getValue() : status.getValue()));
		
		return model;
	}
}
