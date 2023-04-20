package bean.dto.frontend.obj.memoryDb.shoppingCart;

public class ShoppingCartOBJDTO {

	private int id;
	private int buyQuantity;
	
	
	public ShoppingCartOBJDTO() {
	}
	public ShoppingCartOBJDTO(int id, int buyQuantity) {

		this.id = id;
		this.buyQuantity = buyQuantity;
	}
	
	
	public int getId() {
		return id;
	}
	public int getBuyQuantity() {
		return buyQuantity;
	}
	
	
	public void setId(int id) {
		this.id = id;
	}
	public void setBuyQuantity(int buyQuantity) {
		this.buyQuantity = buyQuantity;
	}
}
