package bean.dto.frontend.vo.writeout;

import java.util.List;

import enumeration.Has;

public class UpdateShoppingCartIllegalMsgVODTO {

	private Has hasMsg;
	private List<UpdateShoppingCartIllegalMsgLineVODTO> lines;
	
	
	public UpdateShoppingCartIllegalMsgVODTO() {
	}
	public UpdateShoppingCartIllegalMsgVODTO(Has hasMsg, List<UpdateShoppingCartIllegalMsgLineVODTO> lines) {

		this.hasMsg = hasMsg;
		this.lines = lines;
	}
	
	
	
	public Has getHasMsg() {
		return hasMsg;
	}
	public List<UpdateShoppingCartIllegalMsgLineVODTO> getLines() {
		return lines;
	}
	
	
	public void setHasMsg(Has hasMsg) {
		this.hasMsg = hasMsg;
	}
	public void setLines(List<UpdateShoppingCartIllegalMsgLineVODTO> lines) {
		this.lines = lines;
	}
}
