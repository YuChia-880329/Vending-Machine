package bean.vo.frontend.readin;

public class UpdateShoppingCartVO {

	private String currentUrl;
	private UpdateShoppingCartGoodsVO[] updateShoppingCartGoodsArray;

	
	
	public UpdateShoppingCartVO() {
	}
	public UpdateShoppingCartVO(String currentUrl, UpdateShoppingCartGoodsVO[] updateShoppingCartGoodsArray) {

		this.currentUrl = currentUrl;
		this.updateShoppingCartGoodsArray = updateShoppingCartGoodsArray;
	}
	
	
	public String getCurrentUrl() {
		return currentUrl;
	}
	public UpdateShoppingCartGoodsVO[] getUpdateShoppingCartGoodsArray() {
		return updateShoppingCartGoodsArray;
	}

	
	
	public void setCurrentUrl(String currentUrl) {
		this.currentUrl = currentUrl;
	}
	public void setUpdateShoppingCartGoodsArray(UpdateShoppingCartGoodsVO[] updateShoppingCartGoodsArray) {
		this.updateShoppingCartGoodsArray = updateShoppingCartGoodsArray;
	}
}
