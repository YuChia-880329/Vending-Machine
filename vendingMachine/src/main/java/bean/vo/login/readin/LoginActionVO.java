package bean.vo.login.readin;

public class LoginActionVO {

	private LoginFormVO loginForm;

	public LoginActionVO() {
	}
	public LoginActionVO(LoginFormVO loginForm) {

		this.loginForm = loginForm;
	}
	
	
	public LoginFormVO getLoginForm() {
		return loginForm;
	}
	
	
	public void setLoginForm(LoginFormVO loginForm) {
		this.loginForm = loginForm;
	}
}
