package util;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import bean.dto.virtualMachine.obj.memoryDAOKitVM.AccountOBJDTO;
import dao.virtualDevice.memoryDAOKit.MemoryDAOKitVMDAO;

public class ServletUtil {

	public static Map<String, String> getRequestBodyMap(String requestBodyStr){
		
		String[] strs = requestBodyStr.trim().split("&");
		
		Map<String, String> map = new HashMap<>();
		for(String str : strs) {
			
			String[] pair = str.split("=");
			map.put(pair[0], pair[1]);
		}
		
		return map;
	}
	
	public static AccountOBJDTO getAccount(HttpSession session){
		
		AccountOBJDTO accountOBJDTO = (AccountOBJDTO)session.getAttribute(MemoryDAOKitVMDAO.SESSION_ATTR_ACCOUNT);
		
		if(accountOBJDTO == null) {
			
			accountOBJDTO = getNewAccount();
			session.setAttribute(MemoryDAOKitVMDAO.SESSION_ATTR_ACCOUNT, accountOBJDTO);
		}
		
		return accountOBJDTO;
	}
	
	
	private static AccountOBJDTO getNewAccount() {
		
		AccountOBJDTO accountOBJDTO = new AccountOBJDTO();
		
		String account = StringConcatUtil.concate(DateTimeUtil.localDateTimeToString(LocalDateTime.now()), UUID.randomUUID().toString());
		
		accountOBJDTO.setAccount(account);
		
		return accountOBJDTO;
	}
	
}
