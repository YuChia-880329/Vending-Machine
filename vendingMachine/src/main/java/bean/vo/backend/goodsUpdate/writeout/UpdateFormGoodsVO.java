package bean.vo.backend.goodsUpdate.writeout;

public class UpdateFormGoodsVO {

	private String id;
	private String price;
	private String quantity;
	private String status;
	
	
	public UpdateFormGoodsVO() {
	}
	public UpdateFormGoodsVO(String id, String price, String quantity, String status) {

		this.id = id;
		this.price = price;
		this.quantity = quantity;
		this.status = status;
	}
	
	
	public String getId() {
		return id;
	}
	public String getPrice() {
		return price;
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
	public void setPrice(String price) {
		this.price = price;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
