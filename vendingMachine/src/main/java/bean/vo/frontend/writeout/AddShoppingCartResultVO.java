package bean.vo.frontend.writeout;

public class AddShoppingCartResultVO {

	private String queryString;

	
	public AddShoppingCartResultVO() {
	}
	public AddShoppingCartResultVO(String queryString) {

		this.queryString = queryString;
	}
	
	
	public String getQueryString() {
		return queryString;
	}
	
	
	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}
}
