package transformer.frontend.obj.statusCache.checkoutMoneyIllegalMsgLine;

import bean.dto.frontend.obj.statusCache.checkoutMoneyIllegalMsgLineOBJ.CheckoutMoneyIllegalMsgHasMsgOBJDTO;
import bean.obj.frontend.statusCache.checkoutMoneyIllegalMsg.CheckoutMoneyIllegalMsgHasMsgOBJ;
import template.memory.statusCache.StatusCacheTransformerTemplate;

public class CheckoutMoneyIllegalMsgHasMsgOBJTransformer extends StatusCacheTransformerTemplate<CheckoutMoneyIllegalMsgHasMsgOBJ, CheckoutMoneyIllegalMsgHasMsgOBJDTO> {

	private static final CheckoutMoneyIllegalMsgHasMsgOBJTransformer INSTANCE = new CheckoutMoneyIllegalMsgHasMsgOBJTransformer();

	private CheckoutMoneyIllegalMsgHasMsgOBJTransformer() {
	}
	
	public static CheckoutMoneyIllegalMsgHasMsgOBJTransformer getInstance() {
		
		return INSTANCE;
	}
	
	
	@Override
	protected CheckoutMoneyIllegalMsgHasMsgOBJDTO objToDtoTransform(CheckoutMoneyIllegalMsgHasMsgOBJ obj) {
		
		CheckoutMoneyIllegalMsgHasMsgOBJDTO dto = new CheckoutMoneyIllegalMsgHasMsgOBJDTO();
		
		dto.setHasMsg(obj.getHasMsg());
		
		return dto;
	}

	@Override
	protected CheckoutMoneyIllegalMsgHasMsgOBJ dtoToObjTransform(CheckoutMoneyIllegalMsgHasMsgOBJDTO dto) {
		
		CheckoutMoneyIllegalMsgHasMsgOBJ obj = new CheckoutMoneyIllegalMsgHasMsgOBJ();
		
		obj.setHasMsg(dto.getHasMsg());
		
		return obj;
	}

}
