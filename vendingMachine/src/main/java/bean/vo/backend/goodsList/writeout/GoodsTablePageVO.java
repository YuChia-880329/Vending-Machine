package bean.vo.backend.goodsList.writeout;

import bean.vo.writeout.PaginationVO;

public class GoodsTablePageVO {

	private GoodsTableVO goodsTable;
	private PaginationVO pagination;
	
	
	public GoodsTablePageVO() {
	}
	public GoodsTablePageVO(GoodsTableVO goodsTable, PaginationVO pagination) {

		this.goodsTable = goodsTable;
		this.pagination = pagination;
	}
	
	
	public GoodsTableVO getGoodsTable() {
		return goodsTable;
	}
	public PaginationVO getPagination() {
		return pagination;
	}
	
	
	public void setGoodsTable(GoodsTableVO goodsTable) {
		this.goodsTable = goodsTable;
	}
	public void setPagination(PaginationVO pagination) {
		this.pagination = pagination;
	}
}
