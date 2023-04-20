package transformer.frontend.obj.repository.goodsTablePages.writeout;

import java.util.List;

import bean.dto.frontend.obj.repository.goodsTablePages.writeout.GoodsTableEntryOBJDTO;
import bean.obj.frontend.repository.goodsTablePages.writeout.GoodsTableEntryOBJ;
import template.transformer.BiTransformerTemplate;

public class GoodsTableEntryOBJTransformer extends BiTransformerTemplate<GoodsTableEntryOBJDTO, GoodsTableEntryOBJ> {

	private GoodsCardOBJTransformer goodsCardOBJTransformer;
	private GoodsIntroductionOBJTransformer goodsIntroductionOBJTransformer;
	
	
	private static final GoodsTableEntryOBJTransformer INSTANCE = new GoodsTableEntryOBJTransformer();
	
	private GoodsTableEntryOBJTransformer() {
		
		goodsCardOBJTransformer = GoodsCardOBJTransformer.getInstance();
		goodsIntroductionOBJTransformer = GoodsIntroductionOBJTransformer.getInstance();
	}
	
	public static GoodsTableEntryOBJTransformer getInstance() {
		
		return INSTANCE;
	}
	
	
	public GoodsTableEntryOBJDTO objToDto(GoodsTableEntryOBJ obj) {
		
		return bToA(obj);
	}
	public GoodsTableEntryOBJ dtoToObj(GoodsTableEntryOBJDTO dto) {
		
		return aToB(dto);
	}
	public List<GoodsTableEntryOBJDTO> objListToDtoList(List<GoodsTableEntryOBJ> objList) {
		
		return bListToAList(objList);
	}
	public List<GoodsTableEntryOBJ> dtoListToObjList(List<GoodsTableEntryOBJDTO> dtoList) {
		
		return aListToBList(dtoList);
	}
	

	private GoodsTableEntryOBJDTO objToDtoTransform(GoodsTableEntryOBJ obj) {
		
		GoodsTableEntryOBJDTO dto = new GoodsTableEntryOBJDTO();
		
		dto.setId(obj.getId());
		dto.setGoodsCard(goodsCardOBJTransformer.objToDto(obj.getGoodsCard()));
		dto.setGoodsIntroduction(goodsIntroductionOBJTransformer.objToDto(obj.getGoodsIntroduction()));
		
		return dto;
	}
	private GoodsTableEntryOBJ dtoToObjTransform(GoodsTableEntryOBJDTO dto) {
		
		GoodsTableEntryOBJ obj = new GoodsTableEntryOBJ();
		
		obj.setId(dto.getId());
		obj.setGoodsCard(goodsCardOBJTransformer.dtoToObj(dto.getGoodsCard()));
		obj.setGoodsIntroduction(goodsIntroductionOBJTransformer.dtoToObj(dto.getGoodsIntroduction()));
		
		return obj;
	}

	

	@Override
	protected GoodsTableEntryOBJDTO bToATransform(GoodsTableEntryOBJ obj) {
		
		return objToDtoTransform(obj);
	}
	@Override
	protected GoodsTableEntryOBJ aToBTransform(GoodsTableEntryOBJDTO dto) {

		return dtoToObjTransform(dto);
	}
}
