package bean.dto.frontend;

public class ClearShoppingCartResultDTO {

	private String redirectUrl;

	
	public ClearShoppingCartResultDTO() {
	}
	public ClearShoppingCartResultDTO(String redirectUrl) {

		this.redirectUrl = redirectUrl;
	}
	
	
	public String getRedirectUrl() {
		return redirectUrl;
	}
	
	
	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}
}
