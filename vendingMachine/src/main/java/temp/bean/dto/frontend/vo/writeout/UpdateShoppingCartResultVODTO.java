package temp.bean.dto.frontend.vo.writeout;

import bean.dto.frontend.vo.writeout.UpdateShoppingCartIllegalMsgVODTO;
import bean.dto.frontend.vo.writeout.UpdateShoppingCartLegalMsgVODTO;

public class UpdateShoppingCartResultVODTO {

	private UpdateShoppingCartIllegalMsgVODTO updateShoppingCartIllegalMsg;
	private UpdateShoppingCartLegalMsgVODTO updateShoppingCartLegalMsg;
	
	
	public UpdateShoppingCartResultVODTO() {
	}
	public UpdateShoppingCartResultVODTO(UpdateShoppingCartIllegalMsgVODTO updateShoppingCartIllegalMsg,
			UpdateShoppingCartLegalMsgVODTO updateShoppingCartLegalMsg) {
		
		this.updateShoppingCartIllegalMsg = updateShoppingCartIllegalMsg;
		this.updateShoppingCartLegalMsg = updateShoppingCartLegalMsg;
	}
	
	
	public UpdateShoppingCartIllegalMsgVODTO getUpdateShoppingCartIllegalMsg() {
		return updateShoppingCartIllegalMsg;
	}
	public UpdateShoppingCartLegalMsgVODTO getUpdateShoppingCartLegalMsg() {
		return updateShoppingCartLegalMsg;
	}
	
	
	public void setUpdateShoppingCartIllegalMsg(UpdateShoppingCartIllegalMsgVODTO updateShoppingCartIllegalMsg) {
		this.updateShoppingCartIllegalMsg = updateShoppingCartIllegalMsg;
	}
	public void setUpdateShoppingCartLegalMsg(UpdateShoppingCartLegalMsgVODTO updateShoppingCartLegalMsg) {
		this.updateShoppingCartLegalMsg = updateShoppingCartLegalMsg;
	}
}
