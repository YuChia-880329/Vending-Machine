package bean.dto.frontend.vo.readin;

public class ClearShoppingCartVODTO {

	private String queryString;

	public ClearShoppingCartVODTO() {
	}
	public ClearShoppingCartVODTO(String queryString) {

		this.queryString = queryString;
	}
	
	
	public String getQueryString() {
		return queryString;
	}
	
	
	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}
}
