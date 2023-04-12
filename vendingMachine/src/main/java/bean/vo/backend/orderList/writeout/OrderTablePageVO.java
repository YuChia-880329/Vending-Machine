package bean.vo.backend.orderList.writeout;

import bean.vo.writeout.PaginationVO;

public class OrderTablePageVO {

	private OrderTableVO orderTable;
	private PaginationVO pagination;
	
	
	public OrderTablePageVO() {
	}
	public OrderTablePageVO(OrderTableVO orderTable, PaginationVO pagination) {

		this.orderTable = orderTable;
		this.pagination = pagination;
	}
	
	
	public OrderTableVO getOrderTable() {
		return orderTable;
	}
	public PaginationVO getPagination() {
		return pagination;
	}
	
	
	public void setOrderTable(OrderTableVO orderTable) {
		this.orderTable = orderTable;
	}
	public void setPagination(PaginationVO pagination) {
		this.pagination = pagination;
	}
}
