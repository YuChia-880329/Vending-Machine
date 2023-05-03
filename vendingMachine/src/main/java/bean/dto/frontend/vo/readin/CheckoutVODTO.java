package bean.dto.frontend.vo.readin;

public class CheckoutVODTO {

	private String currentUrl;
	private CheckoutFormVODTO checkoutForm;
	
	
	
	public CheckoutVODTO() {
	}
	public CheckoutVODTO(String currentUrl, CheckoutFormVODTO checkoutForm) {

		this.currentUrl = currentUrl;
		this.checkoutForm = checkoutForm;
	}
	
	
	public String getCurrentUrl() {
		return currentUrl;
	}
	public CheckoutFormVODTO getCheckoutForm() {
		return checkoutForm;
	}
	
	

	public void setCurrentUrl(String currentUrl) {
		this.currentUrl = currentUrl;
	}
	public void setCheckoutForm(CheckoutFormVODTO checkoutForm) {
		this.checkoutForm = checkoutForm;
	}
}
