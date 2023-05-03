package bean.vo.frontend.readin;

public class CheckoutVO {

	private String currentUrl;
	private CheckoutFormVO checkoutForm;
	
	
	public CheckoutVO() {
	}
	public CheckoutVO(String currentUrl, CheckoutFormVO checkoutForm) {

		this.currentUrl = currentUrl;
		this.checkoutForm = checkoutForm;
	}
	
	
	public String getCurrentUrl() {
		return currentUrl;
	}
	public CheckoutFormVO getCheckoutForm() {
		return checkoutForm;
	}
	
	

	public void setCurrentUrl(String currentUrl) {
		this.currentUrl = currentUrl;
	}
	public void setCheckoutForm(CheckoutFormVO checkoutForm) {
		this.checkoutForm = checkoutForm;
	}
}
