package bean.obj.frontend.cache.receiptContent;

public class ChangeMsgOBJ {

	private boolean hasMsg;
	private int change;
	
	
	public ChangeMsgOBJ() {
	}
	public ChangeMsgOBJ(boolean hasMsg, int change) {

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
