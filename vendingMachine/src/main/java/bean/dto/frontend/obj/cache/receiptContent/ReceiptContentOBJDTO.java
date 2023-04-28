package bean.dto.frontend.obj.cache.receiptContent;

import java.util.List;

public class ReceiptContentOBJDTO {

	private PaidMoneyMsgOBJDTO paidMoneyMsg;
	private TotalPriceMsgOBJDTO totalPriceMsg;
	private ChangeMsgOBJDTO changeMsg;
	private List<BoughtGoodsMsgOBJDTO> boughtGoodsMsgs;
	
	
	public ReceiptContentOBJDTO() {
	}
	public ReceiptContentOBJDTO(PaidMoneyMsgOBJDTO paidMoneyMsg, TotalPriceMsgOBJDTO totalPriceMsg, 
			ChangeMsgOBJDTO changeMsg, List<BoughtGoodsMsgOBJDTO> boughtGoods) {

		this.paidMoneyMsg = paidMoneyMsg;
		this.totalPriceMsg = totalPriceMsg;
		this.changeMsg = changeMsg;
		this.boughtGoodsMsgs = boughtGoods;
	}
	
	public PaidMoneyMsgOBJDTO getPaidMoneyMsg() {
		return paidMoneyMsg;
	}
	public TotalPriceMsgOBJDTO getTotalPriceMsg() {
		return totalPriceMsg;
	}
	public ChangeMsgOBJDTO getChangeMsg() {
		return changeMsg;
	}
	public List<BoughtGoodsMsgOBJDTO> getBoughtGoodsMsgs() {
		return boughtGoodsMsgs;
	}
	
	
	public void setPaidMoneyMsg(PaidMoneyMsgOBJDTO paidMoneyMsg) {
		this.paidMoneyMsg = paidMoneyMsg;
	}
	public void setTotalPriceMsg(TotalPriceMsgOBJDTO totalPriceMsg) {
		this.totalPriceMsg = totalPriceMsg;
	}
	public void setChangeMsg(ChangeMsgOBJDTO changeMsg) {
		this.changeMsg = changeMsg;
	}
	public void setBoughtGoodsMsgs(List<BoughtGoodsMsgOBJDTO> boughtGoodsMsgs) {
		this.boughtGoodsMsgs = boughtGoodsMsgs;
	}
}
