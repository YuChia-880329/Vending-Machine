package temp.bean.dto.frontend.vo.writeout;

import bean.dto.frontend.vo.writeout.AddShoppingCartIllegalMsgVODTO;
import bean.dto.frontend.vo.writeout.AddShoppingCartLegalMsgVODTO;

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
