package transformer.frontend.vo.writeout;

import bean.dto.frontend.vo.writeout.AddShoppingCartMsgVODTO;
import bean.vo.frontend.writeout.AddShoppingCartMsgLineVO;
import bean.vo.frontend.writeout.AddShoppingCartMsgVO;
import template.transformer.bean.vo.VOWriteOutTransformerTemplate;

public class AddShoppingCartMsgVOTransformer extends VOWriteOutTransformerTemplate<AddShoppingCartMsgVODTO, AddShoppingCartMsgVO> {

	private AddShoppingCartMsgLineVOTransformer addShoppingCartMsgLineVOTransformer;
	
	
	private static final AddShoppingCartMsgVOTransformer INSTANCE = new AddShoppingCartMsgVOTransformer();
	
	private AddShoppingCartMsgVOTransformer() {
		
		addShoppingCartMsgLineVOTransformer = AddShoppingCartMsgLineVOTransformer.getInstance();
	}
	
	public static AddShoppingCartMsgVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	protected AddShoppingCartMsgVO dtoToVoTransform(AddShoppingCartMsgVODTO dto) {
		
		AddShoppingCartMsgVO vo = new AddShoppingCartMsgVO();
		
		vo.setHasMsg(String.valueOf(dto.getHasMsg()));
		vo.setLines(addShoppingCartMsgLineVOTransformer.dtoListToVoArray(dto.getLines(), size -> new AddShoppingCartMsgLineVO[size]));
		
		return vo;
	}
}
