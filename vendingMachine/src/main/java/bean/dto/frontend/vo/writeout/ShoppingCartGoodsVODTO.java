package bean.dto.frontend.vo.writeout;

public class ShoppingCartGoodsVODTO {

	private int id;
	private String name;
	private int buyQuantity;
	private int price;
	
	
	public ShoppingCartGoodsVODTO() {
	}
	public ShoppingCartGoodsVODTO(int id, String name, int buyQuantity, int price) {

		this.id = id;
		this.name = name;
		this.buyQuantity = buyQuantity;
		this.price = price;
	}



	public int getId() {
		return id;
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

	
	public void setId(int id) {
		this.id = id;
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
