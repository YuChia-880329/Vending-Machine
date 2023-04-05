package bean.vo.frontend.writeout;

public class FRBoughtGoodsWOVO {

	private String name;
	private String price;
	private String quantity;
	
	
	public FRBoughtGoodsWOVO() {
	}
	public FRBoughtGoodsWOVO(String name, String price, String quantity) {
		
		this.name = name;
		this.price = price;
		this.quantity = quantity;
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
	
	
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
}
