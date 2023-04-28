package bean.dto.frontend.obj.cache.receiptContent;

public class PaidMoneyMsgOBJDTO {

	private int paidMoney;

	public PaidMoneyMsgOBJDTO() {
	}
	public PaidMoneyMsgOBJDTO(int paidMoney) {

		this.paidMoney = paidMoney;
	}
	
	
	public int getPaidMoney() {
		return paidMoney;
	}
	
	
	public void setPaidMoney(int paidMoney) {
		this.paidMoney = paidMoney;
	}
}
