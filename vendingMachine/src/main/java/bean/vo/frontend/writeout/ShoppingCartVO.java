package bean.vo.frontend.writeout;

public class ShoppingCartVO {

	private String goodsCount;
	private ShoppingCartGoodsVO[] shoppingCartGoodsArray;

	public ShoppingCartVO() {
	}
	public ShoppingCartVO(String goodsCount, ShoppingCartGoodsVO[] shoppingCartGoodsArray) {

		this.goodsCount = goodsCount;
		this.shoppingCartGoodsArray = shoppingCartGoodsArray;
	}
	
	
	
	public String getGoodsCount() {
		return goodsCount;
	}
	public ShoppingCartGoodsVO[] getShoppingCartGoodsArray() {
		return shoppingCartGoodsArray;
	}
	
	
	public void setGoodsCount(String goodsCount) {
		this.goodsCount = goodsCount;
	}
	public void setShoppingCartGoodsArray(ShoppingCartGoodsVO[] shoppingCartGoodsArray) {
		this.shoppingCartGoodsArray = shoppingCartGoodsArray;
	}
}
