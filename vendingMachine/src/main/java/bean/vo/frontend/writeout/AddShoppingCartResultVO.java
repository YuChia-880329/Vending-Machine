package bean.vo.frontend.writeout;

public class AddShoppingCartResultVO {

	private IllegalMsgVO illegalMsg;
	private String queryString;

	
	public AddShoppingCartResultVO() {
	}
	public AddShoppingCartResultVO(IllegalMsgVO illegalMsg, String queryString) {

		this.queryString = queryString;
	}
	
	
	
	public IllegalMsgVO getIllegalMsg() {
		return illegalMsg;
	}
	public String getQueryString() {
		return queryString;
	}
	
	
	public void setIllegalMsg(IllegalMsgVO illegalMsg) {
		this.illegalMsg = illegalMsg;
	}
	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}
}
