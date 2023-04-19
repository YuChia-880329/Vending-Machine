package bean.vo.frontend.writeout;

public class GoodsCardVO {

	private String name;
	private String price;
	private String imagePath;
	private String buyQuantity;
	private String quantity;
	
	
	public GoodsCardVO() {
	}
	public GoodsCardVO(String name, String price, String imagePath, String buyQuantity, String quantity) {

		this.name = name;
		this.price = price;
		this.imagePath = imagePath;
		this.buyQuantity = buyQuantity;
		this.quantity = quantity;
	}
	
	
	public String getName() {
		return name;
	}
	public String getPrice() {
		return price;
	}
	public String getImagePath() {
		return imagePath;
	}
	public String getBuyQuantity() {
		return buyQuantity;
	}
	public String getQuantity() {
		return quantity;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public void setBuyQuantity(String buyQuantity) {
		this.buyQuantity = buyQuantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
}
