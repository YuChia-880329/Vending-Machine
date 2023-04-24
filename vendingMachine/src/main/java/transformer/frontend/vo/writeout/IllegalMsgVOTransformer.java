package transformer.frontend.vo.writeout;

import java.util.List;

import bean.dto.frontend.vo.writeout.IllegalMsgVODTO;
import bean.vo.frontend.writeout.IllegalMsgVO;
import template.transformer.bean.vo.VOWriteOutTransformerTemplate;

public class IllegalMsgVOTransformer  extends VOWriteOutTransformerTemplate<IllegalMsgVODTO, IllegalMsgVO> {

	private static final IllegalMsgVOTransformer INSTANCE = new IllegalMsgVOTransformer();
	
	private IllegalMsgVOTransformer() {
	}
	
	public static IllegalMsgVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	protected IllegalMsgVO dtoToVoTransform(IllegalMsgVODTO dto) {
		
		IllegalMsgVO vo = new IllegalMsgVO();
		
		List<String> msgs = dto.getMsgs();
		
		vo.setHasMsg(dto.getHasMsg().getDescription());
		vo.setMsgs(msgs.toArray(new String[msgs.size()]));
		
		return vo;
	}
}
