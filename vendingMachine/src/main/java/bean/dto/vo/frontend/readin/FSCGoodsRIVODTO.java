package bean.dto.vo.frontend.readin;

public class FSCGoodsRIVODTO {

	private int id;
	private int quantity;
	
	
	public FSCGoodsRIVODTO() {
	}
	public FSCGoodsRIVODTO(int id, int quantity) {

		this.id = id;
		this.quantity = quantity;
	}
	
	
	public int getId() {
		return id;
	}
	public int getQuantity() {
		return quantity;
	}
	
	
	public void setId(int id) {
		this.id = id;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
