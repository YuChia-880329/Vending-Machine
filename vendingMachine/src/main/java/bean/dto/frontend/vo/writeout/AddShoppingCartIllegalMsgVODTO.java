package bean.dto.frontend.vo.writeout;

import java.util.List;

import enumeration.Has;

public class AddShoppingCartIllegalMsgVODTO {

	private Has hasMsg;
	private List<AddShoppingCartIllegalMsgLineVODTO> lines;
	
	
	public AddShoppingCartIllegalMsgVODTO() {
	}
	public AddShoppingCartIllegalMsgVODTO(Has hasMsg, List<AddShoppingCartIllegalMsgLineVODTO> lines) {

		this.hasMsg = hasMsg;
		this.lines = lines;
	}
	
	
	
	public Has getHasMsg() {
		return hasMsg;
	}
	public List<AddShoppingCartIllegalMsgLineVODTO> getLines() {
		return lines;
	}
	
	
	public void setHasMsg(Has hasMsg) {
		this.hasMsg = hasMsg;
	}
	public void setLines(List<AddShoppingCartIllegalMsgLineVODTO> lines) {
		this.lines = lines;
	}
}
