package transformer.frontend.vo.writeout;

import bean.dto.frontend.vo.writeout.UpdateShoppingCartMsgVODTO;
import bean.vo.frontend.writeout.UpdateShoppingCartMsgLineVO;
import bean.vo.frontend.writeout.UpdateShoppingCartMsgVO;
import template.transformer.bean.vo.VOWriteOutTransformerTemplate;

public class UpdateShoppingCartMsgVOTransformer extends VOWriteOutTransformerTemplate<UpdateShoppingCartMsgVODTO, UpdateShoppingCartMsgVO> {

	private UpdateShoppingCartMsgLineVOTransformer updateShoppingCartMsgLineVOTransformer;
	
	
	private static final UpdateShoppingCartMsgVOTransformer INSTANCE = new UpdateShoppingCartMsgVOTransformer();
	
	private UpdateShoppingCartMsgVOTransformer() {
		
		updateShoppingCartMsgLineVOTransformer = UpdateShoppingCartMsgLineVOTransformer.getInstance();
	}
	
	public static UpdateShoppingCartMsgVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	protected UpdateShoppingCartMsgVO dtoToVoTransform(UpdateShoppingCartMsgVODTO dto) {

		UpdateShoppingCartMsgVO vo = new UpdateShoppingCartMsgVO();
		
		vo.setHasMsg(String.valueOf(dto.getHasMsg()));
		vo.setLines(updateShoppingCartMsgLineVOTransformer.dtoListToVoArray(dto.getLines(), size -> new UpdateShoppingCartMsgLineVO[size]));
		
		return vo;
	}
}
