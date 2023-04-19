package bean.vo.frontend.readin;

public class CheckoutVO {

	private String paidMoney;

	public CheckoutVO() {
	}
	public CheckoutVO(String paidMoney) {

		this.paidMoney = paidMoney;
	}
	
	
	public String getPaidMoney() {
		return paidMoney;
	}
	
	
	public void setPaidMoney(String paidMoney) {
		this.paidMoney = paidMoney;
	}
}
