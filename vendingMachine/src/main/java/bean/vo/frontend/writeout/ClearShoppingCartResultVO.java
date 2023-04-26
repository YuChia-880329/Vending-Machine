package bean.vo.frontend.writeout;

public class ClearShoppingCartResultVO {

	private String queryString;

	
	public ClearShoppingCartResultVO() {
	}
	public ClearShoppingCartResultVO(String queryString) {

		this.queryString = queryString;
	}
	
	
	public String getQueryString() {
		return queryString;
	}
	
	
	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}
}
