package memory.repository.backend.goodsList.goodsTablePages;

class GoodsTablePagesInputObj {

	private SearchParametersObj searchParameters;
	private int currentPage;
	
	
	GoodsTablePagesInputObj() {
	}
	GoodsTablePagesInputObj(SearchParametersObj searchParameters, int currentPage) {

		this.searchParameters = searchParameters;
		this.currentPage = currentPage;
	}
	
	
	SearchParametersObj getSearchParameters() {
		return searchParameters;
	}
	int getCurrentPage() {
		return currentPage;
	}
	
	
	void setSearchParameters(SearchParametersObj searchParameters) {
		this.searchParameters = searchParameters;
	}
	void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
}
