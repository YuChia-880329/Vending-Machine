package bean.vo.frontend.writeout;

public class ChangeMsgVO {

	private String hasMsg;
	private String change;
	
	
	public ChangeMsgVO() {
	}
	public ChangeMsgVO(String hasMsg, String change) {

		this.hasMsg = hasMsg;
		this.change = change;
	}
	
	
	public String getHasMsg() {
		return hasMsg;
	}
	public String getChange() {
		return change;
	}
	
	
	public void setHasMsg(String hasMsg) {
		this.hasMsg = hasMsg;
	}
	public void setChange(String change) {
		this.change = change;
	}
}
