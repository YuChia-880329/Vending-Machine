package service.frontend;

import bean.dto.virtualMachine.obj.memoryDAOKitVM.AccountOBJDTO;
import dao.memory.cache.frontend.ReceiptContentCacheDAO;
import dao.memory.memoryDb.frontend.ShoppingCartMemoryDbDAO;
import dao.memory.statusCache.login.CurrentMemberStatusCacheDAO;
import dao.virtualDevice.memoryDAOKit.MemoryDAOKitVMDAO;

public class LogoutService {

	private MemoryDAOKitVMDAO memoryDAOKitVMDAO;
	
	
	private static final LogoutService INSTANCE = new LogoutService();
	
	private LogoutService() {
		
		memoryDAOKitVMDAO = MemoryDAOKitVMDAO.getInstance();
	}
	
	public static LogoutService getInstance() {
		
		return INSTANCE;
	}
	
	public void logout(AccountOBJDTO accountOBJDTO) {
		
		CurrentMemberStatusCacheDAO currentMemberStatusCacheDAO = memoryDAOKitVMDAO.getCurrentMemberStatusCacheDAO(accountOBJDTO);
		ShoppingCartMemoryDbDAO shoppingCartMemoryDbDAO = memoryDAOKitVMDAO.getShoppingCartMemoryDbDAO(accountOBJDTO);
		ReceiptContentCacheDAO receiptContentCacheDAO = memoryDAOKitVMDAO.getReceiptContentCacheDAO(accountOBJDTO);
		
		currentMemberStatusCacheDAO.clearStatus();
		shoppingCartMemoryDbDAO.deleteAll();
		receiptContentCacheDAO.clearCache();
	}
}
