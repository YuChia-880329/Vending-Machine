package bean.vo.frontend.writeout;

import java.util.List;

public class ReceiptVO {

	private String paidMoneyMsg;
	private String totalPriceMsg;
	private String changeMsg;
	private List<BoughtGoodsMsgVO> boughtGoodsMsgs;
	
	
	public ReceiptVO() {
	}
	public ReceiptVO(String paidMoney, String totalPrice, String change,
			List<BoughtGoodsMsgVO> boughtGoodsMsgs) {

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
	public List<BoughtGoodsMsgVO> getBoughtGoodsMsgs() {
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
	public void setBoughtGoodsMsgs(List<BoughtGoodsMsgVO> boughtGoodsMsgs) {
		this.boughtGoodsMsgs = boughtGoodsMsgs;
	}
	
}
