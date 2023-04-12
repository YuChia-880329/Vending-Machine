package bean.obj.backend.orderList.repository.orderTablePages.writein;

public class OrderTablePageOBJ {

	private OrderTableOBJ orderTable;

	public OrderTablePageOBJ() {
	}
	public OrderTablePageOBJ(OrderTableOBJ orderTable) {

		this.orderTable = orderTable;
	}
	
	
	public OrderTableOBJ getOrderTable() {
		return orderTable;
	}
	
	public void setOrderTable(OrderTableOBJ orderTable) {
		this.orderTable = orderTable;
	}
}
