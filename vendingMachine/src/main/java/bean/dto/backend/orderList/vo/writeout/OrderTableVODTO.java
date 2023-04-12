package bean.dto.backend.orderList.vo.writeout;

import java.util.List;

public class OrderTableVODTO {

	private List<OrderTableRowVODTO> orderTableRows;

	public OrderTableVODTO() {
	}
	public OrderTableVODTO(List<OrderTableRowVODTO> orderTableRows) {

		this.orderTableRows = orderTableRows;
	}
	
	
	public List<OrderTableRowVODTO> getOrderTableRows() {
		return orderTableRows;
	}
	
	public void setOrderTableRows(List<OrderTableRowVODTO> orderTableRows) {
		this.orderTableRows = orderTableRows;
	}
}
