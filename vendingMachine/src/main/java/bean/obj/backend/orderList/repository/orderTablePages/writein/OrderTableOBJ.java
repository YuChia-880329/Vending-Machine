package bean.obj.backend.orderList.repository.orderTablePages.writein;

import java.util.List;

public class OrderTableOBJ {

	private List<OrderTableRowOBJ> orderTableRows;

	public OrderTableOBJ() {
	}
	public OrderTableOBJ(List<OrderTableRowOBJ> orderTableRows) {

		this.orderTableRows = orderTableRows;
	}
	
	
	public List<OrderTableRowOBJ> getOrderTableRows() {
		return orderTableRows;
	}
	
	public void setOrderTableRows(List<OrderTableRowOBJ> orderTableRows) {
		this.orderTableRows = orderTableRows;
	}
}
