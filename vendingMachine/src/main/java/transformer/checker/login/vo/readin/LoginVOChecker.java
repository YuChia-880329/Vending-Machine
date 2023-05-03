package transformer.checker.login.vo.readin;

import bean.vo.login.readin.LoginFormVO;
import bean.vo.login.readin.LoginVO;
import template.CheckerTemplate;
import template.exception.CheckerException;
import util.CheckUtil;
import util.StringConcatUtil;

public class LoginVOChecker extends CheckerTemplate<LoginVO, CheckerException> {

	private static final String NAME_PREFIX = "login, ";
	
	
	private LoginFormVOChecker loginFormVOChecker;
	
	private static final LoginVOChecker INSTANCE = new LoginVOChecker();
	
	private LoginVOChecker() {
		
		loginFormVOChecker = LoginFormVOChecker.getInstance();
	}
	
	public static LoginVOChecker getInstance() {
		
		return INSTANCE;
	}

	@Override
	public void check(LoginVO vo) throws CheckerException {
		
		checkVo(vo);
		
		checkCurrentUrl(vo);
	}
	
	private void checkVo(LoginVO vo) throws CheckerException {
		
		CheckUtil.checkOther(vo, StringConcatUtil.concate(NAME_PREFIX, "vo"));
	}
	
	private void checkCurrentUrl(LoginVO vo) throws CheckerException {
		
		LoginFormVO loginForm = vo.getLoginForm();
		
		loginFormVOChecker.check(loginForm);
	}
}
