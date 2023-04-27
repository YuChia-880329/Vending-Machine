package bean.dto.frontend.vo.writeout;

public class UpdateShoppingCartIllegalMsgLineVODTO {

	private String name;

	public UpdateShoppingCartIllegalMsgLineVODTO() {
	}
	public UpdateShoppingCartIllegalMsgLineVODTO(String name) {

		this.name = name;
	}
	
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
