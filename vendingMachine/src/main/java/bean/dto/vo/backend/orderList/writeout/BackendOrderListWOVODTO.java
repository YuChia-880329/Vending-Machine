package bean.dto.vo.backend.orderList.writeout;

import bean.dto.vo.writeout.PaginationVODTO;

public class BackendOrderListWOVODTO {

	private BOLOrderTableLWOVODTO orderTable;
	private PaginationVODTO pagination;
	
	
	public BackendOrderListWOVODTO() {
	}
	public BackendOrderListWOVODTO(BOLOrderTableLWOVODTO orderTable, PaginationVODTO pagination) {

		this.orderTable = orderTable;
		this.pagination = pagination;
	}
	
	
	public BOLOrderTableLWOVODTO getOrderTable() {
		return orderTable;
	}
	public PaginationVODTO getPagination() {
		return pagination;
	}
	
	
	public void setOrderTable(BOLOrderTableLWOVODTO orderTable) {
		this.orderTable = orderTable;
	}
	public void setPagination(PaginationVODTO pagination) {
		this.pagination = pagination;
	}
}
