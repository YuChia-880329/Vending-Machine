package bean.dto.vo.backend.orderList.writeout;

import bean.dto.vo.writeout.PaginationWOVODTO;

public class BackendOrderListWOVODTO {

	private BOLOrderTableLWOVODTO orderTable;
	private PaginationWOVODTO pagination;
	
	
	public BackendOrderListWOVODTO() {
	}
	public BackendOrderListWOVODTO(BOLOrderTableLWOVODTO orderTable, PaginationWOVODTO pagination) {

		this.orderTable = orderTable;
		this.pagination = pagination;
	}
	
	
	public BOLOrderTableLWOVODTO getOrderTable() {
		return orderTable;
	}
	public PaginationWOVODTO getPagination() {
		return pagination;
	}
	
	
	public void setOrderTable(BOLOrderTableLWOVODTO orderTable) {
		this.orderTable = orderTable;
	}
	public void setPagination(PaginationWOVODTO pagination) {
		this.pagination = pagination;
	}
}
