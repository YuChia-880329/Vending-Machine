package temp.bean.vo.frontend.writeout;

import bean.vo.frontend.writeout.UpdateShoppingCartIllegalMsgVO;
import bean.vo.frontend.writeout.UpdateShoppingCartLegalMsgVO;

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
