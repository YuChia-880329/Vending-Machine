package bean.vo.frontend.writeout;

public class PaidMoneyMsgVO {

	private String paidMoney;

	public PaidMoneyMsgVO() {
	}
	public PaidMoneyMsgVO(String paidMoney) {

		this.paidMoney = paidMoney;
	}
	
	
	public String getPaidMoney() {
		return paidMoney;
	}
	
	
	public void setPaidMoney(String paidMoney) {
		this.paidMoney = paidMoney;
	}
}
