package bean.vo.frontend.writeout;

public class UpdateShoppingCartResultVO {

	private UpdateShoppingCartIllegalMsgVO updateShoppingCartIllegalMsg;
	private UpdateShoppingCartLegalMsgVO updateShoppingCartLegalMsg;
	
	
	public UpdateShoppingCartResultVO() {
	}
	public UpdateShoppingCartResultVO(UpdateShoppingCartIllegalMsgVO updateShoppingCartIllegalMsg,
			UpdateShoppingCartLegalMsgVO updateShoppingCartLegalMsg) {

		this.updateShoppingCartIllegalMsg = updateShoppingCartIllegalMsg;
		this.updateShoppingCartLegalMsg = updateShoppingCartLegalMsg;
	}
	
	
	public UpdateShoppingCartIllegalMsgVO getUpdateShoppingCartIllegalMsg() {
		return updateShoppingCartIllegalMsg;
	}
	public UpdateShoppingCartLegalMsgVO getUpdateShoppingCartLegalMsg() {
		return updateShoppingCartLegalMsg;
	}
	
	
	public void setUpdateShoppingCartIllegalMsg(UpdateShoppingCartIllegalMsgVO updateShoppingCartIllegalMsg) {
		this.updateShoppingCartIllegalMsg = updateShoppingCartIllegalMsg;
	}
	public void setUpdateShoppingCartLegalMsg(UpdateShoppingCartLegalMsgVO updateShoppingCartLegalMsg) {
		this.updateShoppingCartLegalMsg = updateShoppingCartLegalMsg;
	}
}
