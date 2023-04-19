package transformer.frontend.vo.writeout;

import bean.dto.frontend.vo.writeout.WelcomePartVODTO;
import bean.vo.frontend.writeout.WelcomePartVO;
import template.transformer.bean.vo.VOWriteOutTransformerTemplate;

public class WelcomePartVOTransformer extends VOWriteOutTransformerTemplate<WelcomePartVODTO, WelcomePartVO> {

	private WelcomeMsgVOTransformer welcomeMsgVOTransformer;
	
	
	private static final WelcomePartVOTransformer INSTANCE = new WelcomePartVOTransformer();
	
	private WelcomePartVOTransformer() {
		
		welcomeMsgVOTransformer = WelcomeMsgVOTransformer.getInstance();
	}
	
	public static WelcomePartVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	protected WelcomePartVO dtoToVoTransform(WelcomePartVODTO dto) {
		
		WelcomePartVO vo = new WelcomePartVO();
		
		vo.setWelcomeImagePath(dto.getWelcomeImagePath());
		vo.setWelcomeMsg(welcomeMsgVOTransformer.dtoToVo(dto.getWelcomeMsg()));
		
		return vo;
	}
}
