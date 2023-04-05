package bean.dto.vo.backend.goodsList.writeout;

import bean.dto.vo.writeout.PaginationWOVODTO;

public class BackendGoodsListWOVODTO {

	private BGLGoodsTableWOVODTO goodsTable;
	private PaginationWOVODTO pagination;

	
	public BackendGoodsListWOVODTO() {
	}
	public BackendGoodsListWOVODTO(BGLGoodsTableWOVODTO goodsTable, PaginationWOVODTO pagination) {
		
		this.goodsTable = goodsTable;
		this.pagination = pagination;
	}
	
	
	public BGLGoodsTableWOVODTO getGoodsTable() {
		return goodsTable;
	}
	public PaginationWOVODTO getPagination() {
		return pagination;
	}
	
	
	public void setGoodsTable(BGLGoodsTableWOVODTO goodsTable) {
		this.goodsTable = goodsTable;
	}
	public void setPagination(PaginationWOVODTO pagination) {
		this.pagination = pagination;
	}
}
