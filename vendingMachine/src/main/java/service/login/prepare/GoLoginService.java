package service.login.prepare;

import bean.dto.login.obj.statusCache.notLoginMsg.NotLoginMsgOBJDTO;
import bean.dto.login.vo.writeout.BackgroundVODTO;
import bean.dto.login.vo.writeout.LoginVODTO;
import bean.dto.login.vo.writeout.NotLoginMsgVODTO;
import bean.dto.virtualMachine.obj.memoryDAOKitVM.AccountOBJDTO;
import dao.memory.statusCache.login.NotLoginMsgStatusCacheDAO;
import dao.virtualDevice.memoryDAOKit.MemoryDAOKitVMDAO;
import util.StringConcatUtil;

public class GoLoginService {

	private static final String BACKGROUND_IMG_NAME = "background.jpg";
	
	
	private MemoryDAOKitVMDAO memoryDAOKitVMDAO;
	
	
	private static final GoLoginService INSTANCE = new GoLoginService();
	
	private GoLoginService() {
		
		memoryDAOKitVMDAO = MemoryDAOKitVMDAO.getInstance();
	}
	
	public static GoLoginService getInstance() {
		
		return INSTANCE;
	}
	
	public LoginVODTO prepare(AccountOBJDTO accountOBJDTO, String imagesDirectoryName) {
		
		NotLoginMsgStatusCacheDAO notLoginMsgStatusCacheDAO = memoryDAOKitVMDAO.getNotLoginMsgStatusCacheDAO(accountOBJDTO);
	
		LoginVODTO loginVODTO = new LoginVODTO();
		
		loginVODTO.setBackground(prepareBackground(imagesDirectoryName));
		loginVODTO.setNotLoginMsg(prepareNotLoginMsg(notLoginMsgStatusCacheDAO));
		
		return loginVODTO;
	}
	
	private BackgroundVODTO prepareBackground(String imagesDirectoryName) {
		
		BackgroundVODTO backgroundVODTO = new BackgroundVODTO();
		
		backgroundVODTO.setImagePath(StringConcatUtil.concate(imagesDirectoryName, "/", BACKGROUND_IMG_NAME));
		
		return backgroundVODTO;
	}
	private NotLoginMsgVODTO prepareNotLoginMsg(NotLoginMsgStatusCacheDAO notLoginMsgStatusCacheDAO) {
		
		NotLoginMsgOBJDTO notLoginMsgOBJDTO = notLoginMsgStatusCacheDAO.getStatus();

		NotLoginMsgVODTO notLoginMsgVODTO = new NotLoginMsgVODTO();
		
		if(notLoginMsgOBJDTO!=null && notLoginMsgOBJDTO.getHasMsg()) {
			
			notLoginMsgVODTO.setHasMsg(true);
			notLoginMsgStatusCacheDAO.clearStatus();
		}else {
			
			notLoginMsgVODTO.setHasMsg(false);
		}
		
		return notLoginMsgVODTO;
	}
}
