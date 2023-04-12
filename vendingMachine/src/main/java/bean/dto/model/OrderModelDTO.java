package bean.dto.model;

import java.time.LocalDateTime;

public class OrderModelDTO {

	private int id;
	private LocalDateTime dateTime;
	private String customerId;
	private int goodsId;
	private int goodsPrice;
	private int buyQuantity;
	
	
	public OrderModelDTO() {
	}
	public OrderModelDTO(int id, LocalDateTime dateTime, String customerId, int goodsId, int goodsPrice, int buyQuantity) {
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
	public LocalDateTime getDateTime() {
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
	public void setDateTime(LocalDateTime dateTime) {
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
