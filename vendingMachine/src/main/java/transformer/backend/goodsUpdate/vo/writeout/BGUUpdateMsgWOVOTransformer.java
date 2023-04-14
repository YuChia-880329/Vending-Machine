package transformer.backend.goodsUpdate.vo.writeout;

import bean.dto.backend.goodsUpdate.vo.writeout.BGUUpdateMsgWOVODTO;
import bean.vo.backend.goodsUpdate.writeout.UpdateMsgVO;
import template.transformer.bean.vo.VOWriteOutTransformerTemplate;

public class BGUUpdateMsgWOVOTransformer extends VOWriteOutTransformerTemplate<BGUUpdateMsgWOVODTO, UpdateMsgVO> {

	private static final BGUUpdateMsgWOVOTransformer INSTANCE = new BGUUpdateMsgWOVOTransformer();
	
	private BGUUpdateMsgWOVOTransformer() {
	}
	
	public static BGUUpdateMsgWOVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	public UpdateMsgVO dtoToVo(BGUUpdateMsgWOVODTO dto) {

		UpdateMsgVO vo = new UpdateMsgVO();
		
		vo.setHasMsg(dto.getHasMsg().getDescription());
		
		return vo;
	}
}
