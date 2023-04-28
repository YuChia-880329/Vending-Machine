package bean.obj.frontend.cache.receiptContent;

import java.util.List;

public class ReceiptContentOBJ {

	private PaidMoneyMsgOBJ paidMoneyMsg;
	private TotalPriceMsgOBJ totalPriceMsg;
	private ChangeMsgOBJ changeMsg;
	private List<BoughtGoodsMsgOBJ> boughtGoodsMsgs;
	
	
	public ReceiptContentOBJ() {
	}
	public ReceiptContentOBJ(PaidMoneyMsgOBJ paidMoneyMsg, TotalPriceMsgOBJ totalPriceMsg, 
			ChangeMsgOBJ changeMsg, List<BoughtGoodsMsgOBJ> boughtGoods) {

		this.paidMoneyMsg = paidMoneyMsg;
		this.totalPriceMsg = totalPriceMsg;
		this.changeMsg = changeMsg;
		this.boughtGoodsMsgs = boughtGoods;
	}
	
	public PaidMoneyMsgOBJ getPaidMoneyMsg() {
		return paidMoneyMsg;
	}
	public TotalPriceMsgOBJ getTotalPriceMsg() {
		return totalPriceMsg;
	}
	public ChangeMsgOBJ getChangeMsg() {
		return changeMsg;
	}
	public List<BoughtGoodsMsgOBJ> getBoughtGoodsMsgs() {
		return boughtGoodsMsgs;
	}
	
	
	public void setPaidMoneyMsg(PaidMoneyMsgOBJ paidMoneyMsg) {
		this.paidMoneyMsg = paidMoneyMsg;
	}
	public void setTotalPriceMsg(TotalPriceMsgOBJ totalPriceMsg) {
		this.totalPriceMsg = totalPriceMsg;
	}
	public void setChangeMsg(ChangeMsgOBJ changeMsg) {
		this.changeMsg = changeMsg;
	}
	public void setBoughtGoodsMsgs(List<BoughtGoodsMsgOBJ> boughtGoodsMsgs) {
		this.boughtGoodsMsgs = boughtGoodsMsgs;
	}
}
