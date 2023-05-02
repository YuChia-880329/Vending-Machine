package bean.vo.frontend.readin;

public class CheckoutAddShoppingCartVO {

	private AddShoppingCartGoodsVO[] addShoppingCartGoodsArray;

	public CheckoutAddShoppingCartVO() {
	}
	public CheckoutAddShoppingCartVO(AddShoppingCartGoodsVO[] addShoppingCartGoodsArray) {

		this.addShoppingCartGoodsArray = addShoppingCartGoodsArray;
	}
	
	
	public AddShoppingCartGoodsVO[] getAddShoppingCartGoodsArray() {
		return addShoppingCartGoodsArray;
	}
	
	
	public void setAddShoppingCartGoodsArray(AddShoppingCartGoodsVO[] addShoppingCartGoodsArray) {
		this.addShoppingCartGoodsArray = addShoppingCartGoodsArray;
	}
}
