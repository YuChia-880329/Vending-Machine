package bean.dto.frontend.vo.writeout;

import java.util.List;

import enumeration.Has;

public class IllegalMsgVODTO {

	private Has hasMsg;
	private List<String> msgs;
	
	
	public IllegalMsgVODTO() {
	}
	public IllegalMsgVODTO(Has hasMsg, List<String> msgs) {

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
