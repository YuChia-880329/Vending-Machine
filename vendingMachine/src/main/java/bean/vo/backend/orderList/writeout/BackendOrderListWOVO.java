package bean.vo.backend.orderList.writeout;

import bean.vo.writeout.PaginationVO;

public class BackendOrderListWOVO {

	private BOLOrderTableLWOVO orderTable;
	private PaginationVO pagination;
	
	
	public BackendOrderListWOVO() {
	}
	public BackendOrderListWOVO(BOLOrderTableLWOVO orderTable, PaginationVO pagination) {

		this.orderTable = orderTable;
		this.pagination = pagination;
	}
	
	
	public BOLOrderTableLWOVO getOrderTable() {
		return orderTable;
	}
	public PaginationVO getPagination() {
		return pagination;
	}
	
	
	public void setOrderTable(BOLOrderTableLWOVO orderTable) {
		this.orderTable = orderTable;
	}
	public void setPagination(PaginationVO pagination) {
		this.pagination = pagination;
	}
}
