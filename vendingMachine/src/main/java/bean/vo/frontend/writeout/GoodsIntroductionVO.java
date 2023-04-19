package bean.vo.frontend.writeout;

public class GoodsIntroductionVO {

	private String name;
	private String imagePath;
	private String description;
	private String price;
	private String quantity;
	private String buyQuantity;
	
	
	public GoodsIntroductionVO() {
	}
	public GoodsIntroductionVO(String name, String imagePath, String description, String price, String quantity,
			String buyQuantity) {
		
		this.name = name;
		this.imagePath = imagePath;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
		this.buyQuantity = buyQuantity;
	}
	
	
	public String getName() {
		return name;
	}
	public String getImagePath() {
		return imagePath;
	}
	public String getDescription() {
		return description;
	}
	public String getPrice() {
		return price;
	}
	public String getQuantity() {
		return quantity;
	}
	public String getBuyQuantity() {
		return buyQuantity;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public void setBuyQuantity(String buyQuantity) {
		this.buyQuantity = buyQuantity;
	}
}
