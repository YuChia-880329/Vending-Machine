package bean.obj.backend.orderList.repository.orderTablePages.writein;

import java.util.Map;

public class OrderTablePagesOBJ {

	private Map<Integer, OrderTablePageOBJ> orderTablePageMap;
	private int maxPage;
	private FilterParameterOBJ filterParameter;
	
	
	public OrderTablePagesOBJ() {
	}
	public OrderTablePagesOBJ(Map<Integer, OrderTablePageOBJ> orderTablePageMap, int maxPage,
			FilterParameterOBJ filterParameter) {

		this.orderTablePageMap = orderTablePageMap;
		this.maxPage = maxPage;
		this.filterParameter = filterParameter;
	}
	
	
	public Map<Integer, OrderTablePageOBJ> getOrderTablePageMap() {
		return orderTablePageMap;
	}
	public int getMaxPage() {
		return maxPage;
	}
	public FilterParameterOBJ getFilterParameter() {
		return filterParameter;
	}
	
	
	public void setOrderTablePageMap(Map<Integer, OrderTablePageOBJ> orderTablePageMap) {
		this.orderTablePageMap = orderTablePageMap;
	}
	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}
	public void setFilterParameter(FilterParameterOBJ filterParameter) {
		this.filterParameter = filterParameter;
	}
}
