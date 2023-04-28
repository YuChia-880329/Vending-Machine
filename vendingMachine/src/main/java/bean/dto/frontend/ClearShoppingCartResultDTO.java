package bean.dto.frontend;

public class ClearShoppingCartResultDTO {

	private String queryString;

	
	public ClearShoppingCartResultDTO() {
	}
	public ClearShoppingCartResultDTO(String queryString) {

		this.queryString = queryString;
	}
	
	
	public String getQueryString() {
		return queryString;
	}
	
	
	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}
}
