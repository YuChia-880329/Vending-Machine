package bean.dto.frontend.vo.writeout;

public class UpdateShoppingCartLegalMsgLineVODTO {

	private String name;
	private int buyQuantity;
	
	
	public UpdateShoppingCartLegalMsgLineVODTO() {
	}
	public UpdateShoppingCartLegalMsgLineVODTO(String name, int buyQuantity) {

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
