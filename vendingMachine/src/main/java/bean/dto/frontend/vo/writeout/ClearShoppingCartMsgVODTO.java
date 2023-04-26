package bean.dto.frontend.vo.writeout;

import enumeration.Has;

public class ClearShoppingCartMsgVODTO {

	private Has hasMsg;

	public ClearShoppingCartMsgVODTO() {
	}
	public ClearShoppingCartMsgVODTO(Has hasMsg) {

		this.hasMsg = hasMsg;
	}
	
	
	public Has getHasMsg() {
		return hasMsg;
	}
	
	
	public void setHasMsg(Has hasMsg) {
		this.hasMsg = hasMsg;
	}
}
