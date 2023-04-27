package bean.vo.frontend.writeout;

public class ShoppingCartGoodsVO {

	private String id;
	private String pageId;
	private String name;
	private String buyQuantity;
	private String quantity;
	private String price;
	
	
	public ShoppingCartGoodsVO() {
	}
	public ShoppingCartGoodsVO(String id, String pageId, String name, String buyQuantity, 
			String quantity, String price) {

		this.id = id;
		this.pageId = pageId;
		this.name = name;
		this.buyQuantity = buyQuantity;
		this.quantity = quantity;
		this.price = price;
	}



	
	public String getId() {
		return id;
	}
	public String getPageId() {
		return pageId;
	}
	public String getName() {
		return name;
	}
	public String getBuyQuantity() {
		return buyQuantity;
	}
	public String getQuantity() {
		return quantity;
	}
	public String getPrice() {
		return price;
	}

	
	public void setId(String id) {
		this.id = id;
	}
	public void setPageId(String pageId) {
		this.pageId = pageId;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setBuyQuantity(String buyQuantity) {
		this.buyQuantity = buyQuantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public void setPrice(String price) {
		this.price = price;
	}
}
