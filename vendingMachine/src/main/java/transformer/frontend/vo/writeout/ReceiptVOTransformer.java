package transformer.frontend.vo.writeout;

import bean.dto.frontend.vo.writeout.ReceiptVODTO;
import bean.vo.frontend.writeout.ReceiptVO;
import template.transformer.bean.vo.VOWriteOutTransformerTemplate;

public class ReceiptVOTransformer extends VOWriteOutTransformerTemplate<ReceiptVODTO, ReceiptVO> {

	private BoughtGoodsMsgVOTransformer boughtGoodsMsgVOTransformer;
	
	
	private static final ReceiptVOTransformer INSTANCE = new ReceiptVOTransformer();
	
	private ReceiptVOTransformer() {
		
		boughtGoodsMsgVOTransformer = BoughtGoodsMsgVOTransformer.getInstance();
	}
	
	public static ReceiptVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	protected ReceiptVO dtoToVoTransform(ReceiptVODTO dto) {

		ReceiptVO vo = new ReceiptVO();
		
		vo.setPaidMoneyMsg(String.valueOf(dto.getPaidMoneyMsg()));
		vo.setTotalPriceMsg(String.valueOf(dto.getPaidMoneyMsg()));
		vo.setChangeMsg(String.valueOf(dto.getPaidMoneyMsg()));
		vo.setBoughtGoodsMsgs(boughtGoodsMsgVOTransformer.dtoListToVoList(dto.getBoughtGoodsMsgs()));
		
		return vo;
	}
}
