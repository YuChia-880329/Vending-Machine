package memory.repository.backend.goodsList.goodsTablePages;

import bean.dto.model.GoodsModelDTO;
import template.transformer.TransformerTemplate;

class GoodsModelTransformer extends TransformerTemplate<GoodsModelDTO, GoodsObj> {

	private static final GoodsModelTransformer INSTANCE = new GoodsModelTransformer();
	
	private GoodsModelTransformer() {
		
	}
	
	public static GoodsModelTransformer getInstance() {
		
		return INSTANCE;
	}
	
	
	@Override
	public GoodsObj aToB(GoodsModelDTO dto) {

		return dtoToObj(dto);
	}

	public GoodsObj dtoToObj(GoodsModelDTO dto) {
		
		GoodsObj obj = new GoodsObj();
		
		obj.setId(dto.getId());
		obj.setName(dto.getName());
		obj.setDescription(dto.getDescription());
		obj.setPrice(dto.getPrice());
		obj.setQuantity(dto.getQuantity());
		obj.setImageName(dto.getImageName());
		obj.setStatus(dto.getStatus());
		
		return obj;
	}
}
