package transformer.frontend.vo.writeout;

import bean.dto.frontend.vo.writeout.UpdateShoppingCartMsgLineVODTO;
import bean.vo.frontend.writeout.UpdateShoppingCartMsgLineVO;
import template.transformer.bean.vo.VOWriteOutTransformerTemplate;

public class UpdateShoppingCartMsgLineVOTransformer extends VOWriteOutTransformerTemplate<UpdateShoppingCartMsgLineVODTO, UpdateShoppingCartMsgLineVO> {

	private static final UpdateShoppingCartMsgLineVOTransformer INSTANCE = new UpdateShoppingCartMsgLineVOTransformer();
	
	private UpdateShoppingCartMsgLineVOTransformer() {
	}
	
	public static UpdateShoppingCartMsgLineVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	protected UpdateShoppingCartMsgLineVO dtoToVoTransform(UpdateShoppingCartMsgLineVODTO dto) {
		
		UpdateShoppingCartMsgLineVO vo = new UpdateShoppingCartMsgLineVO();
		
		vo.setName(dto.getName());
		vo.setBuyQuantity(String.valueOf(vo.getBuyQuantity()));
		
		return vo;
	}
}
