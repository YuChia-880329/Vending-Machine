package bean.dto.frontend.vo.writeout;

public class ClearShoppingCartResultVODTO {

	private String queryString;

	
	public ClearShoppingCartResultVODTO() {
	}
	public ClearShoppingCartResultVODTO(String queryString) {

		this.queryString = queryString;
	}
	
	
	public String getQueryString() {
		return queryString;
	}
	
	
	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}
}
