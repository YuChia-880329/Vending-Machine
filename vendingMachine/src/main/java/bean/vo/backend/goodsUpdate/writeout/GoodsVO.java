package bean.vo.backend.goodsUpdate.writeout;

public class GoodsVO {

	private String id;
	private String quantity;
	private String status;
	
	
	public GoodsVO() {
	}
	public GoodsVO(String id, String quantity, String status) {

		this.id = id;
		this.quantity = quantity;
		this.status = status;
	}
	
	
	public String getId() {
		return id;
	}
	public String getQuantity() {
		return quantity;
	}
	public String getStatus() {
		return status;
	}
	
	
	public void setId(String id) {
		this.id = id;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
