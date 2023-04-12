package bean.dto.backend.orderList.vo.writeout;

public class BackendOrderListWOVODTO {

	private OrderTablePageVODTO orderTablePage;
	private FilterFormVODTO filterForm;
	
	
	public BackendOrderListWOVODTO() {
	}
	public BackendOrderListWOVODTO(OrderTablePageVODTO orderTablePage, FilterFormVODTO filterForm) {

		this.orderTablePage = orderTablePage;
		this.filterForm = filterForm;
	}
	
	
	public OrderTablePageVODTO getOrderTablePage() {
		return orderTablePage;
	}
	public FilterFormVODTO getFilterForm() {
		return filterForm;
	}
	
	
	public void setOrderTablePage(OrderTablePageVODTO orderTablePage) {
		this.orderTablePage = orderTablePage;
	}
	public void setFilterForm(FilterFormVODTO filterForm) {
		this.filterForm = filterForm;
	}
}
