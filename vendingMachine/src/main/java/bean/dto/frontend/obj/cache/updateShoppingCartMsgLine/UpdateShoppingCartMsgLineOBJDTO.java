package bean.dto.frontend.obj.cache.updateShoppingCartMsgLine;

public class UpdateShoppingCartMsgLineOBJDTO {

	private String name;
	private int buyQuantity;

	public UpdateShoppingCartMsgLineOBJDTO() {
	}
	public UpdateShoppingCartMsgLineOBJDTO(String name, int buyQuantity) {

		this.name = name;
		this.buyQuantity = buyQuantity;
	}
	
	
	public String getName() {
		return name;
	}
	public int getBuyQuantity() {
		return buyQuantity;
	}

	
	
	public void setName(String name) {
		this.name = name;
	}
	public void setBuyQuantity(int buyQuantity) {
		this.buyQuantity = buyQuantity;
	}
}
