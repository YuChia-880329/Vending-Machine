package service.frontend;

import bean.dto.frontend.ClearShoppingCartResultDTO;
import bean.dto.frontend.obj.cache.clearShoppingCartMsgLine.ClearShoppingCartMsgLineOBJDTO;
import bean.dto.frontend.vo.readin.ClearShoppingCartVODTO;
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
	
	public ClearShoppingCartResultDTO clear(ClearShoppingCartVODTO clearShoppingCartVODTO, ShoppingCartMemoryDbDAO shoppingCartMemoryDbDAO, 
			ClearShoppingCartMsgLineCacheDAO clearShoppingCartMsgLineCacheDAO) {
		
		ClearShoppingCartResultDTO clearShoppingCartResultDTO = new ClearShoppingCartResultDTO();
		
		shoppingCartMemoryDbDAO.deleteAll();
		clearShoppingCartMsgLineCacheDAO.save(new ClearShoppingCartMsgLineOBJDTO(Has.TRUE));
		
		clearShoppingCartResultDTO.setQueryString(clearShoppingCartVODTO.getQueryString());
		
		return clearShoppingCartResultDTO;
	}
}
