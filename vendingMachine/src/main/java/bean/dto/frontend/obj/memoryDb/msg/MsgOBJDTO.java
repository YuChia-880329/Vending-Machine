package bean.dto.frontend.obj.memoryDb.msg;

import java.util.List;

import enumeration.Has;

public class MsgOBJDTO {

	private Has hasMsg;
	private List<String> lines;
	
	
	public MsgOBJDTO() {
	}
	public MsgOBJDTO(Has hasMsg, List<String> lines) {

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
	public void setLines(List<String> msgs) {
		this.lines = msgs;
	}
}
