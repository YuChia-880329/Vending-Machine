package transformer.vo.backend.goodsUpdate.writeout;

import bean.dto.vo.backend.goodsUpdate.writeout.BGUUpdateMsgWOVODTO;
import bean.vo.backend.goodsUpdate.writeout.BGUUpdateMsgWOVO;
import template.transformer.bean.vo.VOWriteOutTransformerTemplate;

public class BGUUpdateMsgWOVOTransformer extends VOWriteOutTransformerTemplate<BGUUpdateMsgWOVODTO, BGUUpdateMsgWOVO> {

	private static final BGUUpdateMsgWOVOTransformer INSTANCE = new BGUUpdateMsgWOVOTransformer();
	
	private BGUUpdateMsgWOVOTransformer() {
	}
	
	public static BGUUpdateMsgWOVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	public BGUUpdateMsgWOVO dtoToVo(BGUUpdateMsgWOVODTO dto) {

		BGUUpdateMsgWOVO vo = new BGUUpdateMsgWOVO();
		
		vo.setHasMsg(dto.getHasMsg().getDescription());
		
		return vo;
	}
}
