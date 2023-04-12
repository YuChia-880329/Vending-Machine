package bean.vo.backend.orderList.writeout;

import java.util.List;

public class OrderTableVO {

	private List<OrderTableRowVO> orderTableRows;

	public OrderTableVO() {
	}
	public OrderTableVO(List<OrderTableRowVO> orderTableRows) {

		this.orderTableRows = orderTableRows;
	}
	
	
	public List<OrderTableRowVO> getOrderTableRows() {
		return orderTableRows;
	}
	
	public void setOrderTableRows(List<OrderTableRowVO> orderTableRows) {
		this.orderTableRows = orderTableRows;
	}
}
