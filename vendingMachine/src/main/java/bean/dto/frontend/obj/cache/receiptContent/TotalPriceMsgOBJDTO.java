package bean.dto.frontend.obj.cache.receiptContent;

public class TotalPriceMsgOBJDTO {

	private int totalPrice;

	public TotalPriceMsgOBJDTO() {
	}
	public TotalPriceMsgOBJDTO(int totalPrice) {

		this.totalPrice = totalPrice;
	}
	
	
	public int getTotalPrice() {
		return totalPrice;
	}
	
	
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
}
