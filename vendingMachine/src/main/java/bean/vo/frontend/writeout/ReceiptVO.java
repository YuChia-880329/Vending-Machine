package bean.vo.frontend.writeout;

public class ReceiptVO {

	private String paidMoneyMsg;
	private String totalPriceMsg;
	private String changeMsg;
	private BoughtGoodsMsgVO[] boughtGoodsMsgs;
	
	
	public ReceiptVO() {
	}
	public ReceiptVO(String paidMoney, String totalPrice, String change,
			BoughtGoodsMsgVO[] boughtGoodsMsgs) {

		this.paidMoneyMsg = paidMoney;
		this.totalPriceMsg = totalPrice;
		this.changeMsg = change;
		this.boughtGoodsMsgs = boughtGoodsMsgs;
	}
	
	
	public String getPaidMoneyMsg() {
		return paidMoneyMsg;
	}
	public String getTotalPriceMsg() {
		return totalPriceMsg;
	}
	public String getChangeMsg() {
		return changeMsg;
	}
	public BoughtGoodsMsgVO[] getBoughtGoodsMsgs() {
		return boughtGoodsMsgs;
	}
	
	
	public void setPaidMoneyMsg(String paidMoneyMsg) {
		this.paidMoneyMsg = paidMoneyMsg;
	}
	public void setTotalPriceMsg(String totalPriceMsg) {
		this.totalPriceMsg = totalPriceMsg;
	}
	public void setChangeMsg(String changeMsg) {
		this.changeMsg = changeMsg;
	}
	public void setBoughtGoodsMsgs(BoughtGoodsMsgVO[] boughtGoodsMsgs) {
		this.boughtGoodsMsgs = boughtGoodsMsgs;
	}
	
}
