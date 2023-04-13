package bean.dto.backend.orderList.obj.repository.orderTablePages.writeout;

import java.util.List;

public class OrderTableOBJDTO {

	private List<OrderTableRowOBJDTO> orderTableRows;

	public OrderTableOBJDTO() {
	}
	public OrderTableOBJDTO(List<OrderTableRowOBJDTO> orderTableRows) {

		this.orderTableRows = orderTableRows;
	}
	
	
	public List<OrderTableRowOBJDTO> getOrderTableRows() {
		return orderTableRows;
	}
	
	public void setOrderTableRows(List<OrderTableRowOBJDTO> orderTableRows) {
		this.orderTableRows = orderTableRows;
	}
}
