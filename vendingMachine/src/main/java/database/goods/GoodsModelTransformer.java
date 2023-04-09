package database.goods;

import bean.dto.model.GoodsModelDTO;
import enumeration.Status;
import template.database.ModelTransformerTemplate;

class GoodsModelTransformer extends ModelTransformerTemplate<GoodsModel, GoodsModelDTO> {

	private static final GoodsModelTransformer INSTANCE = new GoodsModelTransformer();
	
	private GoodsModelTransformer() {
	}
	
	public static GoodsModelTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	public GoodsModelDTO modelToDto(GoodsModel model) {
		
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
	public GoodsModel dtoToModel(GoodsModelDTO dto) {
		
		GoodsModel model = new GoodsModel();
		
		model.setId(dto.getId());
		model.setName(dto.getName());
		model.setDescription(dto.getDescription());
		model.setPrice(dto.getPrice());
		model.setQuantity(dto.getQuantity());
		model.setImageName(dto.getImageName());
		model.setStatus(String.valueOf(dto.getStatus().getValue()));
		
		return model;
	}
}
