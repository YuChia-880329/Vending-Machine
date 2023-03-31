package bean.model;

public class GoodModel {

	private int id;
	private String name;
	private String description;
	private int price;
	private int quantity;
	private String image;
	private String status;
	
	
	public GoodModel() {
	}
	public GoodModel(int id, String name, String description, int price, int quantity, String image, String status) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
		this.image = image;
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
	public String getImage() {
		return image;
	}
	public String getStatus() {
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
	public void setImage(String image) {
		this.image = image;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
