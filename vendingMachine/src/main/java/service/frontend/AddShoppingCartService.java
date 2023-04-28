package service.frontend;

import java.util.List;
import java.util.function.Function;

import bean.dto.frontend.AddShoppingCartResultDTO;
import bean.dto.frontend.obj.cache.addShoppingCartIllegalMsgLine.AddShoppingCartIllegalMsgLineOBJDTO;
import bean.dto.frontend.obj.cache.addShoppingCartMsgLine.AddShoppingCartMsgLineOBJDTO;
import bean.dto.frontend.obj.memoryDb.shoppingCart.ShoppingCartOBJDTO;
import bean.dto.frontend.vo.readin.AddShoppingCartGoodsVODTO;
import bean.dto.frontend.vo.readin.AddShoppingCartVODTO;
import dao.memory.cache.frontend.AddShoppingCartIllegalMsgLineCacheDAO;
import dao.memory.cache.frontend.AddShoppingCartMsgLineCacheDAO;
import dao.memory.memoryDb.frontend.ShoppingCartMemoryDbDAO;

public class AddShoppingCartService {

	private ShoppingCartService shoppingCartService;
	
	
	private static final AddShoppingCartService INSTANCE = new AddShoppingCartService();
	
	private AddShoppingCartService() {
		
		shoppingCartService = ShoppingCartService.getInstance();
	}
	
	public static AddShoppingCartService getInstance() {
		
		return INSTANCE;
	}
	
	public AddShoppingCartResultDTO add(
			AddShoppingCartVODTO addShoppingCartVODTO, 
			ShoppingCartMemoryDbDAO shoppingCartMemoryDbDAO, 
			AddShoppingCartIllegalMsgLineCacheDAO addShoppingCartIllegalMsgLineCacheDAO, 
			AddShoppingCartMsgLineCacheDAO addShoppingCartMsgLineCacheDAO) {
		
		AddShoppingCartResultDTO addShoppingCartResultDTO = new AddShoppingCartResultDTO();
		
		List<AddShoppingCartGoodsVODTO> addShoppingCartGoodsVODTOs = addShoppingCartVODTO.getAddShoppingCartGoodsList();
		for(int i=0; i<addShoppingCartGoodsVODTOs.size(); i++) {
			
			AddShoppingCartGoodsVODTO addShoppingCartGoodsVODTO = addShoppingCartGoodsVODTOs.get(i);
			
			if(isLegal(addShoppingCartGoodsVODTO, shoppingCartMemoryDbDAO)) {
				
				addShoppingCartMsgLineCacheDAO.save(new AddShoppingCartMsgLineOBJDTO(addShoppingCartGoodsVODTO.getName(), addShoppingCartGoodsVODTO.getBuyQuantity()));
				addShoppingCartGoods(addShoppingCartGoodsVODTO, shoppingCartMemoryDbDAO);
			}else {
				
				addShoppingCartIllegalMsgLineCacheDAO.save(new AddShoppingCartIllegalMsgLineOBJDTO(addShoppingCartGoodsVODTO.getName()));
			}
				
		}
		
		addShoppingCartResultDTO.setQueryString(addShoppingCartVODTO.getQueryString());
		
		return addShoppingCartResultDTO;
	}
	private boolean isLegal(AddShoppingCartGoodsVODTO addShoppingCartGoodsVODTO, ShoppingCartMemoryDbDAO shoppingCartMemoryDbDAO) {
		
		int id = addShoppingCartGoodsVODTO.getId();
		int addQuantity = addShoppingCartGoodsVODTO.getBuyQuantity();
		int quantity = addShoppingCartGoodsVODTO.getQuantity();
		
		return shoppingCartService.isLegal(id, quantity, getBuyQuantityFctn(addQuantity), shoppingCartMemoryDbDAO);
	}
	private void addShoppingCartGoods(AddShoppingCartGoodsVODTO addShoppingCartGoodsVODTO, ShoppingCartMemoryDbDAO shoppingCartMemoryDbDAO) {
		
		int id = addShoppingCartGoodsVODTO.getId();
		int addQuantity = addShoppingCartGoodsVODTO.getBuyQuantity();
		
		shoppingCartService.saveShoppingCartGoods(id, getBuyQuantityFctn(addQuantity), shoppingCartMemoryDbDAO);
	}
	
	private Function<ShoppingCartOBJDTO, Integer> getBuyQuantityFctn(int addQuantity){
		
		return shoppingCartOBJDTO -> {
			
			int originBuyQuantity = shoppingCartOBJDTO.getBuyQuantity();
			return originBuyQuantity + addQuantity;
		};
	}
}