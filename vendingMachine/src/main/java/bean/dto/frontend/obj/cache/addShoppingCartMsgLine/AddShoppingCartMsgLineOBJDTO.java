package bean.dto.frontend.obj.cache.addShoppingCartMsgLine;

public class AddShoppingCartMsgLineOBJDTO {

	private String name;
	private int addQuantity;

	public AddShoppingCartMsgLineOBJDTO() {
	}
	public AddShoppingCartMsgLineOBJDTO(String name, int addQuantity) {

		this.name = name;
		this.addQuantity = addQuantity;
	}
	
	
	public String getName() {
		return name;
	}
	public int getAddQuantity() {
		return addQuantity;
	}

	
	
	public void setName(String name) {
		this.name = name;
	}
	public void setAddQuantity(int addQuantity) {
		this.addQuantity = addQuantity;
	}
}
