package bean.dto.login.vo.writeout;

public class LoginResultVODTO {

	private boolean hasAccount;
	private boolean passwordCorrect;

	public LoginResultVODTO() {
	}
	public LoginResultVODTO(boolean hasAccount, boolean passwordCorrect) {

		this.hasAccount = hasAccount;
		this.passwordCorrect = passwordCorrect;
	}
	
	
	public boolean getHasAccount() {
		return hasAccount;
	}
	public boolean getPasswordCorrect() {
		return passwordCorrect;
	}
	
	
	public void setHasAccount(boolean hasAccount) {
		this.hasAccount = hasAccount;
	}
	public void setPasswordCorrect(boolean passwordCorrect) {
		this.passwordCorrect = passwordCorrect;
	}
}
