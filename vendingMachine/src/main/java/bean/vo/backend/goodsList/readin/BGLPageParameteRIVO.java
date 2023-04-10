package bean.vo.backend.goodsList.readin;

import bean.vo.backend.goodsList.BGLSearchParameterVO;

public class BGLPageParameteRIVO {

	private String page;
	private BGLSearchParameterVO searchParameters;
	
	
	public BGLPageParameteRIVO() {
	}
	public BGLPageParameteRIVO(String page, BGLSearchParameterVO searchParameters) {

		this.page = page;
		this.searchParameters = searchParameters;
	}
	
	
	public String getPage() {
		return page;
	}
	public BGLSearchParameterVO getSearchParameters() {
		return searchParameters;
	}
	
	
	public void setPage(String page) {
		this.page = page;
	}
	public void setSearchParameters(BGLSearchParameterVO searchParameters) {
		this.searchParameters = searchParameters;
	}
}
