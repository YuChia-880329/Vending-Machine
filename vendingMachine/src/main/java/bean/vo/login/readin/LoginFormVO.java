package bean.vo.login.readin;

public class LoginFormVO {

	private String account;
	private String password;
	
	
	public LoginFormVO() {
	}
	public LoginFormVO(String account, String password) {

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
