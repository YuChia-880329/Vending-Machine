package transformer.frontend.vo.writeout;

import bean.dto.frontend.vo.writeout.AddShoppingCartMsgLineVODTO;
import bean.vo.frontend.writeout.AddShoppingCartMsgLineVO;
import template.transformer.bean.vo.VOWriteOutTransformerTemplate;

public class AddShoppingCartMsgLineVOTransformer extends VOWriteOutTransformerTemplate<AddShoppingCartMsgLineVODTO, AddShoppingCartMsgLineVO> {
	
	private static final AddShoppingCartMsgLineVOTransformer INSTANCE = new AddShoppingCartMsgLineVOTransformer();
	
	private AddShoppingCartMsgLineVOTransformer() {
	}
	
	public static AddShoppingCartMsgLineVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	protected AddShoppingCartMsgLineVO dtoToVoTransform(AddShoppingCartMsgLineVODTO dto) {
		
		AddShoppingCartMsgLineVO vo = new AddShoppingCartMsgLineVO();
		
		vo.setName(dto.getName());
		vo.setAddQuantity(String.valueOf(dto.getAddQuantity()));
		
		return vo;
	}
	
	

}
