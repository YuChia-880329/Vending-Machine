package bean.vo.frontend.writeout;

public class UpdateShoppingCartMsgVO {

	private String hasMsg;
	private UpdateShoppingCartMsgLineVO[] lines;
	
	
	public UpdateShoppingCartMsgVO() {
	}
	public UpdateShoppingCartMsgVO(String hasMsg, UpdateShoppingCartMsgLineVO[] lines) {

		this.hasMsg = hasMsg;
		this.lines = lines;
	}
	
	
	public String getHasMsg() {
		return hasMsg;
	}
	public UpdateShoppingCartMsgLineVO[] getLines() {
		return lines;
	}
	
	
	public void setHasMsg(String hasMsg) {
		this.hasMsg = hasMsg;
	}
	public void setLines(UpdateShoppingCartMsgLineVO[] lines) {
		this.lines = lines;
	}
}
