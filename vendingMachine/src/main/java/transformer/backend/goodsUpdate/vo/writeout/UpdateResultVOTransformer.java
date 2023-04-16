package transformer.backend.goodsUpdate.vo.writeout;

import bean.dto.backend.goodsUpdate.vo.writeout.UpdateResultVODTO;
import bean.vo.backend.goodsUpdate.writeout.UpdateResultVO;
import template.transformer.bean.vo.VOWriteOutTransformerTemplate;

public class UpdateResultVOTransformer extends VOWriteOutTransformerTemplate<UpdateResultVODTO, UpdateResultVO> {

	private UpdateMsgVOTransformer updateMsgVOTransformer;
	
	private static final UpdateResultVOTransformer INSTANCE = new UpdateResultVOTransformer();
	
	private UpdateResultVOTransformer() {
		
		updateMsgVOTransformer = UpdateMsgVOTransformer.getInstance();
	}
	
	public static UpdateResultVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	public UpdateResultVO dtoToVo(UpdateResultVODTO dto) {
		
		UpdateResultVO vo = new UpdateResultVO();
		
		vo.setUpdateMsg(updateMsgVOTransformer.dtoToVo(dto.getUpdateMsg()));
		
		return vo;
	}
	
}
