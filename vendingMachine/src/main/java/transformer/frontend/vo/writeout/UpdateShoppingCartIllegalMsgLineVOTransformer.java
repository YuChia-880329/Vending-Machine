package transformer.frontend.vo.writeout;

import bean.dto.frontend.vo.writeout.UpdateShoppingCartIllegalMsgLineVODTO;
import bean.vo.frontend.writeout.UpdateShoppingCartIllegalMsgLineVO;
import template.transformer.bean.vo.VOWriteOutTransformerTemplate;

public class UpdateShoppingCartIllegalMsgLineVOTransformer extends VOWriteOutTransformerTemplate<UpdateShoppingCartIllegalMsgLineVODTO, UpdateShoppingCartIllegalMsgLineVO> {

	private static final UpdateShoppingCartIllegalMsgLineVOTransformer INSTANCE = new UpdateShoppingCartIllegalMsgLineVOTransformer();
	
	private UpdateShoppingCartIllegalMsgLineVOTransformer() {
	}
	
	public static UpdateShoppingCartIllegalMsgLineVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	protected UpdateShoppingCartIllegalMsgLineVO dtoToVoTransform(UpdateShoppingCartIllegalMsgLineVODTO dto) {
		
		UpdateShoppingCartIllegalMsgLineVO vo = new UpdateShoppingCartIllegalMsgLineVO();
		
		vo.setName(dto.getName());
		
		return vo;
	}
}
