package temp.transformer.frontend.vo.writeout;

import temp.bean.dto.frontend.vo.writeout.CheckoutResultVODTO;
import temp.bean.vo.frontend.writeout.CheckoutResultVO;
import template.transformer.bean.vo.VOWriteOutTransformerTemplate;
import transformer.frontend.vo.writeout.CheckoutMoneyIllegalMsgVOTransformer;

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
