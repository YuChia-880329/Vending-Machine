package bean.vo.frontend.readin;

public class ClearShoppingCartVO {

	private String currentUrl;

	public ClearShoppingCartVO() {
	}
	public ClearShoppingCartVO(String currentUrl) {

		this.currentUrl = currentUrl;
	}
	
	
	public String getCurrentUrl() {
		return currentUrl;
	}
	
	
	public void setCurrentUrl(String currentUrl) {
		this.currentUrl = currentUrl;
	}
}
