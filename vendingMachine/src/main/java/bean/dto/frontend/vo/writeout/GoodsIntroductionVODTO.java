package bean.dto.frontend.vo.writeout;

public class GoodsIntroductionVODTO {

	private String name;
	private String imagePath;
	private String description;
	private int price;
	private int quantity;
	private int buyQuantity;
	
	
	public GoodsIntroductionVODTO() {
	}
	public GoodsIntroductionVODTO(String name, String imagePath, String description, int price, int quantity,
			int buyQuantity) {

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
	public int getPrice() {
		return price;
	}
	public int getQuantity() {
		return quantity;
	}
	public int getBuyQuantity() {
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
	public void setPrice(int price) {
		this.price = price;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public void setBuyQuantity(int buyQuantity) {
		this.buyQuantity = buyQuantity;
	}
}
