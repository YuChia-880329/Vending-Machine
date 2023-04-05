package bean.vo.frontend.readin;

public class FSCGoodsRIVO {

	private String id;
	private String quantity;
	
	
	public FSCGoodsRIVO() {
	}
	public FSCGoodsRIVO(String id, String quantity) {

		this.id = id;
		this.quantity = quantity;
	}
	
	
	public String getId() {
		return id;
	}
	public String getQuantity() {
		return quantity;
	}
	
	
	public void setId(String id) {
		this.id = id;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
}
