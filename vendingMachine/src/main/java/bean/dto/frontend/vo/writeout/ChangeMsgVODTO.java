package bean.dto.frontend.vo.writeout;

public class ChangeMsgVODTO {

	private boolean hasMsg;
	private int change;
	
	
	public ChangeMsgVODTO() {
	}
	public ChangeMsgVODTO(boolean hasMsg, int change) {

		this.hasMsg = hasMsg;
		this.change = change;
	}
	
	
	public boolean getHasMsg() {
		return hasMsg;
	}
	public int getChange() {
		return change;
	}
	
	
	public void setHasMsg(boolean hasMsg) {
		this.hasMsg = hasMsg;
	}
	public void setChange(int change) {
		this.change = change;
	}
}
