package bean.dto.frontend.vo.writeout;

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
