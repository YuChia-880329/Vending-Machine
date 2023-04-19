package bean.dto.frontend.vo.writeout;

public class WelcomeMsgVODTO {

	private String customerName;

	public WelcomeMsgVODTO() {
	}
	public WelcomeMsgVODTO(String customerName) {

		this.customerName = customerName;
	}
	
	
	public String getCustomerName() {
		return customerName;
	}
	
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
}
