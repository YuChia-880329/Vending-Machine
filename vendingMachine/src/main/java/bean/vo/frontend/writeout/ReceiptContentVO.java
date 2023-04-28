package bean.vo.frontend.writeout;

public class ReceiptContentVO {

	private PaidMoneyMsgVO paidMoneyMsg;
	private TotalPriceMsgVO totalPriceMsg;
	private ChangeMsgVO changeMsg;
	private BoughtGoodsMsgVO[] boughtGoodsMsgs;
	
	
	public ReceiptContentVO() {
	}
	public ReceiptContentVO(PaidMoneyMsgVO paidMoneyMsg, TotalPriceMsgVO totalPriceMsg, 
			ChangeMsgVO changeMsg, BoughtGoodsMsgVO[] boughtGoodsMsgs) {

		this.paidMoneyMsg = paidMoneyMsg;
		this.totalPriceMsg = totalPriceMsg;
		this.changeMsg = changeMsg;
		this.boughtGoodsMsgs = boughtGoodsMsgs;
	}
	
	
	public PaidMoneyMsgVO getPaidMoneyMsg() {
		return paidMoneyMsg;
	}
	public TotalPriceMsgVO getTotalPriceMsg() {
		return totalPriceMsg;
	}
	public ChangeMsgVO getChangeMsg() {
		return changeMsg;
	}
	public BoughtGoodsMsgVO[] getBoughtGoodsMsgs() {
		return boughtGoodsMsgs;
	}
	
	
	public void setPaidMoneyMsg(PaidMoneyMsgVO paidMoneyMsg) {
		this.paidMoneyMsg = paidMoneyMsg;
	}
	public void setTotalPriceMsg(TotalPriceMsgVO totalPriceMsg) {
		this.totalPriceMsg = totalPriceMsg;
	}
	public void setChangeMsg(ChangeMsgVO changeMsg) {
		this.changeMsg = changeMsg;
	}
	public void setBoughtGoodsMsgs(BoughtGoodsMsgVO[] boughtGoodsMsgs) {
		this.boughtGoodsMsgs = boughtGoodsMsgs;
	}
}
