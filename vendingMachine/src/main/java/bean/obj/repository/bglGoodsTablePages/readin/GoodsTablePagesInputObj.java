package bean.obj.repository.bglGoodsTablePages.readin;

import bean.obj.repository.bglGoodsTablePages.SearchParametersObj;

public class GoodsTablePagesInputObj {

	private SearchParametersObj searchParameters;
	private int currentPage;
	
	
	public GoodsTablePagesInputObj() {
	}
	public GoodsTablePagesInputObj(SearchParametersObj searchParameters, int currentPage) {

		this.searchParameters = searchParameters;
		this.currentPage = currentPage;
	}
	
	
	public SearchParametersObj getSearchParameters() {
		return searchParameters;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	
	
	public void setSearchParameters(SearchParametersObj searchParameters) {
		this.searchParameters = searchParameters;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
}
