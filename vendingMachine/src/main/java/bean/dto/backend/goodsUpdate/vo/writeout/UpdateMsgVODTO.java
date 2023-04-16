package bean.dto.backend.goodsUpdate.vo.writeout;

import enumeration.Has;

public class UpdateMsgVODTO {

	private String msg;

	public UpdateMsgVODTO() {
	}
	public UpdateMsgVODTO(String msg) {

		this.msg = msg;
	}
	
	
	public String getMsg() {
		return msg;
	}

	
	public void setMsg(String msg) {
		this.msg = msg;
	}
}
