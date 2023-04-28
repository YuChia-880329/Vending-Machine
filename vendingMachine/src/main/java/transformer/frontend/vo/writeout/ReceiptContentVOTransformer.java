package transformer.frontend.vo.writeout;

import bean.dto.frontend.vo.writeout.ReceiptContentVODTO;
import bean.vo.frontend.writeout.BoughtGoodsMsgVO;
import bean.vo.frontend.writeout.ReceiptContentVO;
import template.transformer.bean.vo.VOWriteOutTransformerTemplate;

public class ReceiptContentVOTransformer extends VOWriteOutTransformerTemplate<ReceiptContentVODTO, ReceiptContentVO> {

	private PaidMoneyMsgVOTransformer paidMoneyMsgVOTransformer;
	private TotalPriceMsgVOTransformer totalPriceMsgVOTransformer;
	private ChangeMsgVOTransformer changeMsgVOTransformer;
	private BoughtGoodsMsgVOTransformer boughtGoodsMsgVOTransformer;
	
	
	private static final ReceiptContentVOTransformer INSTANCE = new ReceiptContentVOTransformer();
	
	private ReceiptContentVOTransformer() {
		
		paidMoneyMsgVOTransformer = PaidMoneyMsgVOTransformer.getInstance();
		totalPriceMsgVOTransformer = TotalPriceMsgVOTransformer.getInstance();
		changeMsgVOTransformer = ChangeMsgVOTransformer.getInstance();
		boughtGoodsMsgVOTransformer = BoughtGoodsMsgVOTransformer.getInstance();
	}
	
	public static ReceiptContentVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	protected ReceiptContentVO dtoToVoTransform(ReceiptContentVODTO dto) {

		ReceiptContentVO vo = new ReceiptContentVO();
		
		vo.setPaidMoneyMsg(paidMoneyMsgVOTransformer.dtoToVo(dto.getPaidMoneyMsg()));
		vo.setTotalPriceMsg(totalPriceMsgVOTransformer.dtoToVo(dto.getTotalPriceMsg()));
		vo.setChangeMsg(changeMsgVOTransformer.dtoToVo(dto.getChangeMsg()));
		vo.setBoughtGoodsMsgs(boughtGoodsMsgVOTransformer.dtoListToVoArray(dto.getBoughtGoodsMsgs(), size -> new BoughtGoodsMsgVO[size]));
		
		return vo;
	}
}
