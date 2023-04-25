package transformer.frontend.vo.writeout;

import java.util.List;

import bean.dto.frontend.vo.writeout.AddShoppingCartMsgVODTO;
import bean.vo.frontend.writeout.AddShoppingCartMsgVO;
import template.transformer.bean.vo.VOWriteOutTransformerTemplate;

public class AddShoppingCartMsgVOTransformer extends VOWriteOutTransformerTemplate<AddShoppingCartMsgVODTO, AddShoppingCartMsgVO> {
	
	private static final AddShoppingCartMsgVOTransformer INSTANCE = new AddShoppingCartMsgVOTransformer();
	
	private AddShoppingCartMsgVOTransformer() {
	}
	
	public static AddShoppingCartMsgVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	protected AddShoppingCartMsgVO dtoToVoTransform(AddShoppingCartMsgVODTO dto) {
		
		AddShoppingCartMsgVO vo = new AddShoppingCartMsgVO();
		
		List<String> names = dto.getNames();
		
		vo.setHasMsg(dto.getHasMsg().getDescription());
		vo.setNames(names.toArray(new String[names.size()]));
		
		return vo;
	}
}
