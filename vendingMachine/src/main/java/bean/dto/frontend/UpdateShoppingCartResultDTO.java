package bean.dto.frontend;

public class UpdateShoppingCartResultDTO {

	private String redirectUrl;

	
	public UpdateShoppingCartResultDTO() {
	}
	public UpdateShoppingCartResultDTO(String redirectUrl) {

		this.redirectUrl = redirectUrl;
	}
	
	
	public String getRedirectUrl() {
		return redirectUrl;
	}
	
	
	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}
}
