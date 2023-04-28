package bean.dto.frontend;

public class CheckoutResultDTO {

	private String queryString;

	public CheckoutResultDTO() {
	}
	public CheckoutResultDTO(String queryString) {

		this.queryString = queryString;
	}
	
	
	public String getQueryString() {
		return queryString;
	}
	
	
	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}
}
