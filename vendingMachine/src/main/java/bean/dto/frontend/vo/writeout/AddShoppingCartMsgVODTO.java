package bean.dto.frontend.vo.writeout;

import java.util.List;

public class AddShoppingCartMsgVODTO {

	private boolean hasMsg;
	private List<AddShoppingCartMsgLineVODTO> lines;
	
	
	public AddShoppingCartMsgVODTO() {
	}
	public AddShoppingCartMsgVODTO(boolean hasMsg, List<AddShoppingCartMsgLineVODTO> lines) {

		this.hasMsg = hasMsg;
		this.lines = lines;
	}
	
	
	public boolean getHasMsg() {
		return hasMsg;
	}
	public List<AddShoppingCartMsgLineVODTO> getLines() {
		return lines;
	}
	
	
	public void setHasMsg(boolean hasMsg) {
		this.hasMsg = hasMsg;
	}
	public void setLines(List<AddShoppingCartMsgLineVODTO> lines) {
		this.lines = lines;
	}
}
