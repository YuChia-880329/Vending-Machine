package transformer.vo.backend.goodsCreate.writeout;

import bean.dto.vo.backend.goodsCreate.writeout.BGCCreateMsgWOVODTO;
import bean.vo.backend.goodsCreate.writeout.BGCCreateMsgWOVO;
import template.transformer.bean.vo.VOWriteOutTransformerTemplate;

public class BGCCreateMsgWOVOTransformer extends VOWriteOutTransformerTemplate<BGCCreateMsgWOVODTO, BGCCreateMsgWOVO> {

	private static final BGCCreateMsgWOVOTransformer INSTANCE = new BGCCreateMsgWOVOTransformer();
	
	private BGCCreateMsgWOVOTransformer() {
	}
	
	public static BGCCreateMsgWOVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	public BGCCreateMsgWOVO dtoToVo(BGCCreateMsgWOVODTO dto) {

		BGCCreateMsgWOVO vo = new BGCCreateMsgWOVO();
		
		vo.setHasMessage(dto.getHasMessage().getDescription());
		vo.setId(String.valueOf(dto.getId()));
		
		return vo;
	}
}
