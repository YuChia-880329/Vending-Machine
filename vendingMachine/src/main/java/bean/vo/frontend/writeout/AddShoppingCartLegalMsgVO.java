package bean.vo.frontend.writeout;

public class AddShoppingCartLegalMsgVO {

	private String hasMsg;
	private AddShoppingCartLegalMsgLineVO[] lines;
	
	
	public AddShoppingCartLegalMsgVO() {
	}
	public AddShoppingCartLegalMsgVO(String hasMsg, AddShoppingCartLegalMsgLineVO[] lines) {

		this.hasMsg = hasMsg;
		this.lines = lines;
	}
	
	
	public String getHasMsg() {
		return hasMsg;
	}
	public AddShoppingCartLegalMsgLineVO[] getLines() {
		return lines;
	}
	
	
	public void setHasMsg(String hasMsg) {
		this.hasMsg = hasMsg;
	}
	public void setLines(AddShoppingCartLegalMsgLineVO[] lines) {
		this.lines = lines;
	}
}
