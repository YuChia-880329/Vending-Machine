package bean.vo.frontend.writeout;

public class ShoppingCartGoodsVO {

	private String id;
	private String name;
	private String buyQuantity;
	private String price;
	
	
	public ShoppingCartGoodsVO() {
	}
	public ShoppingCartGoodsVO(String id, String name, String buyQuantity, String price) {

		this.id = id;
		this.name = name;
		this.buyQuantity = buyQuantity;
		this.price = price;
	}



	
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getBuyQuantity() {
		return buyQuantity;
	}
	public String getPrice() {
		return price;
	}

	
	public void setId(String id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setBuyQuantity(String buyQuantity) {
		this.buyQuantity = buyQuantity;
	}
	public void setPrice(String price) {
		this.price = price;
	}
}
