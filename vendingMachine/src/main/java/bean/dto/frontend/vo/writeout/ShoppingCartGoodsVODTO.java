package bean.dto.frontend.vo.writeout;

public class ShoppingCartGoodsVODTO {

	private int id;
	private int pageId;
	private String name;
	private int buyQuantity;
	private int quantity;
	private int price;
	
	
	public ShoppingCartGoodsVODTO() {
	}
	public ShoppingCartGoodsVODTO(int id, int pageId, String name, int buyQuantity, 
			int quantity, int price) {

		this.id = id;
		this.pageId = pageId;
		this.name = name;
		this.buyQuantity = buyQuantity;
		this.quantity = quantity;
		this.price = price;
	}



	public int getId() {
		return id;
	}
	public int getPageId() {
		return pageId;
	}
	public String getName() {
		return name;
	}
	public int getBuyQuantity() {
		return buyQuantity;
	}
	public int getQuantity() {
		return quantity;
	}
	public int getPrice() {
		return price;
	}

	
	public void setId(int id) {
		this.id = id;
	}
	public void setPageId(int pageId) {
		this.pageId = pageId;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setBuyQuantity(int buyQuantity) {
		this.buyQuantity = buyQuantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}
