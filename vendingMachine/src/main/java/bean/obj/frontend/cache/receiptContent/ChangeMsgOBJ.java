package bean.obj.frontend.cache.receiptContent;

import enumeration.Has;

public class ChangeMsgOBJ {

	private Has hasMsg;
	private int change;
	
	
	public ChangeMsgOBJ() {
	}
	public ChangeMsgOBJ(Has hasMsg, int change) {

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
