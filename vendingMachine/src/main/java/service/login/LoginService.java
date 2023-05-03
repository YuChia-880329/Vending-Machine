package service.login;

public class LoginService {

	private static final LoginService INSTANCE = new LoginService();
	
	private LoginService() {
	}
	
	public static LoginService getInstance() {
		
		return INSTANCE;
	}
	
	
}
