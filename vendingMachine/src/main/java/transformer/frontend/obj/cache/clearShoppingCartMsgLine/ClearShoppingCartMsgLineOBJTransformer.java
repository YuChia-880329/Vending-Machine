package transformer.frontend.obj.cache.clearShoppingCartMsgLine;

import bean.dto.frontend.obj.cache.clearShoppingCartMsgLine.ClearShoppingCartMsgLineOBJDTO;
import bean.obj.frontend.cache.clearShoppingCartMsgLine.ClearShoppingCartMsgLineOBJ;
import template.memory.cache.CacheTransformerTemplate;

public class ClearShoppingCartMsgLineOBJTransformer extends CacheTransformerTemplate<ClearShoppingCartMsgLineOBJ, ClearShoppingCartMsgLineOBJDTO> {
	
	private static final ClearShoppingCartMsgLineOBJTransformer INSTANCE = new ClearShoppingCartMsgLineOBJTransformer();

	private ClearShoppingCartMsgLineOBJTransformer() {
	}
	
	public static ClearShoppingCartMsgLineOBJTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	protected ClearShoppingCartMsgLineOBJDTO objToDtoTransform(ClearShoppingCartMsgLineOBJ obj) {
		
		ClearShoppingCartMsgLineOBJDTO dto = new ClearShoppingCartMsgLineOBJDTO();

		dto.setHasMsg(obj.getHasMsg());
		
		return dto;
	}

	@Override
	protected ClearShoppingCartMsgLineOBJ dtoToObjTransform(ClearShoppingCartMsgLineOBJDTO dto) {
		
		ClearShoppingCartMsgLineOBJ obj = new ClearShoppingCartMsgLineOBJ();
		
		obj.setHasMsg(dto.getHasMsg());
		
		return obj;
	}
}
