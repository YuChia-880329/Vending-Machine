package bean.dto.frontend.vo.writeout;

import java.util.List;

public class ReceiptContentVODTO {

	private PaidMoneyMsgVODTO paidMoneyMsg;
	private TotalPriceMsgVODTO totalPriceMsg;
	private ChangeMsgVODTO changeMsg;
	private List<BoughtGoodsMsgVODTO> boughtGoodsMsgs;
	
	
	public ReceiptContentVODTO() {
	}
	public ReceiptContentVODTO(PaidMoneyMsgVODTO paidMoneyMsg, TotalPriceMsgVODTO totalPriceMsg, 
			ChangeMsgVODTO changeMsg, List<BoughtGoodsMsgVODTO> boughtGoods) {

		this.paidMoneyMsg = paidMoneyMsg;
		this.totalPriceMsg = totalPriceMsg;
		this.changeMsg = changeMsg;
		this.boughtGoodsMsgs = boughtGoods;
	}
	
	public PaidMoneyMsgVODTO getPaidMoneyMsg() {
		return paidMoneyMsg;
	}
	public TotalPriceMsgVODTO getTotalPriceMsg() {
		return totalPriceMsg;
	}
	public ChangeMsgVODTO getChangeMsg() {
		return changeMsg;
	}
	public List<BoughtGoodsMsgVODTO> getBoughtGoodsMsgs() {
		return boughtGoodsMsgs;
	}
	
	
	public void setPaidMoneyMsg(PaidMoneyMsgVODTO paidMoneyMsg) {
		this.paidMoneyMsg = paidMoneyMsg;
	}
	public void setTotalPriceMsg(TotalPriceMsgVODTO totalPriceMsg) {
		this.totalPriceMsg = totalPriceMsg;
	}
	public void setChangeMsg(ChangeMsgVODTO changeMsg) {
		this.changeMsg = changeMsg;
	}
	public void setBoughtGoodsMsgs(List<BoughtGoodsMsgVODTO> boughtGoodsMsgs) {
		this.boughtGoodsMsgs = boughtGoodsMsgs;
	}
}
