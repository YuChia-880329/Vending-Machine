package service.frontend.prepare;

import bean.dto.frontend.obj.statusCache.checkoutMoneyIllegalMsgLineOBJ.CheckoutMoneyIllegalMsgHasMsgOBJDTO;
import bean.dto.frontend.vo.writeout.CheckoutMoneyIllegalMsgVODTO;
import dao.memory.statusCache.frontend.CheckoutMoneyIllegalMsgStatusCacheDAO;

public class CheckoutMoneyIllegalMsgService {
	
	private static final CheckoutMoneyIllegalMsgService INSTANCE = new CheckoutMoneyIllegalMsgService();
	
	private CheckoutMoneyIllegalMsgService() {
	}
	
	public static CheckoutMoneyIllegalMsgService getInstance() {
		
		return INSTANCE;
	}
	
	public CheckoutMoneyIllegalMsgVODTO prepare(CheckoutMoneyIllegalMsgStatusCacheDAO checkoutMoneyIllegalMsgStatusCacheDAO) {
		
		CheckoutMoneyIllegalMsgVODTO checkoutMoneyIllegalMsgVODTO = new CheckoutMoneyIllegalMsgVODTO();
		
		CheckoutMoneyIllegalMsgHasMsgOBJDTO checkoutMoneyIllegalMsgHasMsgOBJDTO = checkoutMoneyIllegalMsgStatusCacheDAO.getStatus();
		
		checkoutMoneyIllegalMsgVODTO.setHasMsg(checkoutMoneyIllegalMsgHasMsgOBJDTO.getHasMsg());
		
		checkoutMoneyIllegalMsgStatusCacheDAO.setStatus(new CheckoutMoneyIllegalMsgHasMsgOBJDTO(false));
		
		return checkoutMoneyIllegalMsgVODTO;
	}
}
