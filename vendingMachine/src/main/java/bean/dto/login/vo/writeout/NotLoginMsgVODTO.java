package bean.dto.login.vo.writeout;

public class NotLoginMsgVODTO {

	private boolean hasMsg;

	public NotLoginMsgVODTO() {
	}
	public NotLoginMsgVODTO(boolean hasMsg) {

		this.hasMsg = hasMsg;
	}
	
	
	public boolean getHasMsg() {
		return hasMsg;
	}
	
	public void setHasMsg(boolean hasMsg) {
		this.hasMsg = hasMsg;
	}
}
