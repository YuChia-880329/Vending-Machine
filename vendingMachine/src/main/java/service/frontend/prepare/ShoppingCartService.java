package service.frontend.prepare;

import java.util.List;

import bean.dto.frontend.vo.writeout.ShoppingCartGoodsVODTO;
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
		
		List<ShoppingCartGoodsVODTO> shoppingCartGoodsVODTOs = shoppingCartGoodsListService.prepare(shoppingCartMemoryDbDAO);
		
		shoppingCartVODTO.setGoodsCount(shoppingCartGoodsVODTOs.size());
		shoppingCartVODTO.setShoppingCartGoodsList(shoppingCartGoodsVODTOs);
		
		return shoppingCartVODTO;
	}
}
