package bean.obj.backend.goodsList.repository.goodsTablePages.writeout;

import java.util.Map;

public class GoodsTablePagesOBJ {

	private Map<Integer, GoodsTablePageOBJ> goodsTablePageMap;
	private int maxPage;
	private FilterParameterOBJ filterParameter;
	
	
	public GoodsTablePagesOBJ() {
	}
	public GoodsTablePagesOBJ(Map<Integer, GoodsTablePageOBJ> goodsTablePageMap, int maxPage,
			FilterParameterOBJ filterParameter) {

		this.goodsTablePageMap = goodsTablePageMap;
		this.maxPage = maxPage;
		this.filterParameter = filterParameter;
	}
	
	
	public Map<Integer, GoodsTablePageOBJ> getGoodsTablePageMap() {
		return goodsTablePageMap;
	}
	public int getMaxPage() {
		return maxPage;
	}
	public FilterParameterOBJ getFilterParameter() {
		return filterParameter;
	}
	
	
	public void setGoodsTablePageMap(Map<Integer, GoodsTablePageOBJ> goodsTablePageMap) {
		this.goodsTablePageMap = goodsTablePageMap;
	}
	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}
	public void setFilterParameter(FilterParameterOBJ filterParameter) {
		this.filterParameter = filterParameter;
	}
}
