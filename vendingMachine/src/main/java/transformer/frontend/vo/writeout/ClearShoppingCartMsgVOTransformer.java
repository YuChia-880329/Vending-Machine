package transformer.frontend.vo.writeout;

import bean.dto.frontend.vo.writeout.ClearShoppingCartMsgVODTO;
import bean.vo.frontend.writeout.ClearShoppingCartMsgVO;
import template.transformer.bean.vo.VOWriteOutTransformerTemplate;

public class ClearShoppingCartMsgVOTransformer extends VOWriteOutTransformerTemplate<ClearShoppingCartMsgVODTO, ClearShoppingCartMsgVO> {

	private static final ClearShoppingCartMsgVOTransformer INSTANCE = new ClearShoppingCartMsgVOTransformer();
	
	private ClearShoppingCartMsgVOTransformer() {
	}
	
	public static ClearShoppingCartMsgVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	protected ClearShoppingCartMsgVO dtoToVoTransform(ClearShoppingCartMsgVODTO dto) {
		
		ClearShoppingCartMsgVO vo = new ClearShoppingCartMsgVO();
		
		vo.setHasMsg(dto.getHasMsg().getDescription());
		
		return vo;
	}
}
