package transformer.frontend.vo.writeout;

import bean.dto.frontend.vo.writeout.WelcomeMsgVODTO;
import bean.vo.frontend.writeout.WelcomeMsgVO;
import template.transformer.bean.vo.VOWriteOutTransformerTemplate;

public class WelcomeMsgVOTransformer extends VOWriteOutTransformerTemplate<WelcomeMsgVODTO, WelcomeMsgVO> {

	private static final WelcomeMsgVOTransformer INSTANCE = new WelcomeMsgVOTransformer();
	
	private WelcomeMsgVOTransformer() {
	}
	
	public static WelcomeMsgVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	protected WelcomeMsgVO dtoToVoTransform(WelcomeMsgVODTO dto) {

		WelcomeMsgVO vo = new WelcomeMsgVO();
		
		vo.setCustomerName(dto.getCustomerName());
		
		return vo;
	}
}
