package transformer.frontend.vo.writeout;

import bean.dto.frontend.vo.writeout.UpdateShoppingCartLegalMsgLineVODTO;
import bean.vo.frontend.writeout.UpdateShoppingCartLegalMsgLineVO;
import template.transformer.bean.vo.VOWriteOutTransformerTemplate;

public class UpdateShoppingCartLegalMsgLineVOTransformer extends VOWriteOutTransformerTemplate<UpdateShoppingCartLegalMsgLineVODTO, UpdateShoppingCartLegalMsgLineVO> {

	private static final UpdateShoppingCartLegalMsgLineVOTransformer INSTANCE = new UpdateShoppingCartLegalMsgLineVOTransformer();
	
	private UpdateShoppingCartLegalMsgLineVOTransformer() {
	}
	
	public static UpdateShoppingCartLegalMsgLineVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	protected UpdateShoppingCartLegalMsgLineVO dtoToVoTransform(UpdateShoppingCartLegalMsgLineVODTO dto) {
		
		UpdateShoppingCartLegalMsgLineVO vo = new UpdateShoppingCartLegalMsgLineVO();
		
		vo.setName(dto.getName());
		vo.setBuyQuantity(String.valueOf(dto.getBuyQuantity()));
		
		return vo;
	}
}
