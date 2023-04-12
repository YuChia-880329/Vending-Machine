package bean.dto.backend.orderList.vo.writeout;

import bean.dto.vo.writeout.PaginationVODTO;

public class OrderTablePageVODTO {

	private OrderTableVODTO orderTable;
	private PaginationVODTO pagination;
	
	
	public OrderTablePageVODTO() {
	}
	public OrderTablePageVODTO(OrderTableVODTO orderTable, PaginationVODTO pagination) {

		this.orderTable = orderTable;
		this.pagination = pagination;
	}
	
	
	public OrderTableVODTO getOrderTable() {
		return orderTable;
	}
	public PaginationVODTO getPagination() {
		return pagination;
	}
	
	
	public void setOrderTable(OrderTableVODTO orderTable) {
		this.orderTable = orderTable;
	}
	public void setPagination(PaginationVODTO pagination) {
		this.pagination = pagination;
	}
}
