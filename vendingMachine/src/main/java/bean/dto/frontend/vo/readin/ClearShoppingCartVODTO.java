package bean.dto.frontend.vo.readin;

public class ClearShoppingCartVODTO {

	private String currentUrl;

	public ClearShoppingCartVODTO() {
	}
	public ClearShoppingCartVODTO(String currentUrl) {

		this.currentUrl = currentUrl;
	}
	
	
	public String getCurrentUrl() {
		return currentUrl;
	}
	
	
	public void setCurrentUrl(String currentUrl) {
		this.currentUrl = currentUrl;
	}
}
