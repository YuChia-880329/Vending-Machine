package service.frontend;

import bean.dto.frontend.ClearShoppingCartResultDTO;
import bean.dto.frontend.obj.statusCache.clearShoppingCartMsgLine.ClearShoppingCartMsgHasMsgOBJDTO;
import bean.dto.frontend.vo.readin.ClearShoppingCartVODTO;
import dao.memory.memoryDb.frontend.ShoppingCartMemoryDbDAO;
import dao.memory.statusCache.frontend.ClearShoppingCartMsgStatusCacheDAO;
import enumeration.Has;

public class ClearShoppingCartService {

	private static final ClearShoppingCartService INSTANCE = new ClearShoppingCartService();
	
	private ClearShoppingCartService() {
	}
	
	public static ClearShoppingCartService getInstance() {
		
		return INSTANCE;
	}
	
	public ClearShoppingCartResultDTO clear(ClearShoppingCartVODTO clearShoppingCartVODTO, ShoppingCartMemoryDbDAO shoppingCartMemoryDbDAO, 
			ClearShoppingCartMsgStatusCacheDAO clearShoppingCartMsgLineCacheDAO) {
		
		ClearShoppingCartResultDTO clearShoppingCartResultDTO = new ClearShoppingCartResultDTO();
		
		shoppingCartMemoryDbDAO.deleteAll();
		clearShoppingCartMsgLineCacheDAO.save(new ClearShoppingCartMsgHasMsgOBJDTO(Has.TRUE));
		
		clearShoppingCartResultDTO.setQueryString(clearShoppingCartVODTO.getQueryString());
		
		return clearShoppingCartResultDTO;
	}
}
