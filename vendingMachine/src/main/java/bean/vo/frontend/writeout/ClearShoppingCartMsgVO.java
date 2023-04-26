package bean.vo.frontend.writeout;

public class ClearShoppingCartMsgVO {

	private String hasMsg;

	
	public ClearShoppingCartMsgVO() {
	}
	public ClearShoppingCartMsgVO(String hasMsg) {

		this.hasMsg = hasMsg;
	}
	
	
	public String getHasMsg() {
		return hasMsg;
	}
	
	
	public void setHasMsg(String hasMsg) {
		this.hasMsg = hasMsg;
	}
}
