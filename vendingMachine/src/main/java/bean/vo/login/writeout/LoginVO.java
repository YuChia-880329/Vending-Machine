package bean.vo.login.writeout;

public class LoginVO {

	private BackgroundVO background;
	private NotLoginMsgVO notLoginMsg;

	public LoginVO() {
	}
	public LoginVO(BackgroundVO background, NotLoginMsgVO notLoginMsg) {

		this.notLoginMsg = notLoginMsg;
	}
	
	
	
	public BackgroundVO getBackground() {
		return background;
	}
	public NotLoginMsgVO getNotLoginMsg() {
		return notLoginMsg;
	}
	
	
	public void setBackground(BackgroundVO background) {
		this.background = background;
	}
	public void setNotLoginMsg(NotLoginMsgVO notLoginMsg) {
		this.notLoginMsg = notLoginMsg;
	}
}
