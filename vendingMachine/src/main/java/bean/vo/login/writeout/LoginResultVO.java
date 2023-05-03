package bean.vo.login.writeout;

public class LoginResultVO {

	private String hasAccount;
	private String passwordCorrect;

	public LoginResultVO() {
	}
	public LoginResultVO(String hasAccount, String passwordCorrect) {
		
		this.hasAccount = hasAccount;
		this.passwordCorrect = passwordCorrect;
	}
	
	
	public String getHasAccount() {
		return hasAccount;
	}
	public String getPasswordCorrect() {
		return passwordCorrect;
	}
	
	
	public void setHasAccount(String hasAccount) {
		this.hasAccount = hasAccount;
	}
	public void setPasswordCorrect(String passwordCorrect) {
		this.passwordCorrect = passwordCorrect;
	}
}
