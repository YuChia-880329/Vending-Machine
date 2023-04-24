package bean.obj.frontend.memoryDb.illegalMsg;

import java.util.List;

import enumeration.Has;

public class IllegalMsgOBJ {

	private Has hasMsg;
	private List<String> msgs;
	
	
	public IllegalMsgOBJ() {
	}
	public IllegalMsgOBJ(Has hasMsg, List<String> msgs) {

		this.hasMsg = hasMsg;
		this.msgs = msgs;
	}
	
	
	public Has getHasMsg() {
		return hasMsg;
	}
	public List<String> getMsgs() {
		return msgs;
	}
	
	
	public void setHasMsg(Has hasMsg) {
		this.hasMsg = hasMsg;
	}
	public void setMsgs(List<String> msgs) {
		this.msgs = msgs;
	}
}
