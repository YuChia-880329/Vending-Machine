package temp.bean.vo.frontend.writeout;

import bean.vo.frontend.writeout.AddShoppingCartIllegalMsgVO;
import bean.vo.frontend.writeout.AddShoppingCartLegalMsgVO;

public class AddShoppingCartResultVO {

	private AddShoppingCartIllegalMsgVO addShoppingCartIllegalMsg;
	private AddShoppingCartLegalMsgVO addShoppingCartLegalMsg;
	
	
	public AddShoppingCartResultVO() {
	}
	public AddShoppingCartResultVO(AddShoppingCartIllegalMsgVO addShoppingCartIllegalMsg,
			AddShoppingCartLegalMsgVO addShoppingCartLegalMsg) {

		this.addShoppingCartIllegalMsg = addShoppingCartIllegalMsg;
		this.addShoppingCartLegalMsg = addShoppingCartLegalMsg;
	}
	
	
	public AddShoppingCartIllegalMsgVO getAddShoppingCartIllegalMsg() {
		return addShoppingCartIllegalMsg;
	}
	public AddShoppingCartLegalMsgVO getAddShoppingCartLegalMsg() {
		return addShoppingCartLegalMsg;
	}
	
	
	public void setAddShoppingCartIllegalMsg(AddShoppingCartIllegalMsgVO addShoppingCartIllegalMsg) {
		this.addShoppingCartIllegalMsg = addShoppingCartIllegalMsg;
	}
	public void setAddShoppingCartLegalMsg(AddShoppingCartLegalMsgVO addShoppingCartLegalMsg) {
		this.addShoppingCartLegalMsg = addShoppingCartLegalMsg;
	}
}
