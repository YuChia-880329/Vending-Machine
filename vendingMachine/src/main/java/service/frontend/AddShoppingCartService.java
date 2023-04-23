package service.frontend;

import bean.dto.frontend.obj.memoryDb.shoppingCart.ShoppingCartOBJDTO;
import bean.dto.frontend.vo.readin.AddShoppingCartGoodsVODTO;
import bean.dto.frontend.vo.readin.AddShoppingCartVODTO;
import bean.dto.frontend.vo.writeout.AddShoppingCartResultVODTO;
import dao.memory.memoryDb.frontend.ShoppingCartMemoryDbDAO;

public class AddShoppingCartService {


	private static final AddShoppingCartService INSTANCE = new AddShoppingCartService();
	
	private AddShoppingCartService() {
	}
	
	public static AddShoppingCartService getInstance() {
		
		return INSTANCE;
	}
	
	public AddShoppingCartResultVODTO add(AddShoppingCartVODTO addShoppingCartVODTO, ShoppingCartMemoryDbDAO shoppingCartMemoryDbDAO) {
		
		AddShoppingCartResultVODTO addShoppingCartResultVODTO = new AddShoppingCartResultVODTO();
		
		for(AddShoppingCartGoodsVODTO addShoppingCartGoodsVODTO : addShoppingCartVODTO.getAddShoppingCartGoodsList()) {
			
			addShoppingCartGoods(addShoppingCartGoodsVODTO, shoppingCartMemoryDbDAO);
		}
		
		addShoppingCartResultVODTO.setQueryString(addShoppingCartVODTO.getQueryString());
		
		return addShoppingCartResultVODTO;
	}
	private void addShoppingCartGoods(AddShoppingCartGoodsVODTO addShoppingCartGoodsVODTO, ShoppingCartMemoryDbDAO shoppingCartMemoryDbDAO) {
		
		shoppingCartMemoryDbDAO.insert(shoppingCartGoodsVOToShoppingCartOBJ(addShoppingCartGoodsVODTO));
	}
	
	private ShoppingCartOBJDTO shoppingCartGoodsVOToShoppingCartOBJ(AddShoppingCartGoodsVODTO addShoppingCartGoodsVODTO) {
		
		ShoppingCartOBJDTO shoppingCartOBJDTO = new ShoppingCartOBJDTO();
		
		shoppingCartOBJDTO.setId(addShoppingCartGoodsVODTO.getId());
		shoppingCartOBJDTO.setBuyQuantity(addShoppingCartGoodsVODTO.getBuyQuantity());
		
		return shoppingCartOBJDTO;
	}
}
