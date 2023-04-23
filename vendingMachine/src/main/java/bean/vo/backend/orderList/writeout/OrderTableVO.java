package bean.vo.backend.orderList.writeout;

public class OrderTableVO {

	private OrderTableRowVO[] orderTableRows;

	public OrderTableVO() {
	}
	public OrderTableVO(OrderTableRowVO[] orderTableRows) {

		this.orderTableRows = orderTableRows;
	}
	
	
	public OrderTableRowVO[] getOrderTableRows() {
		return orderTableRows;
	}
	
	public void setOrderTableRows(OrderTableRowVO[] orderTableRows) {
		this.orderTableRows = orderTableRows;
	}
}
