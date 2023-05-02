package bean.vo.frontend.readin;

public class CheckoutVO {

	private String queryString;
	private CheckoutFormVO checkoutForm;
	
	
	public CheckoutVO() {
	}
	public CheckoutVO(String queryString, CheckoutFormVO checkoutForm) {

		this.queryString = queryString;
		this.checkoutForm = checkoutForm;
	}
	
	
	public String getQueryString() {
		return queryString;
	}
	public CheckoutFormVO getCheckoutForm() {
		return checkoutForm;
	}
	
	

	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}
	public void setCheckoutForm(CheckoutFormVO checkoutForm) {
		this.checkoutForm = checkoutForm;
	}
}
