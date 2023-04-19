package bean.dto.frontend.vo.writeout;

public class WelcomePartVODTO {

	private String welcomeImagePath;
	private WelcomeMsgVODTO welcomeMsg;
	
	
	public WelcomePartVODTO() {
	}
	public WelcomePartVODTO(String welcomeImagePath, WelcomeMsgVODTO welcomeMsg) {

		this.welcomeImagePath = welcomeImagePath;
		this.welcomeMsg = welcomeMsg;
	}
	
	
	public String getWelcomeImagePath() {
		return welcomeImagePath;
	}
	public WelcomeMsgVODTO getWelcomeMsg() {
		return welcomeMsg;
	}
	
	
	public void setWelcomeImagePath(String welcomeImagePath) {
		this.welcomeImagePath = welcomeImagePath;
	}
	public void setWelcomeMsg(WelcomeMsgVODTO welcomeMsg) {
		this.welcomeMsg = welcomeMsg;
	}
}
