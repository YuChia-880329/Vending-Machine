package bean.obj.frontend.memoryDb.clearShoppingCartMsg;

import enumeration.Has;

public class ClearShoppingCartMsgOBJ {

	private Has success;

	public ClearShoppingCartMsgOBJ() {
	}
	public ClearShoppingCartMsgOBJ(Has success) {

		this.success = success;
	}
	
	
	public Has getSuccess() {
		return success;
	}
	
	
	public void setSuccess(Has success) {
		this.success = success;
	}
}
