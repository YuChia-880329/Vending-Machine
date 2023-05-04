package transformer.login.vo.writeout;

import bean.dto.login.vo.writeout.LoginVODTO;
import bean.vo.login.writeout.LoginVO;
import template.transformer.bean.vo.VOWriteOutTransformerTemplate;

public class LoginVOTransformer extends VOWriteOutTransformerTemplate<LoginVODTO, LoginVO> {

	private BackgroundVOTransformer backgroundVOTransformer;
	private NotLoginMsgVOTransformer notLoginMsgVOTransformer;
	
	
	private static final LoginVOTransformer INSTANCE = new LoginVOTransformer();
	
	private LoginVOTransformer() {
		
		backgroundVOTransformer = BackgroundVOTransformer.getInstance();
		notLoginMsgVOTransformer = NotLoginMsgVOTransformer.getInstance();
	}
	
	public static LoginVOTransformer getInstance() {
		
		return INSTANCE;
	}

	
	@Override
	protected LoginVO dtoToVoTransform(LoginVODTO dto) {

		LoginVO vo = new LoginVO();
		
		vo.setBackground(backgroundVOTransformer.dtoToVo(dto.getBackground()));
		vo.setNotLoginMsg(notLoginMsgVOTransformer.dtoToVo(dto.getNotLoginMsg()));
		
		return vo;
	}
}
