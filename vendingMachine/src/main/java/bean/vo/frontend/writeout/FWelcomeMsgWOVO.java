package bean.vo.frontend.writeout;

public class FWelcomeMsgWOVO {

	private String customerName;

	public FWelcomeMsgWOVO() {
	}
	public FWelcomeMsgWOVO(String customerName) {

		this.customerName = customerName;
	}
	
	
	public String getCustomerName() {
		return customerName;
	}
	
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
}
