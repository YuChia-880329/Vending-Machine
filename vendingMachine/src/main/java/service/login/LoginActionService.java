package service.login;

import java.sql.SQLException;

import bean.dto.login.obj.statusCache.currentMember.CurrentMemberOBJDTO;
import bean.dto.login.vo.readin.LoginFormVODTO;
import bean.dto.login.vo.readin.LoginActionVODTO;
import bean.dto.login.vo.writeout.LoginResultVODTO;
import bean.dto.model.MemberModelDTO;
import bean.dto.virtualMachine.obj.memoryDAOKitVM.AccountOBJDTO;
import dao.memory.statusCache.login.CurrentMemberStatusCacheDAO;
import dao.virtualDevice.memoryDAOKit.MemoryDAOKitVMDAO;
import service.model.MemberModelService;

public class LoginActionService {

	private MemoryDAOKitVMDAO memoryDAOKitVMDAO;
	private MemberModelService memberModelService;
	
	
	private static final LoginActionService INSTANCE = new LoginActionService();
	
	private LoginActionService() {
		
		memoryDAOKitVMDAO = MemoryDAOKitVMDAO.getInstance();
		memberModelService = MemberModelService.getInstance();
	}
	
	public static LoginActionService getInstance() {
		
		return INSTANCE;
	}
	
	
	public LoginResultVODTO login(LoginActionVODTO loginActionVODTO, AccountOBJDTO accountOBJDTO) {
		
		CurrentMemberStatusCacheDAO currentMemberStatusCacheDAO = memoryDAOKitVMDAO.getCurrentMemberStatusCacheDAO(accountOBJDTO);
		
		LoginFormVODTO loginFormVODTO = loginActionVODTO.getLoginForm();
		LoginResultVODTO loginResultDTO = new LoginResultVODTO();
		try {
			
			MemberModelDTO memberModelDTO = memberModelService.searchById(loginFormVODTO.getAccount());
			if(memberModelDTO != null) {
				
				loginResultDTO.setHasAccount(true);
				String password = loginFormVODTO.getPassword();
				if(password!=null && password.equals(memberModelDTO.getPw())) {
					
					loginResultDTO.setPasswordCorrect(true);
					
					CurrentMemberOBJDTO currentMemberOBJDTO = new CurrentMemberOBJDTO();
					currentMemberOBJDTO.setId(loginFormVODTO.getAccount());
					currentMemberOBJDTO.setName(memberModelDTO.getName());
					currentMemberStatusCacheDAO.setStatus(currentMemberOBJDTO);
				}else {
					
					loginResultDTO.setPasswordCorrect(false);
					currentMemberStatusCacheDAO.clearStatus();
				}
			}else {
				
				loginResultDTO.setHasAccount(false);
				currentMemberStatusCacheDAO.clearStatus();
			}
			
			return loginResultDTO;
		} catch (SQLException ex) {
			
			ex.printStackTrace();
		}
		
		return null;
	}
}
