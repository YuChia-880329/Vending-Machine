package dao.memory.statusCache.frontend;

import bean.dto.frontend.obj.statusCache.checkoutMoneyIllegalMsgHasMsg.CheckoutMoneyIllegalMsgHasMsgOBJDTO;
import bean.obj.frontend.statusCache.checkoutMoneyIllegalMsgHasMsg.CheckoutMoneyIllegalMsgHasMsgOBJ;
import memory.statusCache.frontend.CheckoutMoneyIllegalMsgHasMsgStatusCache;
import template.memory.statusCache.StatusCacheDAOTemplate;
import transformer.frontend.obj.statusCache.checkoutMoneyIllegalMsgHasMsg.CheckoutMoneyIllegalMsgHasMsgOBJTransformer;

public class CheckoutMoneyIllegalMsgStatusCacheDAO extends StatusCacheDAOTemplate<CheckoutMoneyIllegalMsgHasMsgOBJ, CheckoutMoneyIllegalMsgHasMsgStatusCache, 
					CheckoutMoneyIllegalMsgHasMsgOBJDTO, CheckoutMoneyIllegalMsgHasMsgOBJTransformer> {

	public static final String SESSION_ATTR_DAO = "checkoutMoneyIllegalMsgLineStatusCacheDAO";
	
	public CheckoutMoneyIllegalMsgStatusCacheDAO() {
		
		super(getInitialStatusCache());
	}
	
	private static CheckoutMoneyIllegalMsgHasMsgStatusCache getInitialStatusCache() {
		
		CheckoutMoneyIllegalMsgHasMsgStatusCache statusCache = new CheckoutMoneyIllegalMsgHasMsgStatusCache();
		
		return statusCache;
	}

	@Override
	protected CheckoutMoneyIllegalMsgHasMsgOBJTransformer getTransformer() {
		
		return CheckoutMoneyIllegalMsgHasMsgOBJTransformer.getInstance();
	}

}
