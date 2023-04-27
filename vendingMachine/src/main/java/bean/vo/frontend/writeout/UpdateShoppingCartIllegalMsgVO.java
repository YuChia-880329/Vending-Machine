package bean.vo.frontend.writeout;

public class UpdateShoppingCartIllegalMsgVO {

	private String hasMsg;
	private UpdateShoppingCartIllegalMsgLineVO[] lines;
	
	
	public UpdateShoppingCartIllegalMsgVO() {
	}
	public UpdateShoppingCartIllegalMsgVO(String hasMsg, UpdateShoppingCartIllegalMsgLineVO[] lines) {

		this.hasMsg = hasMsg;
		this.lines = lines;
	}
	
	
	
	public String getHasMsg() {
		return hasMsg;
	}
	public UpdateShoppingCartIllegalMsgLineVO[] getLines() {
		return lines;
	}
	
	
	public void setHasMsg(String hasMsg) {
		this.hasMsg = hasMsg;
	}
	public void setLines(UpdateShoppingCartIllegalMsgLineVO[] lines) {
		this.lines = lines;
	}
}
