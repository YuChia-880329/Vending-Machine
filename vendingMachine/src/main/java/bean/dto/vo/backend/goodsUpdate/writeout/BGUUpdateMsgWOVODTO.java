package bean.dto.vo.backend.goodsUpdate.writeout;

import enumeration.Has;

public class BGUUpdateMsgWOVODTO {

	private Has hasMsg;

	public BGUUpdateMsgWOVODTO() {
	}
	public BGUUpdateMsgWOVODTO(Has hasMsg) {

		this.hasMsg = hasMsg;
	}
	
	
	public Has getHasMsg() {
		return hasMsg;
	}
	
	
	public void setHasMsg(Has hasMsg) {
		this.hasMsg = hasMsg;
	}
}
