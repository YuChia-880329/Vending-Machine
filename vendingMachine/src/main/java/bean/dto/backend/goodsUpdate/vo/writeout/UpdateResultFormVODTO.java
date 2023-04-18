package bean.dto.backend.goodsUpdate.vo.writeout;

public class UpdateResultFormVODTO {

	private int quantity;

	public UpdateResultFormVODTO() {
	}
	public UpdateResultFormVODTO(int quantity) {

		this.quantity = quantity;
	}
	
	
	public int getQuantity() {
		return quantity;
	}
	
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
