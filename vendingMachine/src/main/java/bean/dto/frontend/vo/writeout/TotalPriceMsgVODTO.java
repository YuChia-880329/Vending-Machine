package bean.dto.frontend.vo.writeout;

public class TotalPriceMsgVODTO {

	private int totalPrice;

	public TotalPriceMsgVODTO() {
	}
	public TotalPriceMsgVODTO(int totalPrice) {

		this.totalPrice = totalPrice;
	}
	
	
	public int getTotalPrice() {
		return totalPrice;
	}
	
	
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
}
