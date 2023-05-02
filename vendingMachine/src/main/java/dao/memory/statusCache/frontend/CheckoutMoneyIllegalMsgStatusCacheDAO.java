package dao.memory.statusCache.frontend;

import bean.dto.frontend.obj.statusCache.checkoutMoneyIllegalMsgLineOBJ.CheckoutMoneyIllegalMsgHasMsgOBJDTO;
import bean.obj.frontend.statusCache.checkoutMoneyIllegalMsg.CheckoutMoneyIllegalMsgHasMsgOBJ;
import memory.statusCache.frontend.CheckoutMoneyIllegalMsgHasMsgStatusCache;
import template.memory.statusCache.StatusCacheDAOTemplate;
import transformer.frontend.obj.statusCache.checkoutMoneyIllegalMsgLine.CheckoutMoneyIllegalMsgHasMsgOBJTransformer;

public class CheckoutMoneyIllegalMsgStatusCacheDAO extends StatusCacheDAOTemplate<CheckoutMoneyIllegalMsgHasMsgOBJ, CheckoutMoneyIllegalMsgHasMsgStatusCache, CheckoutMoneyIllegalMsgHasMsgOBJDTO, CheckoutMoneyIllegalMsgHasMsgOBJTransformer> {

	public static final String SESSION_ATTR_DAO = "checkoutMoneyIllegalMsgLineStatusCacheDAO";
	
	public CheckoutMoneyIllegalMsgStatusCacheDAO(CheckoutMoneyIllegalMsgHasMsgStatusCache cache) {
		
		super(cache);
	}

	@Override
	protected CheckoutMoneyIllegalMsgHasMsgOBJTransformer getTransformer() {
		
		return CheckoutMoneyIllegalMsgHasMsgOBJTransformer.getInstance();
	}

}
