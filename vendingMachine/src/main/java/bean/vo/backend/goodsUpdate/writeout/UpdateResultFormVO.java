package bean.vo.backend.goodsUpdate.writeout;

public class UpdateResultFormVO {

	private String quantity;

	public UpdateResultFormVO() {
	}
	public UpdateResultFormVO(String quantity) {

		this.quantity = quantity;
	}
	
	
	public String getQuantity() {
		return quantity;
	}
	
	
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
}
