package bean.dto.backend.goodsList.vo.writeout;

import bean.dto.backend.goodsList.vo.SearchParameterVODTO;
import bean.dto.vo.writeout.PaginationWOVODTO;

public class GoodsTablePageVODTO {

	private GoodsTableVODTO goodsTable;
	private SearchParameterVODTO searchParameter;
	private PaginationWOVODTO pagination;
	
	
	public GoodsTablePageVODTO() {
	}
	public GoodsTablePageVODTO(GoodsTableVODTO goodsTable, SearchParameterVODTO searchParameter,
			PaginationWOVODTO pagination) {

		this.goodsTable = goodsTable;
		this.searchParameter = searchParameter;
		this.pagination = pagination;
	}
	
	
	public GoodsTableVODTO getGoodsTable() {
		return goodsTable;
	}
	public SearchParameterVODTO getSearchParameter() {
		return searchParameter;
	}
	public PaginationWOVODTO getPagination() {
		return pagination;
	}
	
	
	public void setGoodsTable(GoodsTableVODTO goodsTable) {
		this.goodsTable = goodsTable;
	}
	public void setSearchParameter(SearchParameterVODTO searchParameter) {
		this.searchParameter = searchParameter;
	}
	public void setPagination(PaginationWOVODTO pagination) {
		this.pagination = pagination;
	}
}
