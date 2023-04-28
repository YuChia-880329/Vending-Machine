package bean.dto.frontend.vo.writeout;

public class PaidMoneyMsgVODTO {

	private int paidMoney;

	public PaidMoneyMsgVODTO() {
	}
	public PaidMoneyMsgVODTO(int paidMoney) {

		this.paidMoney = paidMoney;
	}
	
	
	public int getPaidMoney() {
		return paidMoney;
	}
	
	
	public void setPaidMoney(int paidMoney) {
		this.paidMoney = paidMoney;
	}
}
