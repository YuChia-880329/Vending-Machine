package bean.vo.frontend.writeout;

public class UpdateShoppingCartResultVO {

	private String queryString;

	
	public UpdateShoppingCartResultVO() {
	}
	public UpdateShoppingCartResultVO(String queryString) {

		this.queryString = queryString;
	}
	
	
	public String getQueryString() {
		return queryString;
	}
	
	
	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}
}
