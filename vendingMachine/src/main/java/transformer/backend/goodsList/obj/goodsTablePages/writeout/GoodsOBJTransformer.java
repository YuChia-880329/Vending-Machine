package transformer.backend.goodsList.obj.goodsTablePages.writeout;

import java.util.List;

import bean.dto.backend.goodsList.obj.repository.goodsTablePages.writeout.GoodsOBJDTO;
import bean.obj.backend.goodsList.repository.goodsTablePages.writeout.GoodsOBJ;
import template.transformer.BiTransformerTemplate;

public class GoodsOBJTransformer extends BiTransformerTemplate<GoodsOBJDTO, GoodsOBJ> {

	private static final GoodsOBJTransformer INSTANCE = new GoodsOBJTransformer();
	
	private GoodsOBJTransformer() {
		
	}
	
	public static GoodsOBJTransformer getInstance() {
		
		return INSTANCE;
	}
	
	
	public GoodsOBJ dtoToObj(GoodsOBJDTO dto) {
		
		GoodsOBJ obj = new GoodsOBJ();
		
		obj.setId(dto.getId());
		obj.setName(dto.getName());
		obj.setDescription(dto.getDescription());
		obj.setPrice(dto.getPrice());
		obj.setQuantity(dto.getQuantity());
		obj.setImageName(dto.getImageName());
		obj.setStatus(dto.getStatus());
		
		return obj;
	}
	public GoodsOBJDTO objToDto(GoodsOBJ obj) {
		
		GoodsOBJDTO dto = new GoodsOBJDTO();
		
		dto.setId(obj.getId());
		dto.setName(obj.getName());
		dto.setDescription(obj.getDescription());
		dto.setPrice(obj.getPrice());
		dto.setQuantity(obj.getQuantity());
		dto.setImageName(obj.getImageName());
		dto.setStatus(obj.getStatus());
		
		return dto;
	}
	
	
	public List<GoodsOBJ> dtoListToObjList(List<GoodsOBJDTO> dtoList){
		
		return aListToBList(dtoList);
	}
	public List<GoodsOBJDTO> objListToDtoList(List<GoodsOBJ> objList){
		
		return bListToAList(objList);
	}



	

	@Override
	public GoodsOBJ aToB(GoodsOBJDTO dto) {

		return dtoToObj(dto);
	}
	@Override
	public GoodsOBJDTO bToA(GoodsOBJ obj) {
		
		return objToDto(obj);
	}
}
