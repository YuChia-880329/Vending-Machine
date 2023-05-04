package transformer.frontend.vo.writeout;

import bean.dto.frontend.vo.writeout.AddShoppingCartLegalMsgLineVODTO;
import bean.vo.frontend.writeout.AddShoppingCartLegalMsgLineVO;
import template.transformer.bean.vo.VOWriteOutTransformerTemplate;

public class AddShoppingCartLegalMsgLineVOTransformer extends VOWriteOutTransformerTemplate<AddShoppingCartLegalMsgLineVODTO, AddShoppingCartLegalMsgLineVO> {
	
	private static final AddShoppingCartLegalMsgLineVOTransformer INSTANCE = new AddShoppingCartLegalMsgLineVOTransformer();
	
	private AddShoppingCartLegalMsgLineVOTransformer() {
	}
	
	public static AddShoppingCartLegalMsgLineVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	protected AddShoppingCartLegalMsgLineVO dtoToVoTransform(AddShoppingCartLegalMsgLineVODTO dto) {
		
		AddShoppingCartLegalMsgLineVO vo = new AddShoppingCartLegalMsgLineVO();
		
		vo.setName(dto.getName());
		vo.setAddQuantity(String.valueOf(dto.getAddQuantity()));
		
		return vo;
	}
	
	

}
