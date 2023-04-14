package bean.dto.backend.goodsUpdate.vo.readin;

import enumeration.Status;

public class BGUGoodsFormRIVODTO {

	private int id;
	private int price;
	private int addQuantity;
	private Status status;
	
	
	public BGUGoodsFormRIVODTO() {
	}
	public BGUGoodsFormRIVODTO(int id, int price, int addQuantity, Status status) {

		this.id = id;
		this.price = price;
		this.addQuantity = addQuantity;
		this.status = status;
	}
	
	
	public int getId() {
		return id;
	}
	public int getPrice() {
		return price;
	}
	public int getAddQuantity() {
		return addQuantity;
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
	public void setAddQuantity(int addQuantity) {
		this.addQuantity = addQuantity;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
}
