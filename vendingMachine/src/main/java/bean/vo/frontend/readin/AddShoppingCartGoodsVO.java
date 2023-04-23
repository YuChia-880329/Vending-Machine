package bean.vo.frontend.readin;

public class AddShoppingCartGoodsVO {

	private String id;
	private String buyQuantity;
	
	
	public AddShoppingCartGoodsVO() {
	}
	public AddShoppingCartGoodsVO(String id, String buyQuantity) {

		this.id = id;
		this.buyQuantity = buyQuantity;
	}
	
	
	public String getId() {
		return id;
	}
	public String getBuyQuantity() {
		return buyQuantity;
	}
	
	
	public void setId(String id) {
		this.id = id;
	}
	public void setBuyQuantity(String buyQuantity) {
		this.buyQuantity = buyQuantity;
	}
}
