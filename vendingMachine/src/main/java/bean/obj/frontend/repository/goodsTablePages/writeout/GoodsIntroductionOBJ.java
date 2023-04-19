package bean.obj.frontend.repository.goodsTablePages.writeout;

public class GoodsIntroductionOBJ {

	private String name;
	private String imageName;
	private String description;
	private int price;
	private int quantity;
	
	
	public GoodsIntroductionOBJ() {
	}
	public GoodsIntroductionOBJ(String name, String imageName, String description, int price, int quantity) {

		this.name = name;
		this.imageName = imageName;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
	}
	
	
	public String getName() {
		return name;
	}
	public String getImageName() {
		return imageName;
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
	
	
	public void setName(String name) {
		this.name = name;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
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
}
