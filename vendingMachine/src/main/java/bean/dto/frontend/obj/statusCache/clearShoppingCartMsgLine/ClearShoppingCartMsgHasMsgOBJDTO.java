package bean.dto.frontend.obj.statusCache.clearShoppingCartMsgLine;

public class ClearShoppingCartMsgHasMsgOBJDTO {

	private boolean hasMsg;

	public ClearShoppingCartMsgHasMsgOBJDTO() {
	}
	public ClearShoppingCartMsgHasMsgOBJDTO(boolean hasMsg) {

		this.hasMsg = hasMsg;
	}
	
	
	public boolean getHasMsg() {
		return hasMsg;
	}
	
	
	public void setHasMsg(boolean hasMsg) {
		this.hasMsg = hasMsg;
	}
}
