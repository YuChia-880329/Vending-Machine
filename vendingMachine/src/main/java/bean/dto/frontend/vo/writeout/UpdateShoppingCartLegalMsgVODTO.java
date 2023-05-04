package bean.dto.frontend.vo.writeout;

import java.util.List;

public class UpdateShoppingCartLegalMsgVODTO {

	private boolean hasMsg;
	private List<UpdateShoppingCartLegalMsgLineVODTO> lines;
	
	
	public UpdateShoppingCartLegalMsgVODTO() {
	}
	public UpdateShoppingCartLegalMsgVODTO(boolean hasMsg, List<UpdateShoppingCartLegalMsgLineVODTO> lines) {

		this.hasMsg = hasMsg;
		this.lines = lines;
	}
	
	
	public boolean getHasMsg() {
		return hasMsg;
	}
	public List<UpdateShoppingCartLegalMsgLineVODTO> getLines() {
		return lines;
	}
	
	
	
	
	public void setHasMsg(boolean hasMsg) {
		this.hasMsg = hasMsg;
	}
	public void setLines(List<UpdateShoppingCartLegalMsgLineVODTO> lines) {
		this.lines = lines;
	}
}
