package bean.dto.frontend.vo.writeout;

public class ShoppingCartGoodsVODTO {

	private String name;
	private int buyQuantity;
	private int price;
	
	
	public ShoppingCartGoodsVODTO() {
	}
	public ShoppingCartGoodsVODTO(String name, int buyQuantity, int price) {

		this.name = name;
		this.buyQuantity = buyQuantity;
		this.price = price;
	}



	public String getName() {
		return name;
	}
	public int getBuyQuantity() {
		return buyQuantity;
	}
	public int getPrice() {
		return price;
	}

	
	public void setName(String name) {
		this.name = name;
	}
	public void setBuyQuantity(int buyQuantity) {
		this.buyQuantity = buyQuantity;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}
