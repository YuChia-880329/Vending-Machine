package transformer.login.vo.readin;

import bean.dto.login.vo.readin.LoginActionVODTO;
import bean.vo.login.readin.LoginActionVO;
import template.exception.CheckerException;
import template.transformer.bean.vo.VOReanInTransformerTemplate;
import transformer.checker.login.vo.readin.LoginActionVOChecker;

public class LoginActionVOTransformer extends VOReanInTransformerTemplate<LoginActionVO, LoginActionVODTO, CheckerException, LoginActionVOChecker> {

	private LoginFormVOTransformer loginFormVOTransformer;
	
	private static final LoginActionVOTransformer INSTANCE = new LoginActionVOTransformer();
	
	private LoginActionVOTransformer() {
		
		loginFormVOTransformer = LoginFormVOTransformer.getInstance();
	}
	
	public static LoginActionVOTransformer getInstance() {
		
		return INSTANCE;
	}

	
	@Override
	protected LoginActionVODTO voToDtoTransform(LoginActionVO vo) throws CheckerException {
		
		LoginActionVODTO dto = new LoginActionVODTO();
		
		dto.setLoginForm(loginFormVOTransformer.voToDto(vo.getLoginForm()));
		
		return dto;
	}

	@Override
	protected LoginActionVOChecker getChecker() {

		return LoginActionVOChecker.getInstance();
	}
}
