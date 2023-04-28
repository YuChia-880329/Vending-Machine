package bean.vo.frontend.readin;

public class CheckoutVO {

	private String queryString;
	private CheckoutFormVO checkoutForm;
	private AddShoppingCartGoodsVO[] addShoppingCartGoodsArray;
	
	
	public CheckoutVO() {
	}
	public CheckoutVO(String queryString, CheckoutFormVO checkoutForm, AddShoppingCartGoodsVO[] addShoppingCartGoodsArray) {

		this.queryString = queryString;
		this.checkoutForm = checkoutForm;
		this.addShoppingCartGoodsArray = addShoppingCartGoodsArray;
	}
	
	
	public String getQueryString() {
		return queryString;
	}
	public CheckoutFormVO getCheckoutForm() {
		return checkoutForm;
	}
	public AddShoppingCartGoodsVO[] getAddShoppingCartGoodsArray() {
		return addShoppingCartGoodsArray;
	}
	
	

	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}
	public void setCheckoutForm(CheckoutFormVO checkoutForm) {
		this.checkoutForm = checkoutForm;
	}
	public void setAddShoppingCartGoodsArray(AddShoppingCartGoodsVO[] addShoppingCartGoodsArray) {
		this.addShoppingCartGoodsArray = addShoppingCartGoodsArray;
	}
}
