package bean.obj.frontend.cache.clearShoppingCartMsgLine;

import enumeration.Has;

public class ClearShoppingCartMsgLineOBJ {

	private Has hasMsg;

	public ClearShoppingCartMsgLineOBJ() {
	}
	public ClearShoppingCartMsgLineOBJ(Has hasMsg) {

		this.hasMsg = hasMsg;
	}
	
	
	public Has getHasMsg() {
		return hasMsg;
	}
	
	
	public void setHasMsg(Has hasMsg) {
		this.hasMsg = hasMsg;
	}
}
