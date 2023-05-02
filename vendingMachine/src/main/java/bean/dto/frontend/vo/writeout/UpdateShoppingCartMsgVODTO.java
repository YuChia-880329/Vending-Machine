package bean.dto.frontend.vo.writeout;

import java.util.List;

public class UpdateShoppingCartMsgVODTO {

	private boolean hasMsg;
	private List<UpdateShoppingCartMsgLineVODTO> lines;
	
	
	public UpdateShoppingCartMsgVODTO() {
	}
	public UpdateShoppingCartMsgVODTO(boolean hasMsg, List<UpdateShoppingCartMsgLineVODTO> lines) {

		this.hasMsg = hasMsg;
		this.lines = lines;
	}
	
	
	public boolean getHasMsg() {
		return hasMsg;
	}
	public List<UpdateShoppingCartMsgLineVODTO> getLines() {
		return lines;
	}
	
	
	
	
	public void setHasMsg(boolean hasMsg) {
		this.hasMsg = hasMsg;
	}
	public void setLines(List<UpdateShoppingCartMsgLineVODTO> lines) {
		this.lines = lines;
	}
}
