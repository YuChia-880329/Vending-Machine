package transformer.frontend.vo.writeout;

import bean.dto.frontend.vo.writeout.AddShoppingCartIllegalMsgLineVODTO;
import bean.vo.frontend.writeout.AddShoppingCartIllegalMsgLineVO;
import template.transformer.bean.vo.VOWriteOutTransformerTemplate;

public class AddShoppingCartIllegalMsgLineVOTransformer extends VOWriteOutTransformerTemplate<AddShoppingCartIllegalMsgLineVODTO, AddShoppingCartIllegalMsgLineVO> {

	private static final AddShoppingCartIllegalMsgLineVOTransformer INSTANCE = new AddShoppingCartIllegalMsgLineVOTransformer();
	
	private AddShoppingCartIllegalMsgLineVOTransformer() {
	}
	
	public static AddShoppingCartIllegalMsgLineVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	protected AddShoppingCartIllegalMsgLineVO dtoToVoTransform(AddShoppingCartIllegalMsgLineVODTO dto) {
		
		AddShoppingCartIllegalMsgLineVO vo = new AddShoppingCartIllegalMsgLineVO();
		
		vo.setName(dto.getName());
		
		return vo;
	}
}
