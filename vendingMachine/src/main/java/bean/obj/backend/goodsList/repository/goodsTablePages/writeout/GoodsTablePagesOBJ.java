package bean.obj.backend.goodsList.repository.goodsTablePages.writeout;

import java.util.Map;

import bean.obj.backend.goodsList.repository.goodsTablePages.SearchParameterOBJ;

public class GoodsTablePagesOBJ {

	private SearchParameterOBJ searchParameter;
	private Map<Integer, GoodsTablePageOBJ> goodsTablePageMap;
	private int maxPage;
	
	
	public GoodsTablePagesOBJ() {
	}
	public GoodsTablePagesOBJ(SearchParameterOBJ searchParameter, Map<Integer, GoodsTablePageOBJ> goodsTablePageMap,
			int maxPage) {

		this.searchParameter = searchParameter;
		this.goodsTablePageMap = goodsTablePageMap;
		this.maxPage = maxPage;
	}

	
	public SearchParameterOBJ getSearchParameter() {
		return searchParameter;
	}
	public Map<Integer, GoodsTablePageOBJ> getGoodsTablePageMap() {
		return goodsTablePageMap;
	}
	public int getMaxPage() {
		return maxPage;
	}

	
	public void setSearchParameter(SearchParameterOBJ searchParameter) {
		this.searchParameter = searchParameter;
	}
	public void setGoodsTablePageMap(Map<Integer, GoodsTablePageOBJ> goodsTablePageMap) {
		this.goodsTablePageMap = goodsTablePageMap;
	}
	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}
}
