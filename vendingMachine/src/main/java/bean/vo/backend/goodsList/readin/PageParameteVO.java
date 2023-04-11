package bean.vo.backend.goodsList.readin;

import bean.vo.backend.goodsList.SearchParameterVO;

public class PageParameteVO {

	private String page;
	private SearchParameterVO searchParameter;
	
	
	public PageParameteVO() {
	}
	public PageParameteVO(String page, SearchParameterVO searchParameter) {

		this.page = page;
		this.searchParameter = searchParameter;
	}
	
	
	public String getPage() {
		return page;
	}
	public SearchParameterVO getSearchParameter() {
		return searchParameter;
	}
	
	
	public void setPage(String page) {
		this.page = page;
	}
	public void setSearchParameter(SearchParameterVO searchParameter) {
		this.searchParameter = searchParameter;
	}
}
