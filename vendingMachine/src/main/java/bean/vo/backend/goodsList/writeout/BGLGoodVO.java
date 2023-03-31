package bean.vo.backend.goodsList.writeout;

public class BGLGoodVO {

	private String id;
	private String name;
	private String price;
	private String quantity;
	private String status;
	
	
	public BGLGoodVO() {
	}
	public BGLGoodVO(String id, String name, String price, String quantity, String status) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.status = status;
	}
	
	
	String getId() {
		return id;
	}
	String getName() {
		return name;
	}
	String getPrice() {
		return price;
	}
	String getQuantity() {
		return quantity;
	}
	String getStatus() {
		return status;
	}
	
	
	void setId(String id) {
		this.id = id;
	}
	void setName(String name) {
		this.name = name;
	}
	void setPrice(String price) {
		this.price = price;
	}
	void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	void setStatus(String status) {
		this.status = status;
	}
}
