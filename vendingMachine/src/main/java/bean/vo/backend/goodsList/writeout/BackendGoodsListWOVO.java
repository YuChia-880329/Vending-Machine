package bean.vo.backend.goodsList.writeout;

import bean.vo.writeout.PaginationWOVO;

public class BackendGoodsListWOVO {

	private BGLGoodsTableWOVO goodsTable;
	private PaginationWOVO pagination;

	
	public BackendGoodsListWOVO() {
	}
	public BackendGoodsListWOVO(BGLGoodsTableWOVO goodsTable, PaginationWOVO pagination) {
		
		this.goodsTable = goodsTable;
		this.pagination = pagination;
	}
	
	
	public BGLGoodsTableWOVO getGoodsTable() {
		return goodsTable;
	}
	public PaginationWOVO getPagination() {
		return pagination;
	}
	
	
	public void setGoodsTable(BGLGoodsTableWOVO goodsTable) {
		this.goodsTable = goodsTable;
	}
	public void setPagination(PaginationWOVO pagination) {
		this.pagination = pagination;
	}
}
