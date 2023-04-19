package bean.vo.frontend.readin;

public class ShoppingCartGoodsVO {

	private String id;
	private String quantity;
	
	
	public ShoppingCartGoodsVO() {
	}
	public ShoppingCartGoodsVO(String id, String quantity) {

		this.id = id;
		this.quantity = quantity;
	}
	
	
	public String getId() {
		return id;
	}
	public String getQuantity() {
		return quantity;
	}
	
	
	public void setId(String id) {
		this.id = id;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
}
