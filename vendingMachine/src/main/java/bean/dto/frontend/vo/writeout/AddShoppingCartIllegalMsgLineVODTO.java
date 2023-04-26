package bean.dto.frontend.vo.writeout;

public class AddShoppingCartIllegalMsgLineVODTO {

	private String name;

	public AddShoppingCartIllegalMsgLineVODTO() {
	}
	public AddShoppingCartIllegalMsgLineVODTO(String name) {

		this.name = name;
	}
	
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
