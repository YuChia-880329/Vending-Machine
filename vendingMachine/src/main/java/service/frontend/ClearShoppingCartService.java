package service.frontend;

import bean.dto.frontend.obj.cache.clearShoppingCartMsgLine.ClearShoppingCartMsgLineOBJDTO;
import bean.dto.frontend.vo.readin.ClearShoppingCartVODTO;
import bean.dto.frontend.vo.writeout.ClearShoppingCartResultVODTO;
import dao.memory.cache.frontend.ClearShoppingCartMsgLineCacheDAO;
import dao.memory.memoryDb.frontend.ShoppingCartMemoryDbDAO;
import enumeration.Has;

public class ClearShoppingCartService {

	private static final ClearShoppingCartService INSTANCE = new ClearShoppingCartService();
	
	private ClearShoppingCartService() {
	}
	
	public static ClearShoppingCartService getInstance() {
		
		return INSTANCE;
	}
	
	public ClearShoppingCartResultVODTO clear(ClearShoppingCartVODTO clearShoppingCartVODTO, ShoppingCartMemoryDbDAO shoppingCartMemoryDbDAO, 
			ClearShoppingCartMsgLineCacheDAO clearShoppingCartMsgLineCacheDAO) {
		
		ClearShoppingCartResultVODTO clearShoppingCartResultVODTO = new ClearShoppingCartResultVODTO();
		
		shoppingCartMemoryDbDAO.deleteAll();
		clearShoppingCartMsgLineCacheDAO.save(new ClearShoppingCartMsgLineOBJDTO(Has.TRUE));
		
		clearShoppingCartResultVODTO.setQueryString(clearShoppingCartVODTO.getQueryString());
		
		return clearShoppingCartResultVODTO;
	}
}
