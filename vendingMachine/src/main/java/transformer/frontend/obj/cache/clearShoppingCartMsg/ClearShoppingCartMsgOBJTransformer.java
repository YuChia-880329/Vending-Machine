package transformer.frontend.obj.cache.clearShoppingCartMsg;

import bean.dto.frontend.obj.cache.clearShoppingCartMsg.ClearShoppingCartMsgOBJDTO;
import bean.obj.frontend.cache.clearShoppingCartMsg.ClearShoppingCartMsgOBJ;
import template.memory.cache.CacheTransformerTemplate;

public class ClearShoppingCartMsgOBJTransformer extends CacheTransformerTemplate<ClearShoppingCartMsgOBJ, ClearShoppingCartMsgOBJDTO> {
	
	private static final ClearShoppingCartMsgOBJTransformer INSTANCE = new ClearShoppingCartMsgOBJTransformer();

	private ClearShoppingCartMsgOBJTransformer() {
	}
	
	public static ClearShoppingCartMsgOBJTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	protected ClearShoppingCartMsgOBJDTO objToDtoTransform(ClearShoppingCartMsgOBJ obj) {
		
		ClearShoppingCartMsgOBJDTO dto = new ClearShoppingCartMsgOBJDTO();

		dto.setHasMsg(obj.getHasMsg());
		
		return dto;
	}

	@Override
	protected ClearShoppingCartMsgOBJ dtoToObjTransform(ClearShoppingCartMsgOBJDTO dto) {
		
		ClearShoppingCartMsgOBJ obj = new ClearShoppingCartMsgOBJ();
		
		obj.setHasMsg(dto.getHasMsg());
		
		return obj;
	}
}
