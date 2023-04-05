package bean.dto.vo.backend.goodsCreate.writeout;

import enumeration.Has;

public class BGCCreateMsgWOVODTO {

	private Has hasMessage;
	private int id;

	
	public BGCCreateMsgWOVODTO() {
	}
	public BGCCreateMsgWOVODTO(Has hasMessage, int id) {

		this.hasMessage = hasMessage;
		this.id = id;
	}
	
	
	public Has getHasMessage() {
		return hasMessage;
	}
	public int getId() {
		return id;
	}
	
	
	public void setHasMessage(Has hasMessage) {
		this.hasMessage = hasMessage;
	}
	public void setId(int id) {
		this.id = id;
	}
}
