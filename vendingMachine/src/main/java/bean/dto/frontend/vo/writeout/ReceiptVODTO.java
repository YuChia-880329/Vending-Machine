package bean.dto.frontend.vo.writeout;

import java.util.List;

public class ReceiptVODTO {

	private String paidMoneyMsg;
	private String totalPriceMsg;
	private String changeMsg;
	private List<BoughtGoodsMsgVODTO> boughtGoodsMsgs;
	
	
	public ReceiptVODTO() {
	}
	public ReceiptVODTO(String paidMoneyMsg, String totalPriceMsg, String changeMsg,
			List<BoughtGoodsMsgVODTO> boughtGoods) {

		this.paidMoneyMsg = paidMoneyMsg;
		this.totalPriceMsg = totalPriceMsg;
		this.changeMsg = changeMsg;
		this.boughtGoodsMsgs = boughtGoods;
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
	public List<BoughtGoodsMsgVODTO> getBoughtGoodsMsgs() {
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
	public void setBoughtGoodsMsgs(List<BoughtGoodsMsgVODTO> boughtGoodsMsgs) {
		this.boughtGoodsMsgs = boughtGoodsMsgs;
	}
}
