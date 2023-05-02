package service.frontend;

import bean.dto.virtualMachine.obj.memoryDAOKitVM.AccountOBJDTO;
import dao.memory.cache.frontend.ReceiptContentCacheDAO;
import dao.memory.memoryDb.frontend.ShoppingCartMemoryDbDAO;
import dao.virtualDevice.memoryDAOKit.MemoryDAOKitVMDAO;

public class GoBackendAjaxService {

	private ShoppingCartService shoppingCartService;
	private MemoryDAOKitVMDAO memoryDAOKitVMDAO;
	
	private static final GoBackendAjaxService INSTANCE = new GoBackendAjaxService();
	
	private GoBackendAjaxService() {
		
		shoppingCartService = ShoppingCartService.getInstance();
		memoryDAOKitVMDAO = MemoryDAOKitVMDAO.getInstance();
	}
	
	public static GoBackendAjaxService getInstance() {
		
		return INSTANCE;
	}
	
	public void clear(AccountOBJDTO accountOBJDTO) {
		
		ShoppingCartMemoryDbDAO shoppingCartMemoryDbDAO = memoryDAOKitVMDAO.getShoppingCartMemoryDbDAO(accountOBJDTO);
		ReceiptContentCacheDAO receiptContentCacheDAO = memoryDAOKitVMDAO.getReceiptContentCacheDAO(accountOBJDTO);
		
		shoppingCartService.clearShoppingCart(shoppingCartMemoryDbDAO);
		receiptContentCacheDAO.clearCache();
	}
}
