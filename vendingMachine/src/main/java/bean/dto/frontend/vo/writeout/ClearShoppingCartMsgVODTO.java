package bean.dto.frontend.vo.writeout;

import enumeration.Has;

public class ClearShoppingCartMsgVODTO {

	private Has success;

	public ClearShoppingCartMsgVODTO() {
	}
	public ClearShoppingCartMsgVODTO(Has success) {

		this.success = success;
	}
	
	
	public Has getSuccess() {
		return success;
	}
	
	
	public void setSuccess(Has success) {
		this.success = success;
	}
}
