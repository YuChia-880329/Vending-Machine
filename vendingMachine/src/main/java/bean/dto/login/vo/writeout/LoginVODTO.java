package bean.dto.login.vo.writeout;

public class LoginVODTO {

	private BackgroundVODTO background;
	private NotLoginMsgVODTO notLoginMsg;

	public LoginVODTO() {
	}
	public LoginVODTO(BackgroundVODTO background, NotLoginMsgVODTO notLoginMsg) {

		this.background = background;
		this.notLoginMsg = notLoginMsg;
	}
	
	
	public BackgroundVODTO getBackground() {
		return background;
	}
	public NotLoginMsgVODTO getNotLoginMsg() {
		return notLoginMsg;
	}
	
	
	
	public void setBackground(BackgroundVODTO background) {
		this.background = background;
	}
	public void setNotLoginMsg(NotLoginMsgVODTO notLoginMsg) {
		this.notLoginMsg = notLoginMsg;
	}
}
