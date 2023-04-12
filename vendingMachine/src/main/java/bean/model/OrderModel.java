package bean.model;

import java.sql.Timestamp;

public class OrderModel {

	private int id;
	private Timestamp dateTime;
	private String customerId;
	private int goodsId;
	private int goodsPrice;
	private int buyQuantity;
	
	
	public OrderModel() {
	}
	public OrderModel(int id, Timestamp dateTime, String customerId, int goodsId, int goodsPrice, int buyQuantity) {
		this.id = id;
		this.dateTime = dateTime;
		this.customerId = customerId;
		this.goodsId = goodsId;
		this.goodsPrice = goodsPrice;
		this.buyQuantity = buyQuantity;
	}
	
	
	public int getId() {
		return id;
	}
	public Timestamp getDateTime() {
		return dateTime;
	}
	public String getCustomerId() {
		return customerId;
	}
	public int getGoodsId() {
		return goodsId;
	}
	public int getGoodsPrice() {
		return goodsPrice;
	}
	public int getBuyQuantity() {
		return buyQuantity;
	}
	
	
	public void setId(int id) {
		this.id = id;
	}
	public void setDateTime(Timestamp dateTime) {
		this.dateTime = dateTime;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}
	public void setGoodsPrice(int goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public void setBuyQuantity(int buyQuantity) {
		this.buyQuantity = buyQuantity;
	}
	
}
