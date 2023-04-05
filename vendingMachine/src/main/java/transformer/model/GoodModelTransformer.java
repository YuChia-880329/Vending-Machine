package transformer.model;

import bean.dto.model.GoodModelDTO;
import bean.model.GoodModel;
import enumeration.Status;
import template.transformer.bean.model.ModelTransformerTemplate;

public class GoodModelTransformer extends ModelTransformerTemplate<GoodModel, GoodModelDTO> {

	private static final GoodModelTransformer INSTANCE = new GoodModelTransformer();
	
	private GoodModelTransformer() {
	}
	
	public static GoodModelTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	public GoodModelDTO modelToDto(GoodModel model) {
		
		GoodModelDTO dto = new GoodModelDTO();
		
		dto.setId(model.getId());
		dto.setName(model.getName());
		dto.setDescription(model.getDescription());
		dto.setPrice(model.getPrice());
		dto.setQuantity(model.getQuantity());
		dto.setImageName(model.getImageName());
		dto.setStatus(Status.getByDescription(model.getStatus()));
		
		return dto;
	}

	@Override
	public GoodModel dtoToModel(GoodModelDTO dto) {
		
		GoodModel model = new GoodModel();
		
		model.setId(dto.getId());
		model.setName(dto.getName());
		model.setDescription(dto.getDescription());
		model.setPrice(dto.getPrice());
		model.setQuantity(dto.getQuantity());
		model.setImageName(dto.getImageName());
		model.setStatus(dto.getStatus().getDescription());
		
		return model;
	}
}
