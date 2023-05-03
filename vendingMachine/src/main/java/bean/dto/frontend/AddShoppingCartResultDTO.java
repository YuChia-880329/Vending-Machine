package bean.dto.frontend;

public class AddShoppingCartResultDTO {
	
	private String redirectUrl;

	public AddShoppingCartResultDTO() {
	}
	public AddShoppingCartResultDTO(String redirectUrl) {

		this.redirectUrl = redirectUrl;
	}
	
	
	public String getRedirectUrl() {
		return redirectUrl;
	}
	
	
	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}
}
