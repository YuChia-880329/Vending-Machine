package temp.transformer.frontend.vo.writeout;

import temp.bean.dto.frontend.vo.writeout.UpdateShoppingCartResultVODTO;
import temp.bean.vo.frontend.writeout.UpdateShoppingCartResultVO;
import template.transformer.bean.vo.VOWriteOutTransformerTemplate;
import transformer.frontend.vo.writeout.UpdateShoppingCartIllegalMsgVOTransformer;
import transformer.frontend.vo.writeout.UpdateShoppingCartLegalMsgVOTransformer;

public class UpdateShoppingCartResultVOTransformer extends VOWriteOutTransformerTemplate<UpdateShoppingCartResultVODTO, UpdateShoppingCartResultVO> {

	private UpdateShoppingCartIllegalMsgVOTransformer updateShoppingCartIllegalMsgVOTransformer;
	private UpdateShoppingCartLegalMsgVOTransformer updateShoppingCartLegalMsgVOTransformer;
	
	
	private static final UpdateShoppingCartResultVOTransformer INSTANCE = new UpdateShoppingCartResultVOTransformer();
	
	private UpdateShoppingCartResultVOTransformer() {
		
		updateShoppingCartIllegalMsgVOTransformer = UpdateShoppingCartIllegalMsgVOTransformer.getInstance();
		updateShoppingCartLegalMsgVOTransformer = UpdateShoppingCartLegalMsgVOTransformer.getInstance();
	}
	
	public static UpdateShoppingCartResultVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	protected UpdateShoppingCartResultVO dtoToVoTransform(UpdateShoppingCartResultVODTO dto) {
		
		UpdateShoppingCartResultVO vo = new UpdateShoppingCartResultVO();
		
		vo.setUpdateShoppingCartIllegalMsg(updateShoppingCartIllegalMsgVOTransformer.dtoToVo(dto.getUpdateShoppingCartIllegalMsg()));
		vo.setUpdateShoppingCartLegalMsg(updateShoppingCartLegalMsgVOTransformer.dtoToVo(dto.getUpdateShoppingCartLegalMsg()));
		
		return vo;
	}
}
