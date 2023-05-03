package transformer.login.vo.readin;

import bean.dto.login.vo.readin.LoginVODTO;
import bean.vo.login.readin.LoginVO;
import template.exception.CheckerException;
import template.transformer.bean.vo.VOReanInTransformerTemplate;
import transformer.checker.login.vo.readin.LoginVOChecker;

public class LoginVOTransformer extends VOReanInTransformerTemplate<LoginVO, LoginVODTO, CheckerException, LoginVOChecker> {

	private LoginFormVOTransformer loginFormVOTransformer;
	
	private static final LoginVOTransformer INSTANCE = new LoginVOTransformer();
	
	private LoginVOTransformer() {
		
		loginFormVOTransformer = LoginFormVOTransformer.getInstance();
	}
	
	public static LoginVOTransformer getInstance() {
		
		return INSTANCE;
	}

	
	@Override
	protected LoginVODTO voToDtoTransform(LoginVO vo) throws CheckerException {
		
		LoginVODTO dto = new LoginVODTO();
		
		dto.setLoginForm(loginFormVOTransformer.voToDto(vo.getLoginForm()));
		
		return dto;
	}

	@Override
	protected LoginVOChecker getChecker() {

		return LoginVOChecker.getInstance();
	}
}
