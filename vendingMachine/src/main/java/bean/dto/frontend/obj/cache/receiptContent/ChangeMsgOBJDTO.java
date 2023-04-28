package bean.dto.frontend.obj.cache.receiptContent;

import enumeration.Has;

public class ChangeMsgOBJDTO {

	private Has hasMsg;
	private int change;
	
	
	public ChangeMsgOBJDTO() {
	}
	public ChangeMsgOBJDTO(Has hasMsg, int change) {

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
