package transformer.vo.frontend.writeout;

import bean.dto.vo.frontend.writeout.FWelcomeMsgWOVODTO;
import bean.vo.frontend.writeout.FWelcomeMsgWOVO;
import template.transformer.bean.vo.VOWriteOutTransformerTemplate;

public class FWelcomeMsgWOVOTransformer extends VOWriteOutTransformerTemplate<FWelcomeMsgWOVODTO, FWelcomeMsgWOVO> {

	private static final FWelcomeMsgWOVOTransformer INSTANCE = new FWelcomeMsgWOVOTransformer();
	
	private FWelcomeMsgWOVOTransformer() {
	}
	
	public static FWelcomeMsgWOVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	protected FWelcomeMsgWOVO dtoToVoTransform(FWelcomeMsgWOVODTO dto) {

		FWelcomeMsgWOVO vo = new FWelcomeMsgWOVO();
		
		vo.setCustomerName(dto.getCustomerName());
		
		return vo;
	}
}
