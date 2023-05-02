package transformer.backend.goodsUpdate.vo.writeout;

import bean.dto.backend.goodsUpdate.vo.writeout.UpdateMsgVODTO;
import bean.vo.backend.goodsUpdate.writeout.UpdateMsgVO;
import template.transformer.bean.vo.VOWriteOutTransformerTemplate;

public class UpdateMsgVOTransformer extends VOWriteOutTransformerTemplate<UpdateMsgVODTO, UpdateMsgVO> {

	private static final UpdateMsgVOTransformer INSTANCE = new UpdateMsgVOTransformer();
	
	private UpdateMsgVOTransformer() {
	}
	
	public static UpdateMsgVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	protected UpdateMsgVO dtoToVoTransform(UpdateMsgVODTO dto) {

		UpdateMsgVO vo = new UpdateMsgVO();
		
		vo.setSuccess(String.valueOf(dto.getSuccess()));
		vo.setId(String.valueOf(dto.getId()));
		vo.setName(dto.getName());
		
		return vo;
	}
}
