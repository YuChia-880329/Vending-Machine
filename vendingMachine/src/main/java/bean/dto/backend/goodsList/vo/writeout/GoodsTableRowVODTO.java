package bean.dto.backend.goodsList.vo.writeout;

import enumeration.Status;

public class GoodsTableRowVODTO {

	private int id;
	private String name;
	private int price;
	private int quantity;
	private Status status;
	
	
	public GoodsTableRowVODTO() {
	}
	public GoodsTableRowVODTO(int id, String name, int price, int quantity, Status status) {

		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.status = status;
	}
	
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getPrice() {
		return price;
	}
	public int getQuantity() {
		return quantity;
	}
	public Status getStatus() {
		return status;
	}
	
	
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
}
