package service.frontend;

import java.util.List;
import java.util.function.Function;

import bean.dto.frontend.obj.cache.addShoppingCartIllegalMsgLine.AddShoppingCartIllegalMsgLineOBJDTO;
import bean.dto.frontend.obj.memoryDb.shoppingCart.ShoppingCartOBJDTO;
import bean.dto.frontend.vo.readin.AddShoppingCartGoodsVODTO;
import bean.dto.frontend.vo.readin.CheckoutAddShoppingCartVODTO;
import bean.dto.virtualMachine.obj.memoryDAOKitVM.AccountOBJDTO;
import dao.memory.cache.frontend.AddShoppingCartIllegalMsgLineCacheDAO;
import dao.memory.memoryDb.frontend.ShoppingCartMemoryDbDAO;
import dao.virtualDevice.memoryDAOKit.MemoryDAOKitVMDAO;

public class CheckoutAddShoppingCartService {

	private MemoryDAOKitVMDAO memoryDAOKitVMDAO;
	private ShoppingCartService shoppingCartService;
	
	
	private static final CheckoutAddShoppingCartService INSTANCE = new CheckoutAddShoppingCartService();
	
	private CheckoutAddShoppingCartService() {
		
		memoryDAOKitVMDAO = MemoryDAOKitVMDAO.getInstance();
		shoppingCartService = ShoppingCartService.getInstance();
	}
	
	public static CheckoutAddShoppingCartService getInstance() {
		
		return INSTANCE;
	}
	
	public void addShoppingCart(CheckoutAddShoppingCartVODTO checkoutAddShoppingCartVODTO, AccountOBJDTO accountOBJDTO) {
		
		ShoppingCartMemoryDbDAO shoppingCartMemoryDbDAO = memoryDAOKitVMDAO.getShoppingCartMemoryDbDAO(accountOBJDTO);
		AddShoppingCartIllegalMsgLineCacheDAO addShoppingCartIllegalMsgLineCacheDAO = memoryDAOKitVMDAO.getAddShoppingCartIllegalMsgLineCacheDAO(accountOBJDTO);
		
		addShoppingCart(checkoutAddShoppingCartVODTO.getAddShoppingCartGoodsList(), shoppingCartMemoryDbDAO, 
				addShoppingCartIllegalMsgLineCacheDAO);
	}
	
	private void addShoppingCart(List<AddShoppingCartGoodsVODTO> addShoppingCartGoodsVODTOs, ShoppingCartMemoryDbDAO shoppingCartMemoryDbDAO, 
			AddShoppingCartIllegalMsgLineCacheDAO addShoppingCartIllegalMsgLineCacheDAO) {
		
		for(AddShoppingCartGoodsVODTO addShoppingCartGoodsVODTO : addShoppingCartGoodsVODTOs) {
			
			if(isLegal(addShoppingCartGoodsVODTO, shoppingCartMemoryDbDAO)) {
				
				addShoppingCartGoods(addShoppingCartGoodsVODTO, shoppingCartMemoryDbDAO);
			}else {
				
				addShoppingCartIllegalMsgLineCacheDAO.save(new AddShoppingCartIllegalMsgLineOBJDTO(addShoppingCartGoodsVODTO.getName()));
			}
				
		}
	}
	
	private boolean isLegal(AddShoppingCartGoodsVODTO addShoppingCartGoodsVODTO, ShoppingCartMemoryDbDAO shoppingCartMemoryDbDAO) {
		
		int id = addShoppingCartGoodsVODTO.getId();
		int addQuantity = addShoppingCartGoodsVODTO.getAddQuantity();
		int quantity = addShoppingCartGoodsVODTO.getQuantity();
		
		return shoppingCartService.isLegal(id, quantity, getBuyQuantityFctn(addQuantity), shoppingCartMemoryDbDAO);
	}
	private void addShoppingCartGoods(AddShoppingCartGoodsVODTO addShoppingCartGoodsVODTO, ShoppingCartMemoryDbDAO shoppingCartMemoryDbDAO) {
		
		int id = addShoppingCartGoodsVODTO.getId();
		int addQuantity = addShoppingCartGoodsVODTO.getAddQuantity();
		
		shoppingCartService.saveShoppingCartGoods(id, getBuyQuantityFctn(addQuantity), shoppingCartMemoryDbDAO);
	}
	
	private Function<ShoppingCartOBJDTO, Integer> getBuyQuantityFctn(int addQuantity){
		
		return shoppingCartOBJDTO -> {
			
			int originBuyQuantity = shoppingCartOBJDTO.getBuyQuantity();
			return originBuyQuantity + addQuantity;
		};
	}
}
