package transformer.login.vo.writeout;

import bean.dto.login.vo.writeout.NotLoginMsgVODTO;
import bean.vo.login.writeout.NotLoginMsgVO;
import template.transformer.bean.vo.VOWriteOutTransformerTemplate;

public class NotLoginMsgVOTransformer extends VOWriteOutTransformerTemplate<NotLoginMsgVODTO, NotLoginMsgVO> {

	private static final NotLoginMsgVOTransformer INSTANCE = new NotLoginMsgVOTransformer();
	
	private NotLoginMsgVOTransformer() {
	}
	
	public static NotLoginMsgVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	protected NotLoginMsgVO dtoToVoTransform(NotLoginMsgVODTO dto) {
		
		NotLoginMsgVO vo = new NotLoginMsgVO();
		
		vo.setHasMsg(String.valueOf(dto.getHasMsg()));
		
		return vo;
	}
}
