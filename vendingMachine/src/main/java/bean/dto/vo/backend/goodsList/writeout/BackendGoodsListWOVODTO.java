package bean.dto.vo.backend.goodsList.writeout;

import bean.dto.vo.writeout.PaginationWOVODTO;

public class BackendGoodsListWOVODTO {

	private BGLGoodsTableWOVODTO goodsTable;
	private BGLSearchParameterWOVODTO searchParameter;
	private PaginationWOVODTO pagination;


	
	public BackendGoodsListWOVODTO() {
	}
	public BackendGoodsListWOVODTO(BGLGoodsTableWOVODTO goodsTable, 
			BGLSearchParameterWOVODTO searchParameter, PaginationWOVODTO pagination) {
		
		this.goodsTable = goodsTable;
		this.searchParameter = searchParameter;
		this.pagination = pagination;
	}
	
	
	public BGLGoodsTableWOVODTO getGoodsTable() {
		return goodsTable;
	}
	public BGLSearchParameterWOVODTO getSearchParameter() {
		return searchParameter;
	}
	public PaginationWOVODTO getPagination() {
		return pagination;
	}
	
	
	public void setGoodsTable(BGLGoodsTableWOVODTO goodsTable) {
		this.goodsTable = goodsTable;
	}
	public void setSearchParameter(BGLSearchParameterWOVODTO searchParameter) {
		this.searchParameter = searchParameter;
	}
	public void setPagination(PaginationWOVODTO pagination) {
		this.pagination = pagination;
	}
}
