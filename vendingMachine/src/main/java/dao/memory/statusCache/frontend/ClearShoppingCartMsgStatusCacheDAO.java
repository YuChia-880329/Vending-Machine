package dao.memory.statusCache.frontend;

import bean.dto.frontend.obj.statusCache.clearShoppingCartMsgLine.ClearShoppingCartMsgHasMsgOBJDTO;
import bean.obj.frontend.statusCache.clearShoppingCartMsg.ClearShoppingCartMsgHasMsgOBJ;
import memory.statusCache.frontend.ClearShoppingCartMsgHasMsgStatusCache;
import template.memory.statusCache.StatusCacheDAOTemplate;
import transformer.frontend.obj.statusCache.clearShoppingCartMsgLine.ClearShoppingCartMsgHasMsgOBJTransformer;

public class ClearShoppingCartMsgStatusCacheDAO extends StatusCacheDAOTemplate<ClearShoppingCartMsgHasMsgOBJ, ClearShoppingCartMsgHasMsgStatusCache, 
				ClearShoppingCartMsgHasMsgOBJDTO, ClearShoppingCartMsgHasMsgOBJTransformer> {

	public static final String SESSION_ATTR_DAO = "clearShoppingCartMsgLineStatusCacheDAO";
	
	public ClearShoppingCartMsgStatusCacheDAO(ClearShoppingCartMsgHasMsgStatusCache memory) {
		
		super(memory);
	}
	

	@Override
	protected ClearShoppingCartMsgHasMsgOBJTransformer getTransformer() {
		
		return ClearShoppingCartMsgHasMsgOBJTransformer.getInstance();
	}

}
