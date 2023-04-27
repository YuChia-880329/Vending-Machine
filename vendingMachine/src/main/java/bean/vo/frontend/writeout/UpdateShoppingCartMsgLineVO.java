package bean.vo.frontend.writeout;

public class UpdateShoppingCartMsgLineVO {

	private String name;
	private String buyQuantity;
	
	
	public UpdateShoppingCartMsgLineVO() {
	}
	public UpdateShoppingCartMsgLineVO(String name, String buyQuantity) {

		this.name = name;
		this.buyQuantity = buyQuantity;
	}
	
	
	public String getName() {
		return name;
	}
	public String getBuyQuantity() {
		return buyQuantity;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	public void setBuyQuantity(String buyQuantity) {
		this.buyQuantity = buyQuantity;
	}
}
