package bean.obj.backend.goodsList.repository.goodsTablePages.readin;

import bean.obj.backend.goodsList.repository.goodsTablePages.SearchParameterOBJ;

public class GoodsTablePagesInputOBJ {

	private SearchParameterOBJ searchParameter;
	private int currentPage;
	
	
	public GoodsTablePagesInputOBJ() {
	}
	public GoodsTablePagesInputOBJ(SearchParameterOBJ searchParameter, int currentPage) {

		this.searchParameter = searchParameter;
		this.currentPage = currentPage;
	}
	
	
	public SearchParameterOBJ getSearchParameter() {
		return searchParameter;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	
	
	public void setSearchParameter(SearchParameterOBJ searchParameter) {
		this.searchParameter = searchParameter;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
}
