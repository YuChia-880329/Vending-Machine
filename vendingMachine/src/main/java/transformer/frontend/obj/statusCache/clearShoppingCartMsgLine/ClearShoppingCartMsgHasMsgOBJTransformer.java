package transformer.frontend.obj.statusCache.clearShoppingCartMsgLine;

import bean.dto.frontend.obj.statusCache.clearShoppingCartMsgLine.ClearShoppingCartMsgHasMsgOBJDTO;
import bean.obj.frontend.statusCache.clearShoppingCartMsg.ClearShoppingCartMsgHasMsgOBJ;
import template.memory.cache.CacheTransformerTemplate;
import template.memory.statusCache.StatusCacheTransformerTemplate;

public class ClearShoppingCartMsgHasMsgOBJTransformer extends StatusCacheTransformerTemplate<ClearShoppingCartMsgHasMsgOBJ, ClearShoppingCartMsgHasMsgOBJDTO> {
	
	private static final ClearShoppingCartMsgHasMsgOBJTransformer INSTANCE = new ClearShoppingCartMsgHasMsgOBJTransformer();

	private ClearShoppingCartMsgHasMsgOBJTransformer() {
	}
	
	public static ClearShoppingCartMsgHasMsgOBJTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	protected ClearShoppingCartMsgHasMsgOBJDTO objToDtoTransform(ClearShoppingCartMsgHasMsgOBJ obj) {
		
		ClearShoppingCartMsgHasMsgOBJDTO dto = new ClearShoppingCartMsgHasMsgOBJDTO();

		dto.setHasMsg(obj.getHasMsg());
		
		return dto;
	}

	@Override
	protected ClearShoppingCartMsgHasMsgOBJ dtoToObjTransform(ClearShoppingCartMsgHasMsgOBJDTO dto) {
		
		ClearShoppingCartMsgHasMsgOBJ obj = new ClearShoppingCartMsgHasMsgOBJ();
		
		obj.setHasMsg(dto.getHasMsg());
		
		return obj;
	}
}
