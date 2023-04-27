package bean.vo.frontend.readin;

public class UpdateShoppingCartVO {

	private UpdateShoppingCartGoodsVO[] updateShoppingCartGoodsArray;
	private String queryString;
	
	
	public UpdateShoppingCartVO() {
	}
	public UpdateShoppingCartVO(UpdateShoppingCartGoodsVO[] updateShoppingCartGoodsArray, String queryString) {

		this.updateShoppingCartGoodsArray = updateShoppingCartGoodsArray;
		this.queryString = queryString;
	}
	
	
	public UpdateShoppingCartGoodsVO[] getUpdateShoppingCartGoodsArray() {
		return updateShoppingCartGoodsArray;
	}
	public String getQueryString() {
		return queryString;
	}
	
	
	public void setUpdateShoppingCartGoodsArray(UpdateShoppingCartGoodsVO[] updateShoppingCartGoodsArray) {
		this.updateShoppingCartGoodsArray = updateShoppingCartGoodsArray;
	}
	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}
}
