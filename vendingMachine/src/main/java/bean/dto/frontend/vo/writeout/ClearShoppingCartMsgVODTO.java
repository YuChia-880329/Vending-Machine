package bean.dto.frontend.vo.writeout;

public class ClearShoppingCartMsgVODTO {

	private boolean hasMsg;

	public ClearShoppingCartMsgVODTO() {
	}
	public ClearShoppingCartMsgVODTO(boolean hasMsg) {

		this.hasMsg = hasMsg;
	}
	
	
	public boolean getHasMsg() {
		return hasMsg;
	}
	
	
	public void setHasMsg(boolean hasMsg) {
		this.hasMsg = hasMsg;
	}
}
