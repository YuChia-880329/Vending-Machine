package bean.dto.frontend.obj.cache.clearShoppingCartMsg;

import enumeration.Has;

public class ClearShoppingCartMsgOBJDTO {

	private Has hasMsg;

	public ClearShoppingCartMsgOBJDTO() {
	}
	public ClearShoppingCartMsgOBJDTO(Has hasMsg) {

		this.hasMsg = hasMsg;
	}
	
	
	public Has getHasMsg() {
		return hasMsg;
	}
	
	
	public void setHasMsg(Has hasMsg) {
		this.hasMsg = hasMsg;
	}
}
