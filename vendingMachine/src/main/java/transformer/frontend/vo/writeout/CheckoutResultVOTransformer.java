package transformer.frontend.vo.writeout;

import bean.dto.frontend.vo.writeout.CheckoutResultVODTO;
import bean.vo.frontend.writeout.CheckoutResultVO;
import template.transformer.bean.vo.VOWriteOutTransformerTemplate;

public class CheckoutResultVOTransformer extends VOWriteOutTransformerTemplate<CheckoutResultVODTO, CheckoutResultVO> {

	private CheckoutMoneyIllegalMsgVOTransformer checkoutMoneyIllegalMsgVOTransformer;
	
	
	private static final CheckoutResultVOTransformer INSTANCE = new CheckoutResultVOTransformer();
	
	private CheckoutResultVOTransformer() {
		
		checkoutMoneyIllegalMsgVOTransformer = CheckoutMoneyIllegalMsgVOTransformer.getInstance();
	}
	
	public static CheckoutResultVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	protected CheckoutResultVO dtoToVoTransform(CheckoutResultVODTO dto) {
		
		CheckoutResultVO vo = new CheckoutResultVO();
		
		vo.setCheckoutMoneyIllegalMsg(checkoutMoneyIllegalMsgVOTransformer.dtoToVo(dto.getCheckoutMoneyIllegalMsg()));
		
		return vo;
	}
}
