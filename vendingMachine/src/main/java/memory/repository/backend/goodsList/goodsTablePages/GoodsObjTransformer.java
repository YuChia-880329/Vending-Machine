package memory.repository.backend.goodsList.goodsTablePages;

import java.util.List;

import bean.dto.model.GoodsModelDTO;
import template.transformer.BiTransformerTemplate;

class GoodsObjTransformer extends BiTransformerTemplate<GoodsModelDTO, GoodsObj> {

	private static final GoodsObjTransformer INSTANCE = new GoodsObjTransformer();
	
	private GoodsObjTransformer() {
		
	}
	
	static GoodsObjTransformer getInstance() {
		
		return INSTANCE;
	}
	
	
	GoodsObj dtoToObj(GoodsModelDTO dto) {
		
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
	GoodsModelDTO objToDto(GoodsObj obj) {
		
		GoodsModelDTO dto = new GoodsModelDTO();
		
		dto.setId(obj.getId());
		dto.setName(obj.getName());
		dto.setDescription(obj.getDescription());
		dto.setPrice(obj.getPrice());
		dto.setQuantity(obj.getQuantity());
		dto.setImageName(obj.getImageName());
		dto.setStatus(obj.getStatus());
		
		return dto;
	}
	
	
	List<GoodsObj> dtoListToObjList(List<GoodsModelDTO> dtoList){
		
		return aListToBList(dtoList);
	}
	List<GoodsModelDTO> objListToDtoList(List<GoodsObj> objList){
		
		return bListToAList(objList);
	}



	

	@Override
	public GoodsObj aToB(GoodsModelDTO dto) {

		return dtoToObj(dto);
	}
	@Override
	public GoodsModelDTO bToA(GoodsObj obj) {
		
		return objToDto(obj);
	}
}
