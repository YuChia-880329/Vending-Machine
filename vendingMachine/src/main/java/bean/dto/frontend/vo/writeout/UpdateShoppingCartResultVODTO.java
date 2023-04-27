package bean.dto.frontend.vo.writeout;

public class UpdateShoppingCartResultVODTO {

	private String queryString;

	
	public UpdateShoppingCartResultVODTO() {
	}
	public UpdateShoppingCartResultVODTO(String queryString) {

		this.queryString = queryString;
	}
	
	
	public String getQueryString() {
		return queryString;
	}
	
	
	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}
}
