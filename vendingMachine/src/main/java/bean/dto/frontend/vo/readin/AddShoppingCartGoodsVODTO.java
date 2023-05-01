package bean.dto.frontend.vo.readin;

public class AddShoppingCartGoodsVODTO {

	private int id;
	private String name;
	private int addQuantity;
	private int quantity;
	
	
	public AddShoppingCartGoodsVODTO() {
	}
	public AddShoppingCartGoodsVODTO(int id, String name, int addQuantity, int quantity) {

		this.id = id;
		this.name = name;
		this.addQuantity = addQuantity;
		this.quantity = quantity;
	}
	
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getAddQuantity() {
		return addQuantity;
	}
	public int getQuantity() {
		return quantity;
	}

	
	
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAddQuantity(int addQuantity) {
		this.addQuantity = addQuantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
