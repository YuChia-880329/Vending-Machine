package bean.vo.backend.goodsUpdate.readin;

public class GoodsUpdateFormVO {

	private String id;
	private String price;
	private String addQuantity;
	private String status;
	
	
	public GoodsUpdateFormVO() {
	}
	public GoodsUpdateFormVO(String id, String price, String addQuantity, String status) {

		this.id = id;
		this.price = price;
		this.addQuantity = addQuantity;
		this.status = status;
	}
	
	
	public String getId() {
		return id;
	}
	public String getPrice() {
		return price;
	}
	public String getAddQuantity() {
		return addQuantity;
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
	public void setAddQuantity(String addQuantity) {
		this.addQuantity = addQuantity;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
