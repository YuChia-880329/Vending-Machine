package bean.obj.frontend.memoryDb.shoppingCart;

public class ShoppingCartOBJ {

	private int buyQuantity;

	public ShoppingCartOBJ() {
	}
	public ShoppingCartOBJ(int buyQuantity) {

		this.buyQuantity = buyQuantity;
	}
	
	
	public int getBuyQuantity() {
		return buyQuantity;
	}
	
	public void setBuyQuantity(int buyQuantity) {
		this.buyQuantity = buyQuantity;
	}
}
