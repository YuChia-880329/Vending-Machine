package bean.dto.backend.orderList.vo.writeout;

import java.time.LocalDate;

public class OrderTableRowVODTO {

	private String customerName;
	private LocalDate date;
	private String goodsName;
	private int goodsPrice;
	private int buyQuantity;
	private int totalPrice;
	
	
	
	public OrderTableRowVODTO() {
	}
	public OrderTableRowVODTO(String customerName, LocalDate date, String goodsName, int goodsPrice, int buyQuantity,
			int totalPrice) {

		this.customerName = customerName;
		this.date = date;
		this.goodsName = goodsName;
		this.goodsPrice = goodsPrice;
		this.buyQuantity = buyQuantity;
		this.totalPrice = totalPrice;
	}
	
	
	public String getCustomerName() {
		return customerName;
	}
	public LocalDate getDate() {
		return date;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public int getGoodsPrice() {
		return goodsPrice;
	}
	public int getBuyQuantity() {
		return buyQuantity;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	
	
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public void setGoodsPrice(int goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public void setBuyQuantity(int buyQuantity) {
		this.buyQuantity = buyQuantity;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
}
