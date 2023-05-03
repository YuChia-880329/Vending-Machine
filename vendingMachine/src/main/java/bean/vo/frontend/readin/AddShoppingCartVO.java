package bean.vo.frontend.readin;

public class AddShoppingCartVO {

	private String currentUrl;
	private AddShoppingCartGoodsVO[] addShoppingCartGoodsArray;


	public AddShoppingCartVO() {
	}
	public AddShoppingCartVO(String currentUrl, AddShoppingCartGoodsVO[] addShoppingCartGoodsArray) {
		
		this.currentUrl = currentUrl;
		this.addShoppingCartGoodsArray = addShoppingCartGoodsArray;
	}
	
	
	public String getCurrentUrl() {
		return currentUrl;
	}
	public AddShoppingCartGoodsVO[] getAddShoppingCartGoodsArray() {
		return addShoppingCartGoodsArray;
	}


	public void setCurrentUrl(String currentUrl) {
		this.currentUrl = currentUrl;
	}
	public void setAddShoppingCartGoodsArray(AddShoppingCartGoodsVO[] addShoppingCartGoodsArray) {
		this.addShoppingCartGoodsArray = addShoppingCartGoodsArray;
	}
}
