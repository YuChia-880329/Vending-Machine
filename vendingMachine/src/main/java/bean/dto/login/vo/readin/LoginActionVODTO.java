package bean.dto.login.vo.readin;

public class LoginActionVODTO {

	private LoginFormVODTO loginForm;

	public LoginActionVODTO() {
	}
	public LoginActionVODTO(LoginFormVODTO loginForm) {
		
		this.loginForm = loginForm;
	}
	
	
	public LoginFormVODTO getLoginForm() {
		return loginForm;
	}
	
	
	public void setLoginForm(LoginFormVODTO loginForm) {
		this.loginForm = loginForm;
	}
}
