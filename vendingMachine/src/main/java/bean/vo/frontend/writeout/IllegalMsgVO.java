package bean.vo.frontend.writeout;

public class IllegalMsgVO {

	private String hasMsg;
	private String[] msgs;
	
	
	public IllegalMsgVO() {
	}
	public IllegalMsgVO(String hasMsg, String[] msgs) {

		this.hasMsg = hasMsg;
		this.msgs = msgs;
	}
	
	
	public String getHasMsg() {
		return hasMsg;
	}
	public String[] getMsgs() {
		return msgs;
	}
	
	
	public void setHasMsg(String hasMsg) {
		this.hasMsg = hasMsg;
	}
	public void setMsgs(String[] msgs) {
		this.msgs = msgs;
	}
}
