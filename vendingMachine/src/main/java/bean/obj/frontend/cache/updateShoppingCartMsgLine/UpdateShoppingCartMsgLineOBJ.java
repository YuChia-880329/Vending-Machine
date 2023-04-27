package bean.obj.frontend.cache.updateShoppingCartMsgLine;

public class UpdateShoppingCartMsgLineOBJ {

	private String name;
	private int buyQuantity;

	public UpdateShoppingCartMsgLineOBJ() {
	}
	public UpdateShoppingCartMsgLineOBJ(String name, int buyQuantity) {

		this.name = name;
		this.buyQuantity = buyQuantity;
	}
	
	
	public String getName() {
		return name;
	}
	public int getBuyQuantity() {
		return buyQuantity;
	}

	
	
	public void setName(String name) {
		this.name = name;
	}
	public void setBuyQuantity(int buyQuantity) {
		this.buyQuantity = buyQuantity;
	}
}
