package temp.transformer.frontend.vo.writeout;

import temp.bean.dto.frontend.vo.writeout.AddShoppingCartResultVODTO;
import temp.bean.vo.frontend.writeout.AddShoppingCartResultVO;
import template.transformer.bean.vo.VOWriteOutTransformerTemplate;
import transformer.frontend.vo.writeout.AddShoppingCartIllegalMsgVOTransformer;
import transformer.frontend.vo.writeout.AddShoppingCartLegalMsgVOTransformer;

public class AddShoppingCartResultVOTransformer extends VOWriteOutTransformerTemplate<AddShoppingCartResultVODTO, AddShoppingCartResultVO> {

	private AddShoppingCartIllegalMsgVOTransformer addShoppingCartIllegalMsgVOTransformer;
	private AddShoppingCartLegalMsgVOTransformer addShoppingCartLegalMsgVOTransformer;
	
	
	private static final AddShoppingCartResultVOTransformer INSTANCE = new AddShoppingCartResultVOTransformer();
	
	private AddShoppingCartResultVOTransformer() {
		
		addShoppingCartIllegalMsgVOTransformer = AddShoppingCartIllegalMsgVOTransformer.getInstance();
		addShoppingCartLegalMsgVOTransformer = AddShoppingCartLegalMsgVOTransformer.getInstance();
	}
	
	public static AddShoppingCartResultVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	protected AddShoppingCartResultVO dtoToVoTransform(AddShoppingCartResultVODTO dto) {
		
		AddShoppingCartResultVO vo = new AddShoppingCartResultVO();
		
		vo.setAddShoppingCartIllegalMsg(addShoppingCartIllegalMsgVOTransformer.dtoToVo(dto.getAddShoppingCartIllegalMsg()));
		vo.setAddShoppingCartLegalMsg(addShoppingCartLegalMsgVOTransformer.dtoToVo(dto.getAddShoppingCartLegalMsg()));
		
		return vo;
	}
}
