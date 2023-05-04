package bean.vo.frontend.writeout;

public class AddShoppingCartLegalMsgLineVO {

	private String name;
	private String addQuantity;
	
	
	public AddShoppingCartLegalMsgLineVO() {
	}
	public AddShoppingCartLegalMsgLineVO(String name, String addQuantity) {

		this.name = name;
		this.addQuantity = addQuantity;
	}
	
	
	public String getName() {
		return name;
	}
	public String getAddQuantity() {
		return addQuantity;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	public void setAddQuantity(String addQuantity) {
		this.addQuantity = addQuantity;
	}
}
