package bean.vo.backend.orderList.writeout;

public class BackendOrderListVO {

	private OrderTablePageVO orderTablePage;
	private FilterFormVO filterForm;
	
	
	public BackendOrderListVO() {
	}
	public BackendOrderListVO(OrderTablePageVO orderTablePage, FilterFormVO filterForm) {

		this.orderTablePage = orderTablePage;
		this.filterForm = filterForm;
	}
	
	
	public OrderTablePageVO getOrderTablePage() {
		return orderTablePage;
	}
	public FilterFormVO getFilterForm() {
		return filterForm;
	}
	
	
	public void setOrderTablePage(OrderTablePageVO orderTablePage) {
		this.orderTablePage = orderTablePage;
	}
	public void setFilterForm(FilterFormVO filterForm) {
		this.filterForm = filterForm;
	}
}
