package temp.bean.dto.frontend.vo.writeout;

import bean.dto.frontend.vo.writeout.CheckoutMoneyIllegalMsgVODTO;

public class CheckoutResultVODTO {

	private CheckoutMoneyIllegalMsgVODTO checkoutMoneyIllegalMsg;

	public CheckoutResultVODTO() {
	}
	public CheckoutResultVODTO(CheckoutMoneyIllegalMsgVODTO checkoutMoneyIllegalMsg) {

		this.checkoutMoneyIllegalMsg = checkoutMoneyIllegalMsg;
	}
	
	
	public CheckoutMoneyIllegalMsgVODTO getCheckoutMoneyIllegalMsg() {
		return checkoutMoneyIllegalMsg;
	}
	
	
	public void setCheckoutMoneyIllegalMsg(CheckoutMoneyIllegalMsgVODTO checkoutMoneyIllegalMsg) {
		this.checkoutMoneyIllegalMsg = checkoutMoneyIllegalMsg;
	}
}
