package bean.dto.frontend.obj.memoryDb.clearShoppingCartMsg;

import enumeration.Has;

public class ClearShoppingCartMsgOBJDTO {

	private Has success;

	public ClearShoppingCartMsgOBJDTO() {
	}
	public ClearShoppingCartMsgOBJDTO(Has success) {

		this.success = success;
	}
	
	
	public Has getSuccess() {
		return success;
	}
	
	
	public void setSuccess(Has success) {
		this.success = success;
	}
}
