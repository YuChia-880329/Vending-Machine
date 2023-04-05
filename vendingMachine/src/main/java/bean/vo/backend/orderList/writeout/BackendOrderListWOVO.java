package bean.vo.backend.orderList.writeout;

import bean.vo.writeout.PaginationWOVO;

public class BackendOrderListWOVO {

	private BOLOrderTableLWOVO orderTable;
	private PaginationWOVO pagination;
	
	
	public BackendOrderListWOVO() {
	}
	public BackendOrderListWOVO(BOLOrderTableLWOVO orderTable, PaginationWOVO pagination) {

		this.orderTable = orderTable;
		this.pagination = pagination;
	}
	
	
	public BOLOrderTableLWOVO getOrderTable() {
		return orderTable;
	}
	public PaginationWOVO getPagination() {
		return pagination;
	}
	
	
	public void setOrderTable(BOLOrderTableLWOVO orderTable) {
		this.orderTable = orderTable;
	}
	public void setPagination(PaginationWOVO pagination) {
		this.pagination = pagination;
	}
}
