package bean.dto.frontend.vo.readin;

public class CheckoutVODTO {

	private int paidMoney;

	public CheckoutVODTO() {
	}
	public CheckoutVODTO(int paidMoney) {

		this.paidMoney = paidMoney;
	}
	
	
	public int getPaidMoney() {
		return paidMoney;
	}
	
	public void setPaidMoney(int paidMoney) {
		this.paidMoney = paidMoney;
	}
}
