package bean.vo.backend.goodsList.writeout;

import bean.vo.backend.goodsList.BGLSearchParameterVO;
import bean.vo.writeout.PaginationWOVO;

public class BGLGoodsTablePageWOVO {

	private BGLGoodsTableWOVO goodsTable;
	private BGLSearchParameterVO searchParameters;
	private PaginationWOVO pagination;
	
	
	public BGLGoodsTablePageWOVO() {
	}
	public BGLGoodsTablePageWOVO(BGLGoodsTableWOVO goodsTable, BGLSearchParameterVO searchParameters,
			PaginationWOVO pagination) {

		this.goodsTable = goodsTable;
		this.searchParameters = searchParameters;
		this.pagination = pagination;
	}
	
	
	public BGLGoodsTableWOVO getGoodsTable() {
		return goodsTable;
	}
	public BGLSearchParameterVO getSearchParameters() {
		return searchParameters;
	}
	public PaginationWOVO getPagination() {
		return pagination;
	}
	
	
	public void setGoodsTable(BGLGoodsTableWOVO goodsTable) {
		this.goodsTable = goodsTable;
	}
	public void setSearchParameters(BGLSearchParameterVO searchParameters) {
		this.searchParameters = searchParameters;
	}
	public void setPagination(PaginationWOVO pagination) {
		this.pagination = pagination;
	}
}
