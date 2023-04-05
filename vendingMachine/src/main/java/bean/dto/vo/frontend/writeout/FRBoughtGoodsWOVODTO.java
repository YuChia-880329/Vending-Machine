package bean.dto.vo.frontend.writeout;

public class FRBoughtGoodsWOVODTO {

	private String name;
	private int price;
	private int quantity;
	
	
	public FRBoughtGoodsWOVODTO() {
	}
	public FRBoughtGoodsWOVODTO(String name, int price, int quantity) {

		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	
	
	public String getName() {
		return name;
	}
	public int getPrice() {
		return price;
	}
	public int getQuantity() {
		return quantity;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
