package bean.dto.vo.frontend.readin;

public class FCheckoutRIVODTO {

	private int paidMoney;

	public FCheckoutRIVODTO() {
	}
	public FCheckoutRIVODTO(int paidMoney) {

		this.paidMoney = paidMoney;
	}
	
	
	public int getPaidMoney() {
		return paidMoney;
	}
	
	public void setPaidMoney(int paidMoney) {
		this.paidMoney = paidMoney;
	}
}
