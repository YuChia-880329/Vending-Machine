package bean.dto.frontend.vo.writeout;

import java.util.List;

import enumeration.Has;

public class MsgVODTO {

	private Has hasMsg;
	private List<String> lines;
	
	
	public MsgVODTO() {
	}
	public MsgVODTO(Has hasMsg, List<String> lines) {

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
