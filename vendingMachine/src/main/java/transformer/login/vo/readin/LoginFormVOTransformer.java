package transformer.login.vo.readin;

import bean.dto.login.vo.readin.LoginFormVODTO;
import bean.vo.login.readin.LoginFormVO;
import template.exception.CheckerException;
import template.transformer.bean.vo.VOReanInTransformerTemplate;
import transformer.checker.login.vo.readin.LoginFormVOChecker;

public class LoginFormVOTransformer extends VOReanInTransformerTemplate<LoginFormVO, LoginFormVODTO, CheckerException, LoginFormVOChecker> {

	private static final LoginFormVOTransformer INSTANCE = new LoginFormVOTransformer();
	
	private LoginFormVOTransformer() {
	}
	
	public static LoginFormVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	protected LoginFormVODTO voToDtoTransform(LoginFormVO vo) throws CheckerException {
		
		LoginFormVODTO dto = new LoginFormVODTO();
		
		dto.setAccount(vo.getAccount());
		dto.setPassword(vo.getPassword());
		
		return dto;
	}

	@Override
	protected LoginFormVOChecker getChecker() {

		return LoginFormVOChecker.getInstance();
	}
}
