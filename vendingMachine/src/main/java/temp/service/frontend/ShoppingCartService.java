package temp.service.frontend;

import bean.dto.frontend.obj.memoryDb.shoppingCart.ShoppingCartOBJDTO;
import dao.memory.memoryDb.frontend.ShoppingCartMemoryDbDAO;

public class ShoppingCartService {

	private static final ShoppingCartService INSTANCE = new ShoppingCartService();
	
	private ShoppingCartService() {
	}
	
	public static ShoppingCartService getInstance() {
		
		return INSTANCE;
	}
	
	public void saveShoppingCartGoods(int id, int buyQuantity, ShoppingCartMemoryDbDAO shoppingCartMemoryDbDAO) {
		
		ShoppingCartOBJDTO shoppingCartOBJDTO = shoppingCartMemoryDbDAO.searchByPk(id);

		int originBuyQuantity = shoppingCartOBJDTO.getBuyQuantity();

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
