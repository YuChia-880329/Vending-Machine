package transformer.checker.login.vo.readin;

import bean.vo.login.readin.LoginFormVO;
import bean.vo.login.readin.LoginActionVO;
import template.CheckerTemplate;
import template.exception.CheckerException;
import util.CheckUtil;
import util.StringConcatUtil;

public class LoginActionVOChecker extends CheckerTemplate<LoginActionVO, CheckerException> {

	private static final String NAME_PREFIX = "login, ";
	
	
	private LoginFormVOChecker loginFormVOChecker;
	
	private static final LoginActionVOChecker INSTANCE = new LoginActionVOChecker();
	
	private LoginActionVOChecker() {
		
		loginFormVOChecker = LoginFormVOChecker.getInstance();
	}
	
	public static LoginActionVOChecker getInstance() {
		
		return INSTANCE;
	}

	@Override
	public void check(LoginActionVO vo) throws CheckerException {
		
		checkVo(vo);
		
		checkCurrentUrl(vo);
	}
	
	private void checkVo(LoginActionVO vo) throws CheckerException {
		
		CheckUtil.checkOther(vo, StringConcatUtil.concate(NAME_PREFIX, "vo"));
	}
	
	private void checkCurrentUrl(LoginActionVO vo) throws CheckerException {
		
		LoginFormVO loginForm = vo.getLoginForm();
		
		loginFormVOChecker.check(loginForm);
	}
}
