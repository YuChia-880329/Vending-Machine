package bean.vo.backend.goodsList.writeout;

public class BGLGTGoodsWOVO {

	private String id;
	private String name;
	private String price;
	private String quantity;
	private String status;
	
	
	public BGLGTGoodsWOVO() {
	}
	public BGLGTGoodsWOVO(String id, String name, String price, String quantity, String status) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.status = status;
	}
	
	
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
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
	public void setName(String name) {
		this.name = name;
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
