package bean.dto.frontend.vo.writeout;

public class GoodsCardVODTO {

	private String name;
	private int price;
	private String imagePath;
	private int buyQuantity;
	private int quantity;
	
	
	public GoodsCardVODTO() {
	}
	public GoodsCardVODTO(String name, int price, String imagePath, int buyQuantity, int quantity) {

		this.name = name;
		this.price = price;
		this.imagePath = imagePath;
		this.buyQuantity = buyQuantity;
		this.quantity = quantity;
	}
	
	
	public String getName() {
		return name;
	}
	public int getPrice() {
		return price;
	}
	public String getImagePath() {
		return imagePath;
	}
	public int getBuyQuantity() {
		return buyQuantity;
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
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public void setBuyQuantity(int buyQuantity) {
		this.buyQuantity = buyQuantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
