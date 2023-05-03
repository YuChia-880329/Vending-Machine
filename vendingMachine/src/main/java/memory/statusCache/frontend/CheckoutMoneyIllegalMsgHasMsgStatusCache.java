package memory.statusCache.frontend;

import bean.obj.frontend.statusCache.checkoutMoneyIllegalMsg.CheckoutMoneyIllegalMsgHasMsgOBJ;
import template.memory.statusCache.StatusCacheTemplate;

public class CheckoutMoneyIllegalMsgHasMsgStatusCache extends StatusCacheTemplate<CheckoutMoneyIllegalMsgHasMsgOBJ> {

	@Override
	protected CheckoutMoneyIllegalMsgHasMsgOBJ ifNull() {
		
		return new CheckoutMoneyIllegalMsgHasMsgOBJ(false);
	}
}
