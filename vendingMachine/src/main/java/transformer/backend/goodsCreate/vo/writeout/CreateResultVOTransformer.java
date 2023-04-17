package transformer.backend.goodsCreate.vo.writeout;

import bean.dto.backend.goodsCreate.vo.writeout.CreateResultVODTO;
import bean.vo.backend.goodsCreate.writeout.CreateResultVO;
import template.transformer.bean.vo.VOWriteOutTransformerTemplate;

public class CreateResultVOTransformer extends VOWriteOutTransformerTemplate<CreateResultVODTO, CreateResultVO> {

	private CreateMsgVOTransformer createMsgVOTransformer;
	
	
	private static final CreateResultVOTransformer INSTANCE = new CreateResultVOTransformer();
	
	private CreateResultVOTransformer() {
		
		createMsgVOTransformer = CreateMsgVOTransformer.getInstance();
	}
	
	public static CreateResultVOTransformer getInstance() {
		
		return INSTANCE;
	}

	
	@Override
	protected CreateResultVO dtoToVoTransform(CreateResultVODTO dto) {
		
		CreateResultVO createResultVO = new CreateResultVO();
		
		createResultVO.setCreateMsg(createMsgVOTransformer.dtoToVo(dto.getCreateMsg()));
		
		return createResultVO;
	}
}
