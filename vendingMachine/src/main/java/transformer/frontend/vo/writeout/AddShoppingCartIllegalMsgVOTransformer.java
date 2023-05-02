package transformer.frontend.vo.writeout;

import bean.dto.frontend.vo.writeout.AddShoppingCartIllegalMsgVODTO;
import bean.vo.frontend.writeout.AddShoppingCartIllegalMsgLineVO;
import bean.vo.frontend.writeout.AddShoppingCartIllegalMsgVO;
import template.transformer.bean.vo.VOWriteOutTransformerTemplate;

public class AddShoppingCartIllegalMsgVOTransformer extends VOWriteOutTransformerTemplate<AddShoppingCartIllegalMsgVODTO, AddShoppingCartIllegalMsgVO> {
	
	private AddShoppingCartIllegalMsgLineVOTransformer addShoppingCartIllegalMsgLineVOTransformer;
	
	
	private static final AddShoppingCartIllegalMsgVOTransformer INSTANCE = new AddShoppingCartIllegalMsgVOTransformer();
	
	private AddShoppingCartIllegalMsgVOTransformer() {
		
		addShoppingCartIllegalMsgLineVOTransformer = AddShoppingCartIllegalMsgLineVOTransformer.getInstance();
	}
	
	public static AddShoppingCartIllegalMsgVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	protected AddShoppingCartIllegalMsgVO dtoToVoTransform(AddShoppingCartIllegalMsgVODTO dto) {
		
		AddShoppingCartIllegalMsgVO vo = new AddShoppingCartIllegalMsgVO();
		
		vo.setHasMsg(String.valueOf(dto.getHasMsg()));
		vo.setLines(addShoppingCartIllegalMsgLineVOTransformer.dtoListToVoArray(dto.getLines(), size -> new AddShoppingCartIllegalMsgLineVO[size]));
		
		return vo;
	}
}
