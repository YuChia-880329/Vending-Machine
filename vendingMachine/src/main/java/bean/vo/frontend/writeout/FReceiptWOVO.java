package bean.vo.frontend.writeout;

import java.util.List;

public class FReceiptWOVO {

	private String hasReceipt;
	private String paidMoney;
	private String totalPrice;
	private String change;
	private List<FRBoughtGoodsWOVO> boughtGoods;
	
	
	public FReceiptWOVO() {
	}
	public FReceiptWOVO(String hasReceipt, String paidMoney, String totalPrice, String change,
			List<FRBoughtGoodsWOVO> boughtGoods) {

		this.hasReceipt = hasReceipt;
		this.paidMoney = paidMoney;
		this.totalPrice = totalPrice;
		this.change = change;
		this.boughtGoods = boughtGoods;
	}
	
	
	public String getHasReceipt() {
		return hasReceipt;
	}
	public String getPaidMoney() {
		return paidMoney;
	}
	public String getTotalPrice() {
		return totalPrice;
	}
	public String getChange() {
		return change;
	}
	public List<FRBoughtGoodsWOVO> getBoughtGoods() {
		return boughtGoods;
	}
	
	
	public void setHasReceipt(String hasReceipt) {
		this.hasReceipt = hasReceipt;
	}
	public void setPaidMoney(String paidMoney) {
		this.paidMoney = paidMoney;
	}
	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}
	public void setChange(String change) {
		this.change = change;
	}
	public void setBoughtGoods(List<FRBoughtGoodsWOVO> boughtGoods) {
		this.boughtGoods = boughtGoods;
	}
	
}
