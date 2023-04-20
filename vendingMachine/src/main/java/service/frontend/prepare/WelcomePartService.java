package service.frontend.prepare;

import java.io.File;

import bean.dto.frontend.vo.writeout.WelcomeMsgVODTO;
import bean.dto.frontend.vo.writeout.WelcomePartVODTO;
import bean.dto.model.MemberModelDTO;

public class WelcomePartService {

	public static final String WELCOME_IMAGE_PATH = "vending_machine.jpg";
	
	
	private static final WelcomePartService INSTANCE = new WelcomePartService();
	
	private WelcomePartService() {
	}
	
	public static WelcomePartService getInstance() {
		
		return INSTANCE;
	}
	
	public WelcomePartVODTO prepare(String imagesDirectorySymbolicLinkName, MemberModelDTO memberModelDTO) {
		
		WelcomePartVODTO welcomePartVODTO = new WelcomePartVODTO();
		
		welcomePartVODTO.setWelcomeImagePath(prepareWelcomeImagePath(imagesDirectorySymbolicLinkName));
		welcomePartVODTO.setWelcomeMsg(prepareWelcomeMsg(memberModelDTO));
		
		return welcomePartVODTO;
	}
	
	private String prepareWelcomeImagePath(String imagesDirectorySymbolicLinkName) {
		
		return imagesDirectorySymbolicLinkName + File.separator + WELCOME_IMAGE_PATH;
	}
	private WelcomeMsgVODTO prepareWelcomeMsg(MemberModelDTO memberModelDTO) {
		
		WelcomeMsgVODTO welcomeMsgVODTO = new WelcomeMsgVODTO();
		
		welcomeMsgVODTO.setCustomerName(memberModelDTO.getName());
		
		return welcomeMsgVODTO;
	}
}
