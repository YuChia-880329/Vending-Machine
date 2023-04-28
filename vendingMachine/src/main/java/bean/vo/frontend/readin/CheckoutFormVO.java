package bean.vo.frontend.readin;

public class CheckoutFormVO {

	private String paidMoney;

	public CheckoutFormVO() {
	}
	public CheckoutFormVO(String paidMoney) {

		this.paidMoney = paidMoney;
	}
	
	
	public String getPaidMoney() {
		return paidMoney;
	}
	
	
	public void setPaidMoney(String paidMoney) {
		this.paidMoney = paidMoney;
	}
}
