package bean.obj.frontend.memoryDb.msg;

import java.util.List;

import enumeration.Has;

public class MsgOBJ {

	private Has hasMsg;
	private List<String> lines;
	
	
	public MsgOBJ() {
	}
	public MsgOBJ(Has hasMsg, List<String> lines) {

		this.hasMsg = hasMsg;
		this.lines = lines;
	}
	
	
	public Has getHasMsg() {
		return hasMsg;
	}
	public List<String> getLines() {
		return lines;
	}
	
	
	public void setHasMsg(Has hasMsg) {
		this.hasMsg = hasMsg;
	}
	public void setLines(List<String> lines) {
		this.lines = lines;
	}
}
