package bean.dto.frontend.vo.writeout;

import java.util.List;

public class AddShoppingCartLegalMsgVODTO {

	private boolean hasMsg;
	private List<AddShoppingCartLegalMsgLineVODTO> lines;
	
	
	public AddShoppingCartLegalMsgVODTO() {
	}
	public AddShoppingCartLegalMsgVODTO(boolean hasMsg, List<AddShoppingCartLegalMsgLineVODTO> lines) {

		this.hasMsg = hasMsg;
		this.lines = lines;
	}
	
	
	public boolean getHasMsg() {
		return hasMsg;
	}
	public List<AddShoppingCartLegalMsgLineVODTO> getLines() {
		return lines;
	}
	
	
	public void setHasMsg(boolean hasMsg) {
		this.hasMsg = hasMsg;
	}
	public void setLines(List<AddShoppingCartLegalMsgLineVODTO> lines) {
		this.lines = lines;
	}
}
