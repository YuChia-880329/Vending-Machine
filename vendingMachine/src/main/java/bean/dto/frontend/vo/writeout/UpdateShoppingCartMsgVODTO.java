package bean.dto.frontend.vo.writeout;

import java.util.List;

import enumeration.Has;

public class UpdateShoppingCartMsgVODTO {

	private Has hasMsg;
	private List<UpdateShoppingCartMsgLineVODTO> lines;
	
	
	public UpdateShoppingCartMsgVODTO() {
	}
	public UpdateShoppingCartMsgVODTO(Has hasMsg, List<UpdateShoppingCartMsgLineVODTO> lines) {

		this.hasMsg = hasMsg;
		this.lines = lines;
	}
	
	
	public Has getHasMsg() {
		return hasMsg;
	}
	public List<UpdateShoppingCartMsgLineVODTO> getLines() {
		return lines;
	}
	
	
	
	
	public void setHasMsg(Has hasMsg) {
		this.hasMsg = hasMsg;
	}
	public void setLines(List<UpdateShoppingCartMsgLineVODTO> lines) {
		this.lines = lines;
	}
}
