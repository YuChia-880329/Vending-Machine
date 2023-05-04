package service.frontend.prepare;

import bean.dto.frontend.vo.writeout.WelcomeMsgVODTO;
import bean.dto.frontend.vo.writeout.WelcomePartVODTO;
import bean.dto.obj.statusCache.currentMember.CurrentMemberOBJDTO;
import dao.memory.statusCache.CurrentMemberStatusCacheDAO;
import util.StringConcatUtil;

public class WelcomePartService {

	public static final String WELCOME_IMAGE_PATH = "vending_machine.jpg";
	
	
	private static final WelcomePartService INSTANCE = new WelcomePartService();
	
	private WelcomePartService() {
	}
	
	public static WelcomePartService getInstance() {
		
		return INSTANCE;
	}
	
	public WelcomePartVODTO prepare(String imagesDirectoryName, CurrentMemberStatusCacheDAO currentMemberStatusCacheDAO) {
		
		WelcomePartVODTO welcomePartVODTO = new WelcomePartVODTO();
		
		welcomePartVODTO.setWelcomeImagePath(prepareWelcomeImagePath(imagesDirectoryName));
		welcomePartVODTO.setWelcomeMsg(prepareWelcomeMsg(currentMemberStatusCacheDAO));
		
		return welcomePartVODTO;
	}
	
	private String prepareWelcomeImagePath(String imagesDirectoryName) {
		
		return StringConcatUtil.concate(imagesDirectoryName, "/", WELCOME_IMAGE_PATH);
	}
	private WelcomeMsgVODTO prepareWelcomeMsg(CurrentMemberStatusCacheDAO currentMemberStatusCacheDAO) {
		
		CurrentMemberOBJDTO currentMemberOBJDTO = currentMemberStatusCacheDAO.getStatus();
		
		WelcomeMsgVODTO welcomeMsgVODTO = new WelcomeMsgVODTO();
		
		welcomeMsgVODTO.setCustomerName(currentMemberOBJDTO.getName());
		
		return welcomeMsgVODTO;
	}
}
