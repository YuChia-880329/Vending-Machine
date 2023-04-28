package bean.dto.frontend;

public class AddShoppingCartResultDTO {
	
	private String queryString;

	public AddShoppingCartResultDTO() {
	}
	public AddShoppingCartResultDTO(String queryString) {

		this.queryString = queryString;
	}
	
	
	public String getQueryString() {
		return queryString;
	}
	
	
	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}
}
