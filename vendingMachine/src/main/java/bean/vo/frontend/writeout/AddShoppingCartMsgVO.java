package bean.vo.frontend.writeout;

public class AddShoppingCartMsgVO {

	private String hasMsg;
	private AddShoppingCartMsgLineVO[] lines;
	
	
	public AddShoppingCartMsgVO() {
	}
	public AddShoppingCartMsgVO(String hasMsg, AddShoppingCartMsgLineVO[] lines) {

		this.hasMsg = hasMsg;
		this.lines = lines;
	}
	
	
	public String getHasMsg() {
		return hasMsg;
	}
	public AddShoppingCartMsgLineVO[] getLines() {
		return lines;
	}
	
	
	public void setHasMsg(String hasMsg) {
		this.hasMsg = hasMsg;
	}
	public void setLines(AddShoppingCartMsgLineVO[] lines) {
		this.lines = lines;
	}
}
