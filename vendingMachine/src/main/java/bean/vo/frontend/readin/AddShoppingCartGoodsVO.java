package bean.vo.frontend.readin;

public class AddShoppingCartGoodsVO {

	private String id;
	private String name;
	private String addQuantity;
	private String quantity;
	
	
	public AddShoppingCartGoodsVO() {
	}
	public AddShoppingCartGoodsVO(String id, String name, String addQuantity, String quantity) {

		this.id = id;
		this.name = name;
		this.addQuantity = addQuantity;
		this.quantity = quantity;
	}
	
	
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getAddQuantity() {
		return addQuantity;
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
	public void setAddQuantity(String addQuantity) {
		this.addQuantity = addQuantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
}
