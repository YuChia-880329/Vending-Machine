package temp.bean.vo.frontend.writeout;

import bean.vo.frontend.writeout.CheckoutMoneyIllegalMsgVO;

public class CheckoutResultVO {

	private CheckoutMoneyIllegalMsgVO checkoutMoneyIllegalMsg;

	public CheckoutResultVO() {
	}
	public CheckoutResultVO(CheckoutMoneyIllegalMsgVO checkoutMoneyIllegalMsg) {

		this.checkoutMoneyIllegalMsg = checkoutMoneyIllegalMsg;
	}
	
	
	public CheckoutMoneyIllegalMsgVO getCheckoutMoneyIllegalMsg() {
		return checkoutMoneyIllegalMsg;
	}
	
	
	public void setCheckoutMoneyIllegalMsg(CheckoutMoneyIllegalMsgVO checkoutMoneyIllegalMsg) {
		this.checkoutMoneyIllegalMsg = checkoutMoneyIllegalMsg;
	}
}
