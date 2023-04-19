package bean.vo.frontend.writeout;

public class WelcomePartVO {

	private String welcomeImagePath;
	private WelcomeMsgVO welcomeMsg;
	
	
	public WelcomePartVO() {
	}
	public WelcomePartVO(String welcomeImagePath, WelcomeMsgVO welcomeMsg) {

		this.welcomeImagePath = welcomeImagePath;
		this.welcomeMsg = welcomeMsg;
	}
	
	
	public String getWelcomeImagePath() {
		return welcomeImagePath;
	}
	public WelcomeMsgVO getWelcomeMsg() {
		return welcomeMsg;
	}
	
	public void setWelcomeImagePath(String welcomeImagePath) {
		this.welcomeImagePath = welcomeImagePath;
	}
	public void setWelcomeMsg(WelcomeMsgVO welcomeMsg) {
		this.welcomeMsg = welcomeMsg;
	}
}
