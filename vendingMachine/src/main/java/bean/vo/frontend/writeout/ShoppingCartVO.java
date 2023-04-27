package bean.vo.frontend.writeout;

public class ShoppingCartVO {

	private String goodsCount;
	private ShoppingCartGoodsVO[] shoppingCartGoodsArray;
	private String totalPrice;

	public ShoppingCartVO() {
	}
	public ShoppingCartVO(String goodsCount, ShoppingCartGoodsVO[] shoppingCartGoodsArray, String totalPrice) {

		this.goodsCount = goodsCount;
		this.shoppingCartGoodsArray = shoppingCartGoodsArray;
		this.totalPrice = totalPrice;
	}
	
	
	
	public String getGoodsCount() {
		return goodsCount;
	}
	public ShoppingCartGoodsVO[] getShoppingCartGoodsArray() {
		return shoppingCartGoodsArray;
	}
	public String getTotalPrice() {
		return totalPrice;
	}

	
	
	public void setGoodsCount(String goodsCount) {
		this.goodsCount = goodsCount;
	}
	public void setShoppingCartGoodsArray(ShoppingCartGoodsVO[] shoppingCartGoodsArray) {
		this.shoppingCartGoodsArray = shoppingCartGoodsArray;
	}
	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}
}
