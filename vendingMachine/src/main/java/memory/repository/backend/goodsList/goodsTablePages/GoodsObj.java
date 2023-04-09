package memory.repository.backend.goodsList.goodsTablePages;

import enumeration.Status;

class GoodsObj {

	private int id;
	private String name;
	private String description;
	private int price;
	private int quantity;
	private String imageName;
	private Status status;
	
	GoodsObj() {
	}
	GoodsObj(int id, String name, String description, int price, int quantity, String imageName, Status status) {

		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
		this.imageName = imageName;
		this.status = status;
	}
	
	
	int getId() {
		return id;
	}
	String getName() {
		return name;
	}
	String getDescription() {
		return description;
	}
	int getPrice() {
		return price;
	}
	int getQuantity() {
		return quantity;
	}
	String getImageName() {
		return imageName;
	}
	Status getStatus() {
		return status;
	}
	
	
	void setId(int id) {
		this.id = id;
	}
	void setName(String name) {
		this.name = name;
	}
	void setDescription(String description) {
		this.description = description;
	}
	void setPrice(int price) {
		this.price = price;
	}
	void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	void setImageName(String imageName) {
		this.imageName = imageName;
	}
	void setStatus(Status status) {
		this.status = status;
	}
}
