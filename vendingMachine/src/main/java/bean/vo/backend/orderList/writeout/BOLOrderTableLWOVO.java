package bean.vo.backend.orderList.writeout;

import java.util.List;

public class BOLOrderTableLWOVO {

	private List<BOLOTOrderWOVO> orders;

	public BOLOrderTableLWOVO() {
	}
	public BOLOrderTableLWOVO(List<BOLOTOrderWOVO> orders) {

		this.orders = orders;
	}
	
	
	public List<BOLOTOrderWOVO> getOrders() {
		return orders;
	}
	
	public void setOrders(List<BOLOTOrderWOVO> orders) {
		this.orders = orders;
	}
}
