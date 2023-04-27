package transformer.frontend.vo.writeout;

import bean.dto.frontend.vo.writeout.UpdateShoppingCartIllegalMsgVODTO;
import bean.vo.frontend.writeout.UpdateShoppingCartIllegalMsgLineVO;
import bean.vo.frontend.writeout.UpdateShoppingCartIllegalMsgVO;
import template.transformer.bean.vo.VOWriteOutTransformerTemplate;

public class UpdateShoppingCartIllegalMsgVOTransformer extends VOWriteOutTransformerTemplate<UpdateShoppingCartIllegalMsgVODTO, UpdateShoppingCartIllegalMsgVO> {

	private UpdateShoppingCartIllegalMsgLineVOTransformer updateShoppingCartIllegalMsgLineVOTransformer;
	
	
	private static final UpdateShoppingCartIllegalMsgVOTransformer INSTANCE = new UpdateShoppingCartIllegalMsgVOTransformer();
	
	private UpdateShoppingCartIllegalMsgVOTransformer() {
		
		updateShoppingCartIllegalMsgLineVOTransformer = UpdateShoppingCartIllegalMsgLineVOTransformer.getInstance();
	}
	
	public static UpdateShoppingCartIllegalMsgVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	protected UpdateShoppingCartIllegalMsgVO dtoToVoTransform(UpdateShoppingCartIllegalMsgVODTO dto) {
		
		UpdateShoppingCartIllegalMsgVO vo = new UpdateShoppingCartIllegalMsgVO();
		
		vo.setHasMsg(dto.getHasMsg().getDescription());
		vo.setLines(updateShoppingCartIllegalMsgLineVOTransformer.dtoListToVoArray(dto.getLines(), size -> new UpdateShoppingCartIllegalMsgLineVO[size]));
		
		return vo;
	}
}
