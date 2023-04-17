package bean.dto.backend.goodsUpdate.vo.writeout;

import enumeration.Status;

public class UpdateFormGoodsVODTO {

	private int id;
	private int price;
	private int quantity;
	private Status status;
	
	
	public UpdateFormGoodsVODTO() {
	}
	public UpdateFormGoodsVODTO(int id, int price, int quantity, Status status) {

		this.id = id;
		this.price = price;
		this.quantity = quantity;
		this.status = status;
	}
	
	
	public int getId() {
		return id;
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
