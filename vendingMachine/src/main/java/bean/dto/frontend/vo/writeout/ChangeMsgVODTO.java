package bean.dto.frontend.vo.writeout;

import enumeration.Has;

public class ChangeMsgVODTO {

	private Has hasMsg;
	private int change;
	
	
	public ChangeMsgVODTO() {
	}
	public ChangeMsgVODTO(Has hasMsg, int change) {

		this.hasMsg = hasMsg;
		this.change = change;
	}
	
	
	public Has getHasMsg() {
		return hasMsg;
	}
	public int getChange() {
		return change;
	}
	
	
	public void setHasMsg(Has hasMsg) {
		this.hasMsg = hasMsg;
	}
	public void setChange(int change) {
		this.change = change;
	}
}
