package transformer.frontend.vo.writeout;

import bean.dto.frontend.vo.writeout.AddShoppingCartResultVODTO;
import bean.vo.frontend.writeout.AddShoppingCartResultVO;
import template.transformer.bean.vo.VOWriteOutTransformerTemplate;

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
