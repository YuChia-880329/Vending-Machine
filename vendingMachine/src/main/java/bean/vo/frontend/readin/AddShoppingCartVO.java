package bean.vo.frontend.readin;

public class AddShoppingCartVO {

	private AddShoppingCartGoodsVO[] addShoppingCartGoodsArray;
	private String queryString;

	public AddShoppingCartVO() {
	}
	public AddShoppingCartVO(AddShoppingCartGoodsVO[] addShoppingCartGoodsArray, String queryString) {
		
		this.addShoppingCartGoodsArray = addShoppingCartGoodsArray;
		this.queryString = queryString;
	}
	
	
	public AddShoppingCartGoodsVO[] getAddShoppingCartGoodsArray() {
		return addShoppingCartGoodsArray;
	}
	public String getQueryString() {
		return queryString;
	}

	
	public void setAddShoppingCartGoodsArray(AddShoppingCartGoodsVO[] addShoppingCartGoodsArray) {
		this.addShoppingCartGoodsArray = addShoppingCartGoodsArray;
	}
	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}
}
