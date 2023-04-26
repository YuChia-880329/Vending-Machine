package bean.dto.frontend.obj.cache.clearShoppingCartMsgLine;

import enumeration.Has;

public class ClearShoppingCartMsgLineOBJDTO {

	private Has hasMsg;

	public ClearShoppingCartMsgLineOBJDTO() {
	}
	public ClearShoppingCartMsgLineOBJDTO(Has hasMsg) {

		this.hasMsg = hasMsg;
	}
	
	
	public Has getHasMsg() {
		return hasMsg;
	}
	
	
	public void setHasMsg(Has hasMsg) {
		this.hasMsg = hasMsg;
	}
}
