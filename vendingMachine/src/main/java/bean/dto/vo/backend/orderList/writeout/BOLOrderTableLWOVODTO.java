package bean.dto.vo.backend.orderList.writeout;

import java.util.List;

public class BOLOrderTableLWOVODTO {

	private List<BOLOTOrderWOVODTO> orders;

	public BOLOrderTableLWOVODTO() {
	}
	public BOLOrderTableLWOVODTO(List<BOLOTOrderWOVODTO> orders) {

		this.orders = orders;
	}
	
	
	public List<BOLOTOrderWOVODTO> getOrders() {
		return orders;
	}
	
	public void setOrders(List<BOLOTOrderWOVODTO> orders) {
		this.orders = orders;
	}
}
