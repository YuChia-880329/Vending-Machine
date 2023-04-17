package transformer.backend.goodsCreate.vo.writeout;

import bean.dto.backend.goodsCreate.vo.writeout.CreateMsgVODTO;
import bean.vo.backend.goodsCreate.writeout.CreateMsgVO;
import template.transformer.bean.vo.VOWriteOutTransformerTemplate;

public class CreateMsgVOTransformer extends VOWriteOutTransformerTemplate<CreateMsgVODTO, CreateMsgVO> {

	private static final CreateMsgVOTransformer INSTANCE = new CreateMsgVOTransformer();
	
	private CreateMsgVOTransformer() {
	}
	
	public static CreateMsgVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	protected CreateMsgVO dtoToVoTransform(CreateMsgVODTO dto) {

		CreateMsgVO vo = new CreateMsgVO();
	
		vo.setMsg(dto.getMsg());
		
		return vo;
	}
}
