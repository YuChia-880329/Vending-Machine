package bean.dto.login.vo.writeout;

public class LoginResultVODTO {

	private String msg;

	public LoginResultVODTO() {
	}
	public LoginResultVODTO(String msg) {

		this.msg = msg;
	}
	
	
	public String getMsg() {
		return msg;
	}
	
	
	public void setMsg(String msg) {
		this.msg = msg;
	}
}
