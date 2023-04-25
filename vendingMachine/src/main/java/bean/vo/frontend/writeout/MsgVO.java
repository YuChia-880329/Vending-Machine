package bean.vo.frontend.writeout;

public class MsgVO {

	private String hasMsg;
	private String[] lines;
	
	
	public MsgVO() {
	}
	public MsgVO(String hasMsg, String[] lines) {

		this.hasMsg = hasMsg;
		this.lines = lines;
	}
	
	
	public String getHasMsg() {
		return hasMsg;
	}
	public String[] getLines() {
		return lines;
	}
	
	
	public void setHasMsg(String hasMsg) {
		this.hasMsg = hasMsg;
	}
	public void setLines(String[] lines) {
		this.lines = lines;
	}
}
