package bean.dto.vo.backend.goodsList.writeout;

import bean.dto.vo.backend.goodsList.BGLSearchParameterVODTO;
import bean.dto.vo.writeout.PaginationWOVODTO;

public class BGLGoodsTablePageWOVODTO {

	private BGLGoodsTableWOVODTO goodsTable;
	private BGLSearchParameterVODTO searchParameters;
	private PaginationWOVODTO pagination;
	
	
	public BGLGoodsTablePageWOVODTO() {
	}
	public BGLGoodsTablePageWOVODTO(BGLGoodsTableWOVODTO goodsTable, BGLSearchParameterVODTO searchParameters,
			PaginationWOVODTO pagination) {

		this.goodsTable = goodsTable;
		this.searchParameters = searchParameters;
		this.pagination = pagination;
	}
	
	
	public BGLGoodsTableWOVODTO getGoodsTable() {
		return goodsTable;
	}
	public BGLSearchParameterVODTO getSearchParameters() {
		return searchParameters;
	}
	public PaginationWOVODTO getPagination() {
		return pagination;
	}
	
	
	public void setGoodsTable(BGLGoodsTableWOVODTO goodsTable) {
		this.goodsTable = goodsTable;
	}
	public void setSearchParameters(BGLSearchParameterVODTO searchParameters) {
		this.searchParameters = searchParameters;
	}
	public void setPagination(PaginationWOVODTO pagination) {
		this.pagination = pagination;
	}
}
