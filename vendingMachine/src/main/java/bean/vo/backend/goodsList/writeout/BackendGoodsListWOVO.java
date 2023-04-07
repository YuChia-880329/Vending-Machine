package bean.vo.backend.goodsList.writeout;

import bean.vo.writeout.PaginationWOVO;

public class BackendGoodsListWOVO {

	private BGLGoodsTableWOVO goodsTable;
	private BGLSearchParameterWOVO searchParameter;
	private PaginationWOVO pagination;

	
	public BackendGoodsListWOVO() {
	}
	public BackendGoodsListWOVO(BGLGoodsTableWOVO goodsTable, 
			BGLSearchParameterWOVO searchParameter, PaginationWOVO pagination) {
		
		this.goodsTable = goodsTable;
		this.searchParameter = searchParameter;
		this.pagination = pagination;
	}
	
	
	public BGLGoodsTableWOVO getGoodsTable() {
		return goodsTable;
	}
	public BGLSearchParameterWOVO getSearchParameter() {
		return searchParameter;
	}
	public PaginationWOVO getPagination() {
		return pagination;
	}
	
	
	public void setGoodsTable(BGLGoodsTableWOVO goodsTable) {
		this.goodsTable = goodsTable;
	}
	public void setSearchParameter(BGLSearchParameterWOVO searchParameter) {
		this.searchParameter = searchParameter;
	}
	public void setPagination(PaginationWOVO pagination) {
		this.pagination = pagination;
	}
}
