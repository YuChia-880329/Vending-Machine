package bean.obj.backend.goodsList.repository.goodsTablePages.writeout;

import enumeration.Status;

public class GoodsOBJ {

	private int id;
	private String name;
	private String description;
	private int price;
	private int quantity;
	private String imageName;
	private Status status;
	
	public GoodsOBJ() {
	}
	public GoodsOBJ(int id, String name, String description, int price, int quantity, String imageName, Status status) {

		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
		this.imageName = imageName;
		this.status = status;
	}
	
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	public int getPrice() {
		return price;
	}
	public int getQuantity() {
		return quantity;
	}
	public String getImageName() {
		return imageName;
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
	public void setDescription(String description) {
		this.description = description;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
}
