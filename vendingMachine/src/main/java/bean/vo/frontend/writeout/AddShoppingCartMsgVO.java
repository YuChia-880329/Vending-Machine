package bean.vo.frontend.writeout;

public class AddShoppingCartMsgVO {

	private String hasMsg;
	private String[] names;
	
	
	public AddShoppingCartMsgVO() {
	}
	public AddShoppingCartMsgVO(String hasMsg, String[] names) {

		this.hasMsg = hasMsg;
		this.names = names;
	}
	
	
	
	public String getHasMsg() {
		return hasMsg;
	}
	public String[] getNames() {
		return names;
	}
	
	
	public void setHasMsg(String hasMsg) {
		this.hasMsg = hasMsg;
	}
	public void setNames(String[] names) {
		this.names = names;
	}
}
