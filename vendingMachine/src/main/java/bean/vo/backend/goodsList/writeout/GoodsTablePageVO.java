package bean.vo.backend.goodsList.writeout;

import bean.vo.backend.goodsList.SearchParameterVO;
import bean.vo.writeout.PaginationWOVO;

public class GoodsTablePageVO {

	private GoodsTableVO goodsTable;
	private SearchParameterVO searchParameter;
	private PaginationWOVO pagination;
	
	
	public GoodsTablePageVO() {
	}
	public GoodsTablePageVO(GoodsTableVO goodsTable, SearchParameterVO searchParameter,
			PaginationWOVO pagination) {

		this.goodsTable = goodsTable;
		this.searchParameter = searchParameter;
		this.pagination = pagination;
	}
	
	
	public GoodsTableVO getGoodsTable() {
		return goodsTable;
	}
	public SearchParameterVO getSearchParameter() {
		return searchParameter;
	}
	public PaginationWOVO getPagination() {
		return pagination;
	}
	
	
	public void setGoodsTable(GoodsTableVO goodsTable) {
		this.goodsTable = goodsTable;
	}
	public void setSearchParameter(SearchParameterVO searchParameter) {
		this.searchParameter = searchParameter;
	}
	public void setPagination(PaginationWOVO pagination) {
		this.pagination = pagination;
	}
}
