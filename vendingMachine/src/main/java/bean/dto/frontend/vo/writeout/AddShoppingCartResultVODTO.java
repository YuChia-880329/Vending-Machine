package bean.dto.frontend.vo.writeout;

public class AddShoppingCartResultVODTO {

	private AddShoppingCartIllegalMsgVODTO addShoppingCartIllegalMsg;
	private AddShoppingCartLegalMsgVODTO addShoppingCartLegalMsg;
	
	
	public AddShoppingCartResultVODTO() {
	}
	public AddShoppingCartResultVODTO(AddShoppingCartIllegalMsgVODTO addShoppingCartIllegalMsg,
			AddShoppingCartLegalMsgVODTO addShoppingCartLegalMsg) {

		this.addShoppingCartIllegalMsg = addShoppingCartIllegalMsg;
		this.addShoppingCartLegalMsg = addShoppingCartLegalMsg;
	}
	
	
	public AddShoppingCartIllegalMsgVODTO getAddShoppingCartIllegalMsg() {
		return addShoppingCartIllegalMsg;
	}
	public AddShoppingCartLegalMsgVODTO getAddShoppingCartLegalMsg() {
		return addShoppingCartLegalMsg;
	}
	
	
	public void setAddShoppingCartIllegalMsg(AddShoppingCartIllegalMsgVODTO addShoppingCartIllegalMsg) {
		this.addShoppingCartIllegalMsg = addShoppingCartIllegalMsg;
	}
	public void setAddShoppingCartLegalMsg(AddShoppingCartLegalMsgVODTO addShoppingCartLegalMsg) {
		this.addShoppingCartLegalMsg = addShoppingCartLegalMsg;
	}
}
