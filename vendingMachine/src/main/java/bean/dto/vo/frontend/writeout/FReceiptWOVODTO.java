package bean.dto.vo.frontend.writeout;

import java.util.List;

import enumeration.Has;

public class FReceiptWOVODTO {

	private Has hasReceipt;
	private int paidMoney;
	private int totalPrice;
	private int change;
	private List<FRBoughtGoodsWOVODTO> boughtGoods;
	
	
	public FReceiptWOVODTO() {
	}
	public FReceiptWOVODTO(Has hasReceipt, int paidMoney, int totalPrice, int change,
			List<FRBoughtGoodsWOVODTO> boughtGoods) {

		this.hasReceipt = hasReceipt;
		this.paidMoney = paidMoney;
		this.totalPrice = totalPrice;
		this.change = change;
		this.boughtGoods = boughtGoods;
	}
	
	
	public Has getHasReceipt() {
		return hasReceipt;
	}
	public int getPaidMoney() {
		return paidMoney;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public int getChange() {
		return change;
	}
	public List<FRBoughtGoodsWOVODTO> getBoughtGoods() {
		return boughtGoods;
	}
	
	
	public void setHasReceipt(Has hasReceipt) {
		this.hasReceipt = hasReceipt;
	}
	public void setPaidMoney(int paidMoney) {
		this.paidMoney = paidMoney;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public void setChange(int change) {
		this.change = change;
	}
	public void setBoughtGoods(List<FRBoughtGoodsWOVODTO> boughtGoods) {
		this.boughtGoods = boughtGoods;
	}
}
