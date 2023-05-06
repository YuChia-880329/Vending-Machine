package bean.dto.frontend.vo.readin;

public class CheckoutVODTO {

	private CheckoutFormVODTO checkoutForm;
	
	
	
	public CheckoutVODTO() {
	}
	public CheckoutVODTO(CheckoutFormVODTO checkoutForm) {

		this.checkoutForm = checkoutForm;
	}
	
	
	public CheckoutFormVODTO getCheckoutForm() {
		return checkoutForm;
	}
	
	
	public void setCheckoutForm(CheckoutFormVODTO checkoutForm) {
		this.checkoutForm = checkoutForm;
	}
}
