package transformer.frontend.vo.writeout;

import bean.dto.frontend.vo.writeout.UpdateShoppingCartLegalMsgVODTO;
import bean.vo.frontend.writeout.UpdateShoppingCartLegalMsgLineVO;
import bean.vo.frontend.writeout.UpdateShoppingCartLegalMsgVO;
import template.transformer.bean.vo.VOWriteOutTransformerTemplate;

public class UpdateShoppingCartLegalMsgVOTransformer extends VOWriteOutTransformerTemplate<UpdateShoppingCartLegalMsgVODTO, UpdateShoppingCartLegalMsgVO> {

	private UpdateShoppingCartLegalMsgLineVOTransformer updateShoppingCartMsgLineVOTransformer;
	
	
	private static final UpdateShoppingCartLegalMsgVOTransformer INSTANCE = new UpdateShoppingCartLegalMsgVOTransformer();
	
	private UpdateShoppingCartLegalMsgVOTransformer() {
		
		updateShoppingCartMsgLineVOTransformer = UpdateShoppingCartLegalMsgLineVOTransformer.getInstance();
	}
	
	public static UpdateShoppingCartLegalMsgVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	protected UpdateShoppingCartLegalMsgVO dtoToVoTransform(UpdateShoppingCartLegalMsgVODTO dto) {

		UpdateShoppingCartLegalMsgVO vo = new UpdateShoppingCartLegalMsgVO();
		
		vo.setHasMsg(String.valueOf(dto.getHasMsg()));
		vo.setLines(updateShoppingCartMsgLineVOTransformer.dtoListToVoArray(dto.getLines(), size -> new UpdateShoppingCartLegalMsgLineVO[size]));
		
		return vo;
	}
}
