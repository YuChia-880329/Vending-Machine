package bean.dto.model;

import java.time.LocalDateTime;

public class OrderJoinModelDTO {

	private String customerName;
	private LocalDateTime dateTime;
	private String goodsName;
	private int goodsPrice;
	private int buyQuantity;
	private int totalPrice;
	
	
	public OrderJoinModelDTO() {
	}
	public OrderJoinModelDTO(String customerName, LocalDateTime dateTime, String goodsName, int goodsPrice,
			int buyQuantity, int totalPrice) {

		this.customerName = customerName;
		this.dateTime = dateTime;
		this.goodsName = goodsName;
		this.goodsPrice = goodsPrice;
		this.buyQuantity = buyQuantity;
		this.totalPrice = totalPrice;
	}
	
	
	public String getCustomerName() {
		return customerName;
	}
	public LocalDateTime getDateTime() {
		return dateTime;
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
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
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
