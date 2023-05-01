package bean.dto.frontend.obj.statusCache.clearShoppingCartMsgLine;

import enumeration.Has;

public class ClearShoppingCartMsgHasMsgOBJDTO {

	private Has hasMsg;

	public ClearShoppingCartMsgHasMsgOBJDTO() {
	}
	public ClearShoppingCartMsgHasMsgOBJDTO(Has hasMsg) {

		this.hasMsg = hasMsg;
	}
	
	
	public Has getHasMsg() {
		return hasMsg;
	}
	
	
	public void setHasMsg(Has hasMsg) {
		this.hasMsg = hasMsg;
	}
}
