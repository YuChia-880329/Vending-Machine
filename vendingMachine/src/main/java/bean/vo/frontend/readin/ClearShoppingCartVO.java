package bean.vo.frontend.readin;

public class ClearShoppingCartVO {

	private String queryString;

	public ClearShoppingCartVO() {
	}
	public ClearShoppingCartVO(String queryString) {

		this.queryString = queryString;
	}
	
	
	public String getQueryString() {
		return queryString;
	}
	
	
	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}
}
