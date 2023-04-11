package bean.obj.repository.bglGoodsTablePages.writeout;

import java.util.Map;

import bean.obj.repository.bglGoodsTablePages.SearchParametersObj;

public class GoodsTablePagesObj {

	private SearchParametersObj searchParameters;
	private Map<Integer, GoodsTablePageObj> goodsTablePageMap;
	private int maxPage;
	
	
	public GoodsTablePagesObj() {
	}
	public GoodsTablePagesObj(SearchParametersObj searchParameters, Map<Integer, GoodsTablePageObj> goodsTablePageMap,
			int maxPage) {

		this.searchParameters = searchParameters;
		this.goodsTablePageMap = goodsTablePageMap;
		this.maxPage = maxPage;
	}

	
	public SearchParametersObj getSearchParameters() {
		return searchParameters;
	}
	public Map<Integer, GoodsTablePageObj> getGoodsTablePageMap() {
		return goodsTablePageMap;
	}
	public int getMaxPage() {
		return maxPage;
	}

	
	public void setSearchParameters(SearchParametersObj searchParameters) {
		this.searchParameters = searchParameters;
	}
	public void setGoodsTablePageMap(Map<Integer, GoodsTablePageObj> goodsTablePageMap) {
		this.goodsTablePageMap = goodsTablePageMap;
	}
	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}
}
