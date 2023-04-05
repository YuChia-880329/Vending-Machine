package bean.dto.vo.frontend.writeout;

public class FWelcomeMsgWOVODTO {

	private String customerName;

	public FWelcomeMsgWOVODTO() {
	}
	public FWelcomeMsgWOVODTO(String customerName) {

		this.customerName = customerName;
	}
	
	
	public String getCustomerName() {
		return customerName;
	}
	
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
}
