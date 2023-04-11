package bean.model;

public class GoodsModel {

	private int id;
	private String name;
	private String description;
	private int price;
	private int quantity;
	private String imageName;
	private String status;
	
	
	public GoodsModel() {
	}
	public GoodsModel(int id, String name, String description, int price, int quantity, String imageName, String status) {
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
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
