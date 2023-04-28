package bean.dto.frontend;

public class UpdateShoppingCartResultDTO {

	private String queryString;

	
	public UpdateShoppingCartResultDTO() {
	}
	public UpdateShoppingCartResultDTO(String queryString) {

		this.queryString = queryString;
	}
	
	
	public String getQueryString() {
		return queryString;
	}
	
	
	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}
}
