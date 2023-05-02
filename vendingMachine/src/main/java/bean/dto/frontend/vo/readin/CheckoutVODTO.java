package bean.dto.frontend.vo.readin;

public class CheckoutVODTO {

	private String queryString;
	private CheckoutFormVODTO checkoutForm;
	
	
	
	public CheckoutVODTO() {
	}
	public CheckoutVODTO(String queryString, CheckoutFormVODTO checkoutForm) {

		this.queryString = queryString;
		this.checkoutForm = checkoutForm;
	}
	
	
	public String getQueryString() {
		return queryString;
	}
	public CheckoutFormVODTO getCheckoutForm() {
		return checkoutForm;
	}
	
	

	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}
	public void setCheckoutForm(CheckoutFormVODTO checkoutForm) {
		this.checkoutForm = checkoutForm;
	}
}
