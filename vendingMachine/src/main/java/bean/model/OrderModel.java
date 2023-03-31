package bean.model;

import java.sql.Timestamp;

public class OrderModel {

	private int id;
	private Timestamp dateTime;
	private String customerId;
	private int goodId;
	private int price;
	private int quantity;
	
	
	public OrderModel() {
	}
	public OrderModel(int id, Timestamp dateTime, String customerId, int goodId, int price, int quantity) {
		this.id = id;
		this.dateTime = dateTime;
		this.customerId = customerId;
		this.goodId = goodId;
		this.price = price;
		this.quantity = quantity;
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
	public int getGoodId() {
		return goodId;
	}
	public int getPrice() {
		return price;
	}
	public int getQuantity() {
		return quantity;
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
	public void setGoodId(int goodId) {
		this.goodId = goodId;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	@Override
	public String toString() {
		return "OrderModel [id=" + id + ", dateTime=" + dateTime + ", customerId=" + customerId + ", goodId=" + goodId
				+ ", price=" + price + ", quantity=" + quantity + "]";
	}
}
