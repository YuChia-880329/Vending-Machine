package bean.dto.frontend.vo.readin;

public class CheckoutFormVODTO {

	private int paidMoney;

	public CheckoutFormVODTO() {
	}
	public CheckoutFormVODTO(int paidMoney) {

		this.paidMoney = paidMoney;
	}
	
	
	public int getPaidMoney() {
		return paidMoney;
	}
	
	public void setPaidMoney(int paidMoney) {
		this.paidMoney = paidMoney;
	}
}
