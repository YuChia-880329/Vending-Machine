package bean.dto.frontend.obj.memoryDb.illegalMsg;

import java.util.List;

import enumeration.Has;

public class IllegalMsgOBJDTO {

	private Has hasMsg;
	private List<String> msgs;
	
	
	public IllegalMsgOBJDTO() {
	}
	public IllegalMsgOBJDTO(Has hasMsg, List<String> msgs) {

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
