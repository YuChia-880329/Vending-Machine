package bean.obj.frontend.cache.clearShoppingCartMsg;

import enumeration.Has;

public class ClearShoppingCartMsgOBJ {

	private Has hasMsg;

	public ClearShoppingCartMsgOBJ() {
	}
	public ClearShoppingCartMsgOBJ(Has hasMsg) {

		this.hasMsg = hasMsg;
	}
	
	
	public Has getHasMsg() {
		return hasMsg;
	}
	
	
	public void setHasMsg(Has hasMsg) {
		this.hasMsg = hasMsg;
	}
}
