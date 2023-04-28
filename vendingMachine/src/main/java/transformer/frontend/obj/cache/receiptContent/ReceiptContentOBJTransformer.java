package transformer.frontend.obj.cache.receiptContent;

import bean.dto.frontend.obj.cache.receiptContent.ReceiptContentOBJDTO;
import bean.obj.frontend.cache.receiptContent.ReceiptContentOBJ;
import template.memory.cache.CacheTransformerTemplate;

public class ReceiptContentOBJTransformer extends CacheTransformerTemplate<ReceiptContentOBJ, ReceiptContentOBJDTO> {

	private PaidMoneyMsgOBJTransformer paidMoneyMsgOBJTransformer;
	private TotalPriceMsgOBJTransformer totalPriceMsgOBJTransformer;
	private ChangeMsgOBJTransformer changeMsgOBJTransformer;
	private BoughtGoodsMsgOBJTransformer boughtGoodsMsgOBJTransformer;
	
	
	private static final ReceiptContentOBJTransformer INSTANCE = new ReceiptContentOBJTransformer();
	
	private ReceiptContentOBJTransformer() {
		
		paidMoneyMsgOBJTransformer = PaidMoneyMsgOBJTransformer.getInstance();
		totalPriceMsgOBJTransformer = TotalPriceMsgOBJTransformer.getInstance();
		changeMsgOBJTransformer = ChangeMsgOBJTransformer.getInstance();
		boughtGoodsMsgOBJTransformer = BoughtGoodsMsgOBJTransformer.getInstance();
	}
	
	public static ReceiptContentOBJTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	protected ReceiptContentOBJDTO objToDtoTransform(ReceiptContentOBJ obj) {
		
		ReceiptContentOBJDTO dto = new ReceiptContentOBJDTO();
		
		dto.setPaidMoneyMsg(paidMoneyMsgOBJTransformer.objToDto(obj.getPaidMoneyMsg()));
		dto.setTotalPriceMsg(totalPriceMsgOBJTransformer.objToDto(obj.getTotalPriceMsg()));
		dto.setChangeMsg(changeMsgOBJTransformer.objToDto(obj.getChangeMsg()));
		dto.setBoughtGoodsMsgs(boughtGoodsMsgOBJTransformer.objListToDtoList(obj.getBoughtGoodsMsgs()));
		
		return dto;
	}

	@Override
	protected ReceiptContentOBJ dtoToObjTransform(ReceiptContentOBJDTO dto) {
		
		ReceiptContentOBJ obj = new ReceiptContentOBJ();
		
		obj.setPaidMoneyMsg(paidMoneyMsgOBJTransformer.dtoToObj(dto.getPaidMoneyMsg()));
		obj.setTotalPriceMsg(totalPriceMsgOBJTransformer.dtoToObj(dto.getTotalPriceMsg()));
		obj.setChangeMsg(changeMsgOBJTransformer.dtoToObj(dto.getChangeMsg()));
		obj.setBoughtGoodsMsgs(boughtGoodsMsgOBJTransformer.dtoListToObjList(dto.getBoughtGoodsMsgs()));
		
		return obj;
	}
}
