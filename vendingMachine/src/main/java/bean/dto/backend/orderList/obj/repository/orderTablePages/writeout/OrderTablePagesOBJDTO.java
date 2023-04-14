package bean.dto.backend.orderList.obj.repository.orderTablePages.writeout;

import java.util.Map;

public class OrderTablePagesOBJDTO {

	private Map<Integer, OrderTablePageOBJDTO> orderTablePageMap;
	private int maxPage;
	private FilterParameterOBJDTO filterParameter;
	
	
	public OrderTablePagesOBJDTO() {
	}
	public OrderTablePagesOBJDTO(Map<Integer, OrderTablePageOBJDTO> orderTablePageMap, int maxPage,
			FilterParameterOBJDTO filterParameter) {

		this.orderTablePageMap = orderTablePageMap;
		this.maxPage = maxPage;
		this.filterParameter = filterParameter;
	}
	
	
	public Map<Integer, OrderTablePageOBJDTO> getOrderTablePageMap() {
		return orderTablePageMap;
	}
	public int getMaxPage() {
		return maxPage;
	}
	public FilterParameterOBJDTO getFilterParameter() {
		return filterParameter;
	}
	
	
	public void setOrderTablePageMap(Map<Integer, OrderTablePageOBJDTO> orderTablePageMap) {
		this.orderTablePageMap = orderTablePageMap;
	}
	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}
	public void setFilterParameter(FilterParameterOBJDTO filterParameter) {
		this.filterParameter = filterParameter;
	}
}
