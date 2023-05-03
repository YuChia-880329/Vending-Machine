package transformer.login.vo.writeout;

import bean.dto.login.vo.writeout.LoginResultVODTO;
import bean.vo.login.writeout.LoginResultVO;
import template.transformer.bean.vo.VOWriteOutTransformerTemplate;

public class LoginResultVOTransformer extends VOWriteOutTransformerTemplate<LoginResultVODTO, LoginResultVO> {

	private static final LoginResultVOTransformer INSTANCE = new LoginResultVOTransformer();
	
	private LoginResultVOTransformer() {
	}
	
	public static LoginResultVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	protected LoginResultVO dtoToVoTransform(LoginResultVODTO dto) {
		
		LoginResultVO vo = new LoginResultVO();
		
		vo.setHasAccount(String.valueOf(dto.getHasAccount()));
		vo.setPasswordCorrect(String.valueOf(dto.getPasswordCorrect()));
		
		return vo;
	}
}
