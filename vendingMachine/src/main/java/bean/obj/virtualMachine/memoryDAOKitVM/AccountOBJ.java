package bean.obj.virtualMachine.memoryDAOKitVM;

import java.util.Objects;

public class AccountOBJ {

	private String account;

	public AccountOBJ() {
	}
	public AccountOBJ(String account) {

		this.account = account;
	}


	public String getAccount() {
		return account;
	}

	
	public void setAccount(String account) {
		this.account = account;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(account);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AccountOBJ other = (AccountOBJ) obj;
		return Objects.equals(account, other.account);
	}
}
