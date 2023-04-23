package bean.vo.frontend.writeout;

public class ShoppingCartVO {

	private ShoppingCartGoodsVO[] shoppingCartGoodsArray;

	public ShoppingCartVO() {
	}
	public ShoppingCartVO(ShoppingCartGoodsVO[] shoppingCartGoodsArray) {

		this.shoppingCartGoodsArray = shoppingCartGoodsArray;
	}
	
	
	public ShoppingCartGoodsVO[] getShoppingCartGoodsArray() {
		return shoppingCartGoodsArray;
	}
	
	
	public void setShoppingCartGoodsArray(ShoppingCartGoodsVO[] shoppingCartGoodsArray) {
		this.shoppingCartGoodsArray = shoppingCartGoodsArray;
	}
}
