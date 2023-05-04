package bean.dto.login.obj.statusCache.notLoginMsg;

public class NotLoginMsgOBJDTO {

	private boolean hasMsg;

	public NotLoginMsgOBJDTO() {
	}
	public NotLoginMsgOBJDTO(boolean hasMsg) {

		this.hasMsg = hasMsg;
	}
	
	
	public boolean getHasMsg() {
		return hasMsg;
	}
	
	
	public void setHasMsg(boolean hasMsg) {
		this.hasMsg = hasMsg;
	}
}
