package transformer.frontend.vo.writeout;

import bean.dto.frontend.vo.writeout.AddShoppingCartLegalMsgVODTO;
import bean.vo.frontend.writeout.AddShoppingCartLegalMsgLineVO;
import bean.vo.frontend.writeout.AddShoppingCartLegalMsgVO;
import template.transformer.bean.vo.VOWriteOutTransformerTemplate;

public class AddShoppingCartLegalMsgVOTransformer extends VOWriteOutTransformerTemplate<AddShoppingCartLegalMsgVODTO, AddShoppingCartLegalMsgVO> {

	private AddShoppingCartLegalMsgLineVOTransformer addShoppingCartMsgLineVOTransformer;
	
	
	private static final AddShoppingCartLegalMsgVOTransformer INSTANCE = new AddShoppingCartLegalMsgVOTransformer();
	
	private AddShoppingCartLegalMsgVOTransformer() {
		
		addShoppingCartMsgLineVOTransformer = AddShoppingCartLegalMsgLineVOTransformer.getInstance();
	}
	
	public static AddShoppingCartLegalMsgVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	protected AddShoppingCartLegalMsgVO dtoToVoTransform(AddShoppingCartLegalMsgVODTO dto) {
		
		AddShoppingCartLegalMsgVO vo = new AddShoppingCartLegalMsgVO();
		
		vo.setHasMsg(String.valueOf(dto.getHasMsg()));
		vo.setLines(addShoppingCartMsgLineVOTransformer.dtoListToVoArray(dto.getLines(), size -> new AddShoppingCartLegalMsgLineVO[size]));
		
		return vo;
	}
}
