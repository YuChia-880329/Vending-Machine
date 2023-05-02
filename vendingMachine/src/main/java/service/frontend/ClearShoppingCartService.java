package service.frontend;

import bean.dto.frontend.ClearShoppingCartResultDTO;
import bean.dto.frontend.obj.statusCache.clearShoppingCartMsgLine.ClearShoppingCartMsgHasMsgOBJDTO;
import bean.dto.frontend.vo.readin.ClearShoppingCartVODTO;
import bean.dto.virtualMachine.obj.memoryDAOKitVM.AccountOBJDTO;
import dao.memory.memoryDb.frontend.ShoppingCartMemoryDbDAO;
import dao.memory.statusCache.frontend.ClearShoppingCartMsgStatusCacheDAO;
import dao.virtualDevice.memoryDAOKit.MemoryDAOKitVMDAO;

public class ClearShoppingCartService {

	private ShoppingCartService shoppingCartService;
	private MemoryDAOKitVMDAO memoryDAOKitVMDAO;

	
	private static final ClearShoppingCartService INSTANCE = new ClearShoppingCartService();
	
	private ClearShoppingCartService() {
		
		shoppingCartService = ShoppingCartService.getInstance();
		memoryDAOKitVMDAO = MemoryDAOKitVMDAO.getInstance();
	}
	
	public static ClearShoppingCartService getInstance() {
		
		return INSTANCE;
	}
	
	public ClearShoppingCartResultDTO clear(ClearShoppingCartVODTO clearShoppingCartVODTO, AccountOBJDTO accountOBJDTO) {
		
		ShoppingCartMemoryDbDAO shoppingCartMemoryDbDAO = memoryDAOKitVMDAO.getShoppingCartMemoryDbDAO(accountOBJDTO);
		ClearShoppingCartMsgStatusCacheDAO clearShoppingCartMsgStatusCacheDAO = memoryDAOKitVMDAO.getClearShoppingCartMsgStatusCacheDAO(accountOBJDTO);
		
		ClearShoppingCartResultDTO clearShoppingCartResultDTO = new ClearShoppingCartResultDTO();
		
		shoppingCartService.clearShoppingCart(shoppingCartMemoryDbDAO);
		
		clearShoppingCartMsgStatusCacheDAO.setStatus(new ClearShoppingCartMsgHasMsgOBJDTO(true));
		
		clearShoppingCartResultDTO.setQueryString(clearShoppingCartVODTO.getQueryString());
		
		return clearShoppingCartResultDTO;
	}
}
