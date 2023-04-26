package bean.vo.frontend.writeout;

public class AddShoppingCartIllegalMsgVO {

	private String hasMsg;
	private AddShoppingCartIllegalMsgLineVO[] lines;
	
	
	public AddShoppingCartIllegalMsgVO() {
	}
	public AddShoppingCartIllegalMsgVO(String hasMsg, AddShoppingCartIllegalMsgLineVO[] lines) {

		this.hasMsg = hasMsg;
		this.lines = lines;
	}
	
	
	
	public String getHasMsg() {
		return hasMsg;
	}
	public AddShoppingCartIllegalMsgLineVO[] getLines() {
		return lines;
	}
	
	
	public void setHasMsg(String hasMsg) {
		this.hasMsg = hasMsg;
	}
	public void setLines(AddShoppingCartIllegalMsgLineVO[] lines) {
		this.lines = lines;
	}
}
