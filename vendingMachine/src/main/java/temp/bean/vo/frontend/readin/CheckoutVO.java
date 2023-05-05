package temp.bean.vo.frontend.readin;

import bean.vo.frontend.readin.CheckoutFormVO;

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
