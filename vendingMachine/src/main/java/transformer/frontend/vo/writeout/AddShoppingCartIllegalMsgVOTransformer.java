package transformer.frontend.vo.writeout;

import java.util.List;

import bean.dto.frontend.vo.writeout.AddShoppingCartIllegalMsgVODTO;
import bean.vo.frontend.writeout.AddShoppingCartIllegalMsgVO;
import template.transformer.bean.vo.VOWriteOutTransformerTemplate;

public class AddShoppingCartIllegalMsgVOTransformer extends VOWriteOutTransformerTemplate<AddShoppingCartIllegalMsgVODTO, AddShoppingCartIllegalMsgVO> {
	
	private static final AddShoppingCartIllegalMsgVOTransformer INSTANCE = new AddShoppingCartIllegalMsgVOTransformer();
	
	private AddShoppingCartIllegalMsgVOTransformer() {
	}
	
	public static AddShoppingCartIllegalMsgVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	protected AddShoppingCartIllegalMsgVO dtoToVoTransform(AddShoppingCartIllegalMsgVODTO dto) {
		
		AddShoppingCartIllegalMsgVO vo = new AddShoppingCartIllegalMsgVO();
		
		List<String> names = dto.getNames();
		
		vo.setHasMsg(dto.getHasMsg().getDescription());
		vo.setLines(names.toArray(new String[names.size()]));
		
		return vo;
	}
}
