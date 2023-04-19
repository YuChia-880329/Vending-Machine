package transformer.frontend.obj.goodsTablePages.writeout;

import java.util.List;

import bean.dto.frontend.obj.repository.goodsTablePages.writeout.GoodsIntroductionOBJDTO;
import bean.obj.frontend.repository.goodsTablePages.writeout.GoodsIntroductionOBJ;
import template.transformer.BiTransformerTemplate;

public class GoodsIntroductionOBJTransformer extends BiTransformerTemplate<GoodsIntroductionOBJDTO, GoodsIntroductionOBJ> {

	private static final GoodsIntroductionOBJTransformer INSTANCE = new GoodsIntroductionOBJTransformer();
	
	private GoodsIntroductionOBJTransformer() {
		
	}
	
	public static GoodsIntroductionOBJTransformer getInstance() {
		
		return INSTANCE;
	}
	
	public GoodsIntroductionOBJDTO objToDto(GoodsIntroductionOBJ obj) {
		
		return bToA(obj);
	}
	public GoodsIntroductionOBJ dtoToObj(GoodsIntroductionOBJDTO dto) {
		
		return aToB(dto);
	}
	public List<GoodsIntroductionOBJDTO> objListToDtoList(List<GoodsIntroductionOBJ> objList) {
		
		return bListToAList(objList);
	}
	public List<GoodsIntroductionOBJ> dtoListToObjList(List<GoodsIntroductionOBJDTO> dtoList) {
		
		return aListToBList(dtoList);
	}
	

	private GoodsIntroductionOBJDTO objToDtoTransform(GoodsIntroductionOBJ obj) {
		
		GoodsIntroductionOBJDTO dto = new GoodsIntroductionOBJDTO();
		
		dto.setName(obj.getName());
		dto.setImageName(obj.getImageName());
		dto.setDescription(obj.getDescription());
		dto.setPrice(obj.getPrice());
		dto.setQuantity(obj.getQuantity());
		
		return dto;
	}
	private GoodsIntroductionOBJ dtoToObjTransform(GoodsIntroductionOBJDTO dto) {
		
		GoodsIntroductionOBJ obj = new GoodsIntroductionOBJ();
				
		obj.setName(obj.getName());
		obj.setImageName(obj.getImageName());
		obj.setDescription(obj.getDescription());
		obj.setPrice(obj.getPrice());
		obj.setQuantity(obj.getQuantity());
		
		return obj;
	}
	@Override
	protected GoodsIntroductionOBJDTO bToATransform(GoodsIntroductionOBJ obj) {
		
		return objToDtoTransform(obj);
	}
	@Override
	protected GoodsIntroductionOBJ aToBTransform(GoodsIntroductionOBJDTO dto) {
		
		return dtoToObjTransform(dto);
	}
}
