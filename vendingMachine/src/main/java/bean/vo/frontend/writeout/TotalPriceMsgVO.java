package bean.vo.frontend.writeout;

public class TotalPriceMsgVO {

	private String totalPrice;

	public TotalPriceMsgVO() {
	}
	public TotalPriceMsgVO(String totalPrice) {

		this.totalPrice = totalPrice;
	}
	
	
	public String getTotalPrice() {
		return totalPrice;
	}
	
	
	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}
}
