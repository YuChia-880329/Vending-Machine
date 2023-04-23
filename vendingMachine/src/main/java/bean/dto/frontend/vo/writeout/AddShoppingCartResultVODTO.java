package bean.dto.frontend.vo.writeout;

public class AddShoppingCartResultVODTO {
	
	private String queryString;

	public AddShoppingCartResultVODTO() {
	}
	public AddShoppingCartResultVODTO(String queryString) {

		this.queryString = queryString;
	}
	
	
	public String getQueryString() {
		return queryString;
	}
	
	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}
}
