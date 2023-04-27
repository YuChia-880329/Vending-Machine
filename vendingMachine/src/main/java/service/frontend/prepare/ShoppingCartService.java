package service.frontend.prepare;

import java.util.List;
import java.util.stream.Collectors;

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
		shoppingCartVODTO.setTotalPrice(prepareTotalPrice(shoppingCartGoodsVODTOs));
		
		return shoppingCartVODTO;
	}
	private int prepareTotalPrice(List<ShoppingCartGoodsVODTO> shoppingCartGoodsVODTOs) {
		
		return shoppingCartGoodsVODTOs.stream()
				.collect(Collectors.summingInt(shoppingCartGoodsVODTO -> shoppingCartGoodsVODTO.getBuyQuantity()*shoppingCartGoodsVODTO.getPrice()));
	}
}
