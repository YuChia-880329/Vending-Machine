package bean.dto.backend.orderList.obj.repository.orderTablePages.writeout;

public class OrderTablePageOBJDTO {

	private OrderTableOBJDTO orderTable;

	public OrderTablePageOBJDTO() {
	}
	public OrderTablePageOBJDTO(OrderTableOBJDTO orderTable) {

		this.orderTable = orderTable;
	}
	
	
	public OrderTableOBJDTO getOrderTable() {
		return orderTable;
	}
	
	public void setOrderTable(OrderTableOBJDTO orderTable) {
		this.orderTable = orderTable;
	}
}
