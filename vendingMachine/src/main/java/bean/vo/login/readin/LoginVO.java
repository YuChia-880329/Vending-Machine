package bean.vo.login.readin;

public class LoginVO {

	private LoginFormVO loginForm;

	public LoginVO() {
	}
	public LoginVO(LoginFormVO loginForm) {

		this.loginForm = loginForm;
	}
	
	
	public LoginFormVO getLoginForm() {
		return loginForm;
	}
	
	
	public void setLoginForm(LoginFormVO loginForm) {
		this.loginForm = loginForm;
	}
}
