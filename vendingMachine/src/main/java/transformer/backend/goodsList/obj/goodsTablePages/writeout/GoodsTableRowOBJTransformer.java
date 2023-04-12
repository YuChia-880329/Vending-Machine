package transformer.backend.goodsList.obj.goodsTablePages.writeout;

import java.util.List;

import bean.dto.backend.goodsList.obj.repository.goodsTablePages.writeout.GoodsTableRowOBJDTO;
import bean.obj.backend.goodsList.repository.goodsTablePages.writeout.GoodsTableRowOBJ;
import template.transformer.BiTransformerTemplate;

public class GoodsTableRowOBJTransformer extends BiTransformerTemplate<GoodsTableRowOBJDTO, GoodsTableRowOBJ> {

	private static final GoodsTableRowOBJTransformer INSTANCE = new GoodsTableRowOBJTransformer();
	
	private GoodsTableRowOBJTransformer() {
		
	}
	
	public static GoodsTableRowOBJTransformer getInstance() {
		
		return INSTANCE;
	}
	
	
	public GoodsTableRowOBJ dtoToObj(GoodsTableRowOBJDTO dto) {
		
		GoodsTableRowOBJ obj = new GoodsTableRowOBJ();
		
		obj.setId(dto.getId());
		obj.setName(dto.getName());
		obj.setPrice(dto.getPrice());
		obj.setQuantity(dto.getQuantity());
		obj.setStatus(dto.getStatus());
		
		return obj;
	}
	public GoodsTableRowOBJDTO objToDto(GoodsTableRowOBJ obj) {
		
		GoodsTableRowOBJDTO dto = new GoodsTableRowOBJDTO();
		
		dto.setId(obj.getId());
		dto.setName(obj.getName());
		dto.setPrice(obj.getPrice());
		dto.setQuantity(obj.getQuantity());
		dto.setStatus(obj.getStatus());
		
		return dto;
	}
	
	
	public List<GoodsTableRowOBJ> dtoListToObjList(List<GoodsTableRowOBJDTO> dtoList){
		
		return aListToBList(dtoList);
	}
	public List<GoodsTableRowOBJDTO> objListToDtoList(List<GoodsTableRowOBJ> objList){
		
		return bListToAList(objList);
	}



	

	@Override
	public GoodsTableRowOBJ aToB(GoodsTableRowOBJDTO dto) {

		return dtoToObj(dto);
	}
	@Override
	public GoodsTableRowOBJDTO bToA(GoodsTableRowOBJ obj) {
		
		return objToDto(obj);
	}
}
