package bean.dto.frontend;

public class CheckoutResultDTO {

	private String redirectUrl;

	public CheckoutResultDTO() {
	}
	public CheckoutResultDTO(String redirectUrl) {

		this.redirectUrl = redirectUrl;
	}
	
	
	public String getRedirectUrl() {
		return redirectUrl;
	}
	
	
	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}
}
