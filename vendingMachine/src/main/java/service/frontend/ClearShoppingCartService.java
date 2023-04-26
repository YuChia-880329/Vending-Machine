package service.frontend;

import bean.dto.frontend.obj.cache.clearShoppingCartMsg.ClearShoppingCartMsgOBJDTO;
import bean.dto.frontend.vo.readin.ClearShoppingCartVODTO;
import bean.dto.frontend.vo.writeout.ClearShoppingCartResultVODTO;
import dao.memory.cache.frontend.ClearShoppingCartMsgCacheDAO;
import dao.memory.memoryDb.frontend.ShoppingCartMemoryDbDAO;
import enumeration.Has;

public class ClearShoppingCartService {

	private static final ClearShoppingCartService INSTANCE = new ClearShoppingCartService();
	
	private ClearShoppingCartService() {
	}
	
	public static ClearShoppingCartService getInstance() {
		
		return INSTANCE;
	}
	
	public ClearShoppingCartResultVODTO clear(ClearShoppingCartVODTO clearShoppingCartVODTO, ShoppingCartMemoryDbDAO shoppingCartMemoryDbDAO, ClearShoppingCartMsgCacheDAO clearShoppingCartMsgCacheDAO) {
		
		ClearShoppingCartResultVODTO clearShoppingCartResultVODTO = new ClearShoppingCartResultVODTO();
		
		shoppingCartMemoryDbDAO.deleteAll();
		clearShoppingCartMsgCacheDAO.save(new ClearShoppingCartMsgOBJDTO(Has.TRUE));
		
		clearShoppingCartResultVODTO.setQueryString(clearShoppingCartVODTO.getQueryString());
		
		return clearShoppingCartResultVODTO;
	}
}
