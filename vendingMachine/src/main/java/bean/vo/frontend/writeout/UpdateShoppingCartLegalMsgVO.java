package bean.vo.frontend.writeout;

public class UpdateShoppingCartLegalMsgVO {

	private String hasMsg;
	private UpdateShoppingCartLegalMsgLineVO[] lines;
	
	
	public UpdateShoppingCartLegalMsgVO() {
	}
	public UpdateShoppingCartLegalMsgVO(String hasMsg, UpdateShoppingCartLegalMsgLineVO[] lines) {

		this.hasMsg = hasMsg;
		this.lines = lines;
	}
	
	
	public String getHasMsg() {
		return hasMsg;
	}
	public UpdateShoppingCartLegalMsgLineVO[] getLines() {
		return lines;
	}
	
	
	public void setHasMsg(String hasMsg) {
		this.hasMsg = hasMsg;
	}
	public void setLines(UpdateShoppingCartLegalMsgLineVO[] lines) {
		this.lines = lines;
	}
}
