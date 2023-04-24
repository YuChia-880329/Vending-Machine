package bean.vo.frontend.readin;

public class AddShoppingCartGoodsVO {

	private String id;
	private String name;
	private String buyQuantity;
	private String quantity;
	
	
	public AddShoppingCartGoodsVO() {
	}
	public AddShoppingCartGoodsVO(String id, String name, String buyQuantity, String quantity) {

		this.id = id;
		this.name = name;
		this.buyQuantity = buyQuantity;
		this.quantity = quantity;
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
	public String getQuantity() {
		return quantity;
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
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
}
