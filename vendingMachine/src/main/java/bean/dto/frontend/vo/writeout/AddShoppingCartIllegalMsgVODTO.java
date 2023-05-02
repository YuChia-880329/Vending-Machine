package bean.dto.frontend.vo.writeout;

import java.util.List;

public class AddShoppingCartIllegalMsgVODTO {

	private boolean hasMsg;
	private List<AddShoppingCartIllegalMsgLineVODTO> lines;
	
	
	public AddShoppingCartIllegalMsgVODTO() {
	}
	public AddShoppingCartIllegalMsgVODTO(boolean hasMsg, List<AddShoppingCartIllegalMsgLineVODTO> lines) {

		this.hasMsg = hasMsg;
		this.lines = lines;
	}
	
	
	
	public boolean getHasMsg() {
		return hasMsg;
	}
	public List<AddShoppingCartIllegalMsgLineVODTO> getLines() {
		return lines;
	}
	
	
	public void setHasMsg(boolean hasMsg) {
		this.hasMsg = hasMsg;
	}
	public void setLines(List<AddShoppingCartIllegalMsgLineVODTO> lines) {
		this.lines = lines;
	}
}
