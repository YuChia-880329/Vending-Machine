package bean.dto.login.vo.readin;

public class LoginVODTO {

	private LoginFormVODTO loginForm;

	public LoginVODTO() {
	}
	public LoginVODTO(LoginFormVODTO loginForm) {
		
		this.loginForm = loginForm;
	}
	
	
	public LoginFormVODTO getLoginForm() {
		return loginForm;
	}
	
	
	public void setLoginForm(LoginFormVODTO loginForm) {
		this.loginForm = loginForm;
	}
}
