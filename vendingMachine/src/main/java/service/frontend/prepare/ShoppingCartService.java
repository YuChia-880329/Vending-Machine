package service.frontend.prepare;

import bean.dto.frontend.vo.writeout.ShoppingCartVODTO;
import dao.memory.memoryDb.frontend.ShoppingCartMemoryDbDAO;

public class ShoppingCartService {

	private ShoppingCartGoodsListService shoppingCartGoodsListService;
	
	
	private static final ShoppingCartService INSTANCE = new ShoppingCartService();
	
	private ShoppingCartService() {
		
		shoppingCartGoodsListService = ShoppingCartGoodsListService.getInstance();
	}
	
	public static ShoppingCartService getInstance() {
		
		return INSTANCE;
	}
	
	public ShoppingCartVODTO prepare(ShoppingCartMemoryDbDAO shoppingCartMemoryDbDAO) {
		
		ShoppingCartVODTO shoppingCartVODTO = new ShoppingCartVODTO();
		
		shoppingCartVODTO.setShoppingCartGoodsList(shoppingCartGoodsListService.prepare(shoppingCartMemoryDbDAO));
		
		return shoppingCartVODTO;
	}
}
