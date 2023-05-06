package service.frontend;

import bean.dto.virtualMachine.obj.memoryDAOKitVM.AccountOBJDTO;
import dao.memory.cache.frontend.ReceiptContentCacheDAO;
import dao.memory.memoryDb.frontend.ShoppingCartMemoryDbDAO;
import dao.virtualDevice.memoryDAOKit.MemoryDAOKitVMDAO;

public class GoBackendService {

	private MemoryDAOKitVMDAO memoryDAOKitVMDAO;
	
	private static final GoBackendService INSTANCE = new GoBackendService();
	
	private GoBackendService() {
		
		memoryDAOKitVMDAO = MemoryDAOKitVMDAO.getInstance();
	}
	
	public static GoBackendService getInstance() {
		
		return INSTANCE;
	}
	
	public void clear(AccountOBJDTO accountOBJDTO) {
		
		ShoppingCartMemoryDbDAO shoppingCartMemoryDbDAO = memoryDAOKitVMDAO.getShoppingCartMemoryDbDAO(accountOBJDTO);
		ReceiptContentCacheDAO receiptContentCacheDAO = memoryDAOKitVMDAO.getReceiptContentCacheDAO(accountOBJDTO);
		
		shoppingCartMemoryDbDAO.deleteAll();
		receiptContentCacheDAO.clearCache();
	}
}
