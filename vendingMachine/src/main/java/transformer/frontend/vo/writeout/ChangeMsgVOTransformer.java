package transformer.frontend.vo.writeout;

import bean.dto.frontend.vo.writeout.ChangeMsgVODTO;
import bean.vo.frontend.writeout.ChangeMsgVO;
import template.transformer.bean.vo.VOWriteOutTransformerTemplate;

public class ChangeMsgVOTransformer extends VOWriteOutTransformerTemplate<ChangeMsgVODTO, ChangeMsgVO> {

	private static final ChangeMsgVOTransformer INSTANCE = new ChangeMsgVOTransformer();
	
	private ChangeMsgVOTransformer() {
	}
	
	public static ChangeMsgVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	protected ChangeMsgVO dtoToVoTransform(ChangeMsgVODTO dto) {

		ChangeMsgVO vo = new ChangeMsgVO();
		
		vo.setHasMsg(String.valueOf(dto.getHasMsg()));
		vo.setChange(String.valueOf(dto.getChange()));
		
		return vo;
	}
}
