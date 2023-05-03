package bean.vo.login.writeout;

public class LoginResultVO {

	private String msg;

	public LoginResultVO() {
	}
	public LoginResultVO(String msg) {

		this.msg = msg;
	}
	
	
	public String getMsg() {
		return msg;
	}
	
	
	public void setMsg(String msg) {
		this.msg = msg;
	}
}
