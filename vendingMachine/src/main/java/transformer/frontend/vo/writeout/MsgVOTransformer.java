package transformer.frontend.vo.writeout;

import java.util.List;

import bean.dto.frontend.vo.writeout.MsgVODTO;
import bean.vo.frontend.writeout.MsgVO;
import template.transformer.bean.vo.VOWriteOutTransformerTemplate;

public class MsgVOTransformer  extends VOWriteOutTransformerTemplate<MsgVODTO, MsgVO> {

	private static final MsgVOTransformer INSTANCE = new MsgVOTransformer();
	
	private MsgVOTransformer() {
	}
	
	public static MsgVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	protected MsgVO dtoToVoTransform(MsgVODTO dto) {
		
		MsgVO vo = new MsgVO();
		
		List<String> lines = dto.getLines();
		
		vo.setHasMsg(dto.getHasMsg().getDescription());
		vo.setLines(lines.toArray(new String[lines.size()]));
		
		return vo;
	}
}
