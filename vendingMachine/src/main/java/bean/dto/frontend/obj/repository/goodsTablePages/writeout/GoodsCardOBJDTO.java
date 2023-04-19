package bean.dto.frontend.obj.repository.goodsTablePages.writeout;

public class GoodsCardOBJDTO {

	private String name;
	private int price;
	private String imageName;
	private int quantity;
	
	
	public GoodsCardOBJDTO() {
	}
	public GoodsCardOBJDTO(String name, int price, String imageName, int quantity) {

		this.name = name;
		this.price = price;
		this.imageName = imageName;
		this.quantity = quantity;
	}
	
	
	public String getName() {
		return name;
	}
	public int getPrice() {
		return price;
	}
	public String getImageName() {
		return imageName;
	}
	public int getQuantity() {
		return quantity;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
