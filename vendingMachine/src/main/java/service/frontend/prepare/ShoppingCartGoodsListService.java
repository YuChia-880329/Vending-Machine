package service.frontend.prepare;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import bean.dto.frontend.obj.memoryDb.shoppingCart.ShoppingCartOBJDTO;
import bean.dto.frontend.vo.writeout.ShoppingCartGoodsVODTO;
import bean.dto.model.GoodsModelDTO;
import dao.memory.memoryDb.frontend.ShoppingCartMemoryDbDAO;
import service.model.GoodsModelService;

public class ShoppingCartGoodsListService {

	private GoodsModelService goodsModelService;
	
	private static final ShoppingCartGoodsListService INSTANCE = new ShoppingCartGoodsListService();
	
	private ShoppingCartGoodsListService() {
		
		goodsModelService = GoodsModelService.getInstance();
	}
	
	public static ShoppingCartGoodsListService getInstance() {
		
		return INSTANCE;
	}
	
	public List<ShoppingCartGoodsVODTO> prepare(ShoppingCartMemoryDbDAO shoppingCartMemoryDbDAO){
		
		List<ShoppingCartOBJDTO> shoppingCartOBJDTOs = shoppingCartMemoryDbDAO.searchAll();
		
		return shoppingCartOBJsToShoppingCartGoodsVOs(shoppingCartOBJDTOs);
	}
	
	public List<ShoppingCartGoodsVODTO> shoppingCartOBJsToShoppingCartGoodsVOs(List<ShoppingCartOBJDTO> shoppingCartOBJDTOs){
		
		return shoppingCartOBJDTOs.stream()
				.map(shoppingCartOBJDTO -> shoppingCartOBJToShoppingCartGoodsVO(shoppingCartOBJDTO))
				.collect(Collectors.toList());
	}
	public ShoppingCartGoodsVODTO shoppingCartOBJToShoppingCartGoodsVO(ShoppingCartOBJDTO shoppingCartOBJDTO) {
		
		String name = "";
		int price = 0;
		try {
			
			GoodsModelDTO goodsModelDTO = goodsModelService.searchById(shoppingCartOBJDTO.getId());
			name = goodsModelDTO.getName();
			price = goodsModelDTO.getPrice();
		} catch (SQLException ex) {
			
			ex.printStackTrace();
		}
		
		ShoppingCartGoodsVODTO shoppingCartGoodsVODTO = new ShoppingCartGoodsVODTO();
		
		shoppingCartGoodsVODTO.setName(name);
		shoppingCartGoodsVODTO.setBuyQuantity(shoppingCartOBJDTO.getBuyQuantity());
		shoppingCartGoodsVODTO.setPrice(price);
		
		return shoppingCartGoodsVODTO;
	}
}
