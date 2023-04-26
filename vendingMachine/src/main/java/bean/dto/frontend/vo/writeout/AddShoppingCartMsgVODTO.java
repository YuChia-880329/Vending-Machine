package bean.dto.frontend.vo.writeout;

import java.util.List;

import enumeration.Has;

public class AddShoppingCartMsgVODTO {

	private Has hasMsg;
	private List<AddShoppingCartMsgLineVODTO> lines;
	
	
	public AddShoppingCartMsgVODTO() {
	}
	public AddShoppingCartMsgVODTO(Has hasMsg, List<AddShoppingCartMsgLineVODTO> lines) {

		this.hasMsg = hasMsg;
		this.lines = lines;
	}
	
	
	public Has getHasMsg() {
		return hasMsg;
	}
	public void setHasMsg(Has hasMsg) {
		this.hasMsg = hasMsg;
	}
	
	
	public List<AddShoppingCartMsgLineVODTO> getLines() {
		return lines;
	}
	public void setLines(List<AddShoppingCartMsgLineVODTO> lines) {
		this.lines = lines;
	}
}
