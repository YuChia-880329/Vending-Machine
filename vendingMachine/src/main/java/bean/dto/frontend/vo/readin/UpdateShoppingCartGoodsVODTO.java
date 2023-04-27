package bean.dto.frontend.vo.readin;

public class UpdateShoppingCartGoodsVODTO {

	private int id;
	private String name;
	private int buyQuantity;
	private int quantity;
	
	
	public UpdateShoppingCartGoodsVODTO() {
	}
	public UpdateShoppingCartGoodsVODTO(int id, String name, int buyQuantity, int quantity) {

		this.id = id;
		this.name = name;
		this.buyQuantity = buyQuantity;
		this.quantity = quantity;
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
	public int getQuantity() {
		return quantity;
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
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
