package service.frontend;

import java.util.function.Function;

import bean.dto.frontend.obj.memoryDb.shoppingCart.ShoppingCartOBJDTO;
import dao.memory.memoryDb.frontend.ShoppingCartMemoryDbDAO;

public class ShoppingCartService {

	private static final ShoppingCartService INSTANCE = new ShoppingCartService();
	
	private ShoppingCartService() {
	}
	
	public static ShoppingCartService getInstance() {
		
		return INSTANCE;
	}
	
	public boolean isLegal(int id, int quantity, Function<ShoppingCartOBJDTO, Integer> buyQuantityFctn, ShoppingCartMemoryDbDAO shoppingCartMemoryDbDAO) {
		
		ShoppingCartOBJDTO shoppingCartOBJDTO = shoppingCartMemoryDbDAO.searchByPk(id);
		
		int buyQuantity = buyQuantityFctn.apply(shoppingCartOBJDTO);
		return (buyQuantity <= quantity);
	}
	public void saveShoppingCartGoods(int id, Function<ShoppingCartOBJDTO, Integer> buyQuantityFctn, ShoppingCartMemoryDbDAO shoppingCartMemoryDbDAO) {
		
		ShoppingCartOBJDTO shoppingCartOBJDTO = shoppingCartMemoryDbDAO.searchByPk(id);

		int originBuyQuantity = shoppingCartOBJDTO.getBuyQuantity();
		int buyQuantity = buyQuantityFctn.apply(shoppingCartOBJDTO);

		shoppingCartOBJDTO.setBuyQuantity(buyQuantity);
		
		if(originBuyQuantity > 0)
			shoppingCartMemoryDbDAO.update(shoppingCartOBJDTO);
		else
			shoppingCartMemoryDbDAO.insert(shoppingCartOBJDTO);
	}
	
	public void clearShoppingCart(ShoppingCartMemoryDbDAO shoppingCartMemoryDbDAO) {
		
		shoppingCartMemoryDbDAO.deleteAll();
	}
}
