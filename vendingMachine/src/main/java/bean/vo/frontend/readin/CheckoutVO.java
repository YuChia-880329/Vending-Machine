package bean.vo.frontend.readin;

public class CheckoutVO {

	private CheckoutFormVO checkoutForm;
	
	
	public CheckoutVO() {
	}
	public CheckoutVO(CheckoutFormVO checkoutForm) {

		this.checkoutForm = checkoutForm;
	}
	
	
	public CheckoutFormVO getCheckoutForm() {
		return checkoutForm;
	}
	
	
	public void setCheckoutForm(CheckoutFormVO checkoutForm) {
		this.checkoutForm = checkoutForm;
	}
}
