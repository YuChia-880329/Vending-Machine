package bean.vo.frontend.writeout;

public class WelcomeMsgVO {

	private String customerName;

	public WelcomeMsgVO() {
	}
	public WelcomeMsgVO(String customerName) {

		this.customerName = customerName;
	}
	
	
	public String getCustomerName() {
		return customerName;
	}
	
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
}
