package bean.vo.frontend.readin;

public class FCheckoutRIVO {

	private String paidMoney;

	public FCheckoutRIVO() {
	}
	public FCheckoutRIVO(String paidMoney) {

		this.paidMoney = paidMoney;
	}
	
	
	public String getPaidMoney() {
		return paidMoney;
	}
	
	
	public void setPaidMoney(String paidMoney) {
		this.paidMoney = paidMoney;
	}
}
