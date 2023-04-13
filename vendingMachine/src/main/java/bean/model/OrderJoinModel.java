package bean.model;

import java.sql.Timestamp;

public class OrderJoinModel {

	private String customerName;
	private Timestamp timestamp;
	private String goodsName;
	private int goodsPrice;
	private int buyQuantity;
	private int totalPrice;
	
	
	public OrderJoinModel() {
	}
	public OrderJoinModel(String customerName, Timestamp timestamp, String goodsName, int goodsPrice, int buyQuantity,
			int totalPrice) {

		this.customerName = customerName;
		this.timestamp = timestamp;
		this.goodsName = goodsName;
		this.goodsPrice = goodsPrice;
		this.buyQuantity = buyQuantity;
		this.totalPrice = totalPrice;
	}
	
	
	public String getCustomerName() {
		return customerName;
	}
	public Timestamp getTimestamp() {
		return timestamp;
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
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
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
