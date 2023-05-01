package memory.statusCache.frontend;

import bean.obj.frontend.statusCache.clearShoppingCartMsg.ClearShoppingCartMsgHasMsgOBJ;
import enumeration.Has;
import template.memory.statusCache.StatusCacheTemplate;

public class ClearShoppingCartMsgHasMsgStatusCache extends StatusCacheTemplate<ClearShoppingCartMsgHasMsgOBJ> {

	@Override
	protected ClearShoppingCartMsgHasMsgOBJ initStatus() {
		
		return new ClearShoppingCartMsgHasMsgOBJ(Has.FALSE);
	}
}
