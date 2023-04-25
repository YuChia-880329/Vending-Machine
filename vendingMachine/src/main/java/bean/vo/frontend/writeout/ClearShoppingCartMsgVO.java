package bean.vo.frontend.writeout;

public class ClearShoppingCartMsgVO {

	private String success;

	
	public ClearShoppingCartMsgVO() {
	}
	public ClearShoppingCartMsgVO(String success) {

		this.success = success;
	}
	
	
	public String getSuccess() {
		return success;
	}
	
	
	public void setSuccess(String success) {
		this.success = success;
	}
}
