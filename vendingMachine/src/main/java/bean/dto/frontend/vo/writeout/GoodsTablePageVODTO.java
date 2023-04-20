package bean.dto.frontend.vo.writeout;

import bean.dto.vo.writeout.PaginationVODTO;

public class GoodsTablePageVODTO {

	private GoodsTableVODTO goodsTable;
	private PaginationVODTO pagination;

	public GoodsTablePageVODTO() {
	}
	public GoodsTablePageVODTO(GoodsTableVODTO goodsTable, PaginationVODTO pagination) {

		this.goodsTable = goodsTable;
		this.pagination = pagination;
	}
	
	
	public GoodsTableVODTO getGoodsTable() {
		return goodsTable;
	}
	public PaginationVODTO getPagination() {
		return pagination;
	}
	
	
	public void setGoodsTable(GoodsTableVODTO goodsTable) {
		this.goodsTable = goodsTable;
	}
	public void setPagination(PaginationVODTO pagination) {
		this.pagination = pagination;
	}
}
