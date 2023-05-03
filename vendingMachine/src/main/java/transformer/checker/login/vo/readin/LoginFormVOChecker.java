package transformer.checker.login.vo.readin;

import bean.vo.login.readin.LoginFormVO;
import template.CheckerTemplate;
import template.exception.CheckerException;
import util.CheckUtil;
import util.StringConcatUtil;

public class LoginFormVOChecker extends CheckerTemplate<LoginFormVO, CheckerException> {

	private static final String NAME_PREFIX = "login, form, ";
	
	private static final LoginFormVOChecker INSTANCE = new LoginFormVOChecker();
	
	private LoginFormVOChecker() {
	}
	
	public static LoginFormVOChecker getInstance() {
		
		return INSTANCE;
	}

	@Override
	public void check(LoginFormVO vo) throws CheckerException {
		
		checkVo(vo);
		
		checkAccount(vo);
		checkPassword(vo);
	}
	
	
	private void checkVo(LoginFormVO vo) throws CheckerException {
		
		CheckUtil.checkOther(vo, StringConcatUtil.concate(NAME_PREFIX, "vo"));
	}
	
	
	private void checkAccount(LoginFormVO vo) throws CheckerException {
		
		String account = vo.getAccount();
		
		CheckUtil.checkString(account, StringConcatUtil.concate(NAME_PREFIX, "account"));
	}
	private void checkPassword(LoginFormVO vo) throws CheckerException {
		
		String password = vo.getAccount();
		
		CheckUtil.checkString(password, StringConcatUtil.concate(NAME_PREFIX, "password"));
	}
}
