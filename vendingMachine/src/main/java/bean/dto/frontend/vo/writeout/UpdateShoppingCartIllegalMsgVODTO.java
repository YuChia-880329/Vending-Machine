package bean.dto.frontend.vo.writeout;

import java.util.List;

public class UpdateShoppingCartIllegalMsgVODTO {

	private boolean hasMsg;
	private List<UpdateShoppingCartIllegalMsgLineVODTO> lines;
	
	
	public UpdateShoppingCartIllegalMsgVODTO() {
	}
	public UpdateShoppingCartIllegalMsgVODTO(boolean hasMsg, List<UpdateShoppingCartIllegalMsgLineVODTO> lines) {

		this.hasMsg = hasMsg;
		this.lines = lines;
	}
	
	
	
	public boolean getHasMsg() {
		return hasMsg;
	}
	public List<UpdateShoppingCartIllegalMsgLineVODTO> getLines() {
		return lines;
	}
	
	
	public void setHasMsg(boolean hasMsg) {
		this.hasMsg = hasMsg;
	}
	public void setLines(List<UpdateShoppingCartIllegalMsgLineVODTO> lines) {
		this.lines = lines;
	}
}
