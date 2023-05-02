package bean.dto.frontend.vo.writeout;

public class CheckoutMoneyIllegalMsgVODTO {

	private boolean hasMsg;

	public CheckoutMoneyIllegalMsgVODTO() {
	}
	public CheckoutMoneyIllegalMsgVODTO(boolean hasMsg) {

		this.hasMsg = hasMsg;
	}
	
	
	public boolean getHasMsg() {
		return hasMsg;
	}
	
	
	public void setHasMsg(boolean hasMsg) {
		this.hasMsg = hasMsg;
	}
}
