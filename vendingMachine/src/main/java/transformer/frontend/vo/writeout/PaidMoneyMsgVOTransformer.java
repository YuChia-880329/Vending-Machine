package transformer.frontend.vo.writeout;

import bean.dto.frontend.vo.writeout.PaidMoneyMsgVODTO;
import bean.vo.frontend.writeout.PaidMoneyMsgVO;
import template.transformer.bean.vo.VOWriteOutTransformerTemplate;

public class PaidMoneyMsgVOTransformer extends VOWriteOutTransformerTemplate<PaidMoneyMsgVODTO, PaidMoneyMsgVO> {

	private static final PaidMoneyMsgVOTransformer INSTANCE = new PaidMoneyMsgVOTransformer();
	
	private PaidMoneyMsgVOTransformer() {
	}
	
	public static PaidMoneyMsgVOTransformer getInstance() {
		
		return INSTANCE;
	}

	
	@Override
	protected PaidMoneyMsgVO dtoToVoTransform(PaidMoneyMsgVODTO dto) {
		
		PaidMoneyMsgVO vo = new PaidMoneyMsgVO();
		
		vo.setPaidMoney(String.valueOf(dto.getPaidMoney()));
		
		return vo;
	}
}
