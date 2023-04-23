package bean.dto.frontend.vo.readin;

public class AddShoppingCartGoodsVODTO {

	private int id;
	private int buyQuantity;
	
	
	public AddShoppingCartGoodsVODTO() {
	}
	public AddShoppingCartGoodsVODTO(int id, int buyQuantity) {

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
