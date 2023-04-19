package transformer.frontend.obj.goodsTablePages.writeout;

import java.util.List;

import bean.dto.frontend.obj.repository.goodsTablePages.writeout.GoodsCardOBJDTO;
import bean.obj.frontend.repository.goodsTablePages.writeout.GoodsCardOBJ;
import template.transformer.BiTransformerTemplate;

public class GoodsCardOBJTransformer extends BiTransformerTemplate<GoodsCardOBJDTO, GoodsCardOBJ> {

	private static final GoodsCardOBJTransformer INSTANCE = new GoodsCardOBJTransformer();
	
	private GoodsCardOBJTransformer() {
		
	}
	
	public static GoodsCardOBJTransformer getInstance() {
		
		return INSTANCE;
	}
	
	public GoodsCardOBJDTO objToDto(GoodsCardOBJ obj) {
		
		return bToA(obj);
	}
	public GoodsCardOBJ dtoToObj(GoodsCardOBJDTO dto) {
		
		return aToB(dto);
	}
	public List<GoodsCardOBJDTO> objListToDtoList(List<GoodsCardOBJ> objList) {
		
		return bListToAList(objList);
	}
	public List<GoodsCardOBJ> dtoListToObjList(List<GoodsCardOBJDTO> dtoList) {
		
		return aListToBList(dtoList);
	}
	
	
	private GoodsCardOBJDTO objToDtoTransform(GoodsCardOBJ obj) {
		
		GoodsCardOBJDTO dto = new GoodsCardOBJDTO();
		
		dto.setName(obj.getName());
		dto.setPrice(obj.getPrice());
		dto.setImageName(obj.getImageName());
		dto.setQuantity(obj.getQuantity());
		
		return dto;
	}
	private GoodsCardOBJ dtoToObjTransform(GoodsCardOBJDTO dto) {
		
		GoodsCardOBJ obj = new GoodsCardOBJ();
		
		obj.setName(dto.getName());
		obj.setPrice(dto.getPrice());
		obj.setImageName(dto.getImageName());
		obj.setQuantity(dto.getQuantity());
		
		return obj;
	}

	@Override
	protected GoodsCardOBJDTO bToATransform(GoodsCardOBJ obj) {
		
		return objToDtoTransform(obj);
	}
	@Override
	protected GoodsCardOBJ aToBTransform(GoodsCardOBJDTO dto) {
		
		return dtoToObjTransform(dto);
	}
}
