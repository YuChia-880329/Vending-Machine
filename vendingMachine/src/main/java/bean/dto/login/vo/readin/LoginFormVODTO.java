package bean.dto.login.vo.readin;

public class LoginFormVODTO {

	private String account;
	private String password;
	
	
	public LoginFormVODTO() {
	}
	public LoginFormVODTO(String account, String password) {

		this.account = account;
		this.password = password;
	}
	
	
	public String getAccount() {
		return account;
	}
	public String getPassword() {
		return password;
	}
	
	
	public void setAccount(String account) {
		this.account = account;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
