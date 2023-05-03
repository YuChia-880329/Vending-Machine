package memory.statusCache.frontend;

import bean.obj.frontend.statusCache.clearShoppingCartMsg.ClearShoppingCartMsgHasMsgOBJ;
import template.memory.statusCache.StatusCacheTemplate;

public class ClearShoppingCartMsgHasMsgStatusCache extends StatusCacheTemplate<ClearShoppingCartMsgHasMsgOBJ> {

	@Override
	protected ClearShoppingCartMsgHasMsgOBJ ifNull() {
		
		return new ClearShoppingCartMsgHasMsgOBJ(false);
	}
}
