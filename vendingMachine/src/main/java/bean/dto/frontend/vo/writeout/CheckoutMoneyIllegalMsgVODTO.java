package bean.dto.frontend.vo.writeout;

import enumeration.Has;

public class CheckoutMoneyIllegalMsgVODTO {

	private Has hasMsg;

	public CheckoutMoneyIllegalMsgVODTO() {
	}
	public CheckoutMoneyIllegalMsgVODTO(Has hasMsg) {

		this.hasMsg = hasMsg;
	}
	
	
	public Has getHasMsg() {
		return hasMsg;
	}
	
	
	public void setHasMsg(Has hasMsg) {
		this.hasMsg = hasMsg;
	}
}
