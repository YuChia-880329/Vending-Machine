package bean.dto.backend.goodsUpdate.vo.writeout;

import enumeration.Status;

public class BGUUFGoodsWOVODTO {

	private int id;
	private int quantity;
	private Status status;
	
	
	public BGUUFGoodsWOVODTO() {
	}
	public BGUUFGoodsWOVODTO(int id, int quantity, Status status) {

		this.id = id;
		this.quantity = quantity;
		this.status = status;
	}
	
	
	public int getId() {
		return id;
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
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
}
