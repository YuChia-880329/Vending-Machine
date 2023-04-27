package service.frontend.prepare;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
		
		List<ShoppingCartGoodsVODTO> shoppingCartGoodsVODTOs = new ArrayList<>();
		
		for(int i=0; i<shoppingCartGoodsVODTOs.size(); i++) {
			
			shoppingCartGoodsVODTOs.add(shoppingCartOBJToShoppingCartGoodsVO(shoppingCartOBJDTOs.get(i), i+1));
		}
		return shoppingCartGoodsVODTOs;
	}
	public ShoppingCartGoodsVODTO shoppingCartOBJToShoppingCartGoodsVO(ShoppingCartOBJDTO shoppingCartOBJDTO, int pageId) {
		
		int id = shoppingCartOBJDTO.getId();
		String name = "";
		int price = 0;
		try {
			
			GoodsModelDTO goodsModelDTO = goodsModelService.searchById(id);
			name = goodsModelDTO.getName();
			price = goodsModelDTO.getPrice();
		} catch (SQLException ex) {
			
			ex.printStackTrace();
		}
		
		ShoppingCartGoodsVODTO shoppingCartGoodsVODTO = new ShoppingCartGoodsVODTO();
		
		shoppingCartGoodsVODTO.setId(id);
		shoppingCartGoodsVODTO.setPageId(pageId);
		shoppingCartGoodsVODTO.setName(name);
		shoppingCartGoodsVODTO.setBuyQuantity(shoppingCartOBJDTO.getBuyQuantity());
		shoppingCartGoodsVODTO.setPrice(price);
		
		return shoppingCartGoodsVODTO;
	}
}
