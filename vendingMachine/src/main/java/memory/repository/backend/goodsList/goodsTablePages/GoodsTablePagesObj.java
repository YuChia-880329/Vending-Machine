package memory.repository.backend.goodsList.goodsTablePages;

import java.util.Map;

class GoodsTablePagesObj {

	private SearchParametersObj searchParameters;
	private Map<Integer, GoodsTablePageObj> goodsTablePageMap;
	private int maxPage;
	
	
	GoodsTablePagesObj() {
	}
	GoodsTablePagesObj(SearchParametersObj searchParameters, Map<Integer, GoodsTablePageObj> goodsTablePageMap,
			int maxPage) {

		this.searchParameters = searchParameters;
		this.goodsTablePageMap = goodsTablePageMap;
		this.maxPage = maxPage;
	}

	
	SearchParametersObj getSearchParameters() {
		return searchParameters;
	}
	Map<Integer, GoodsTablePageObj> getGoodsTablePageMap() {
		return goodsTablePageMap;
	}
	int getMaxPage() {
		return maxPage;
	}

	
	void setSearchParameters(SearchParametersObj searchParameters) {
		this.searchParameters = searchParameters;
	}
	void setGoodsTablePageMap(Map<Integer, GoodsTablePageObj> goodsTablePageMap) {
		this.goodsTablePageMap = goodsTablePageMap;
	}
	void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}
}
