package transformer.frontend.vo.writeout;

import bean.dto.frontend.vo.writeout.CheckoutMoneyIllegalMsgVODTO;
import bean.vo.frontend.writeout.CheckoutMoneyIllegalMsgVO;
import template.transformer.bean.vo.VOWriteOutTransformerTemplate;

public class CheckoutMoneyIllegalMsgVOTransformer extends VOWriteOutTransformerTemplate<CheckoutMoneyIllegalMsgVODTO, CheckoutMoneyIllegalMsgVO> {

	private static final CheckoutMoneyIllegalMsgVOTransformer INSTANCE = new CheckoutMoneyIllegalMsgVOTransformer();
	
	private CheckoutMoneyIllegalMsgVOTransformer() {
	}
	
	public static CheckoutMoneyIllegalMsgVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	protected CheckoutMoneyIllegalMsgVO dtoToVoTransform(CheckoutMoneyIllegalMsgVODTO dto) {
		
		CheckoutMoneyIllegalMsgVO vo = new CheckoutMoneyIllegalMsgVO();
		
		vo.setHasMsg(dto.getHasMsg().getDescription());
		
		return vo;
	}
}
