package service.frontend;

import java.util.List;
import java.util.function.Function;

import bean.dto.frontend.AddShoppingCartResultDTO;
import bean.dto.frontend.obj.cache.addShoppingCartIllegalMsgLine.AddShoppingCartIllegalMsgLineOBJDTO;
import bean.dto.frontend.obj.cache.addShoppingCartMsgLine.AddShoppingCartMsgLineOBJDTO;
import bean.dto.frontend.obj.memoryDb.shoppingCart.ShoppingCartOBJDTO;
import bean.dto.frontend.vo.readin.AddShoppingCartGoodsVODTO;
import bean.dto.frontend.vo.readin.AddShoppingCartVODTO;
import bean.dto.virtualMachine.obj.memoryDAOKitVM.AccountOBJDTO;
import dao.memory.cache.frontend.AddShoppingCartIllegalMsgLineCacheDAO;
import dao.memory.cache.frontend.AddShoppingCartMsgLineCacheDAO;
import dao.memory.memoryDb.frontend.ShoppingCartMemoryDbDAO;
import dao.virtualDevice.memoryDAOKit.MemoryDAOKitVMDAO;

public class AddShoppingCartService {

	private ShoppingCartService shoppingCartService;
	private MemoryDAOKitVMDAO memoryDAOKitVMDAO;
	
	
	private static final AddShoppingCartService INSTANCE = new AddShoppingCartService();
	
	private AddShoppingCartService() {
		
		shoppingCartService = ShoppingCartService.getInstance();
		memoryDAOKitVMDAO = MemoryDAOKitVMDAO.getInstance();
	}
	
	public static AddShoppingCartService getInstance() {
		
		return INSTANCE;
	}
	
	public AddShoppingCartResultDTO add(AddShoppingCartVODTO addShoppingCartVODTO, AccountOBJDTO accountOBJDTO) {
		
		ShoppingCartMemoryDbDAO shoppingCartMemoryDbDAO = memoryDAOKitVMDAO.getShoppingCartMemoryDbDAO(accountOBJDTO);
		AddShoppingCartMsgLineCacheDAO addShoppingCartMsgLineCacheDAO = memoryDAOKitVMDAO.getAddShoppingCartMsgLineCacheDAO(accountOBJDTO);
		AddShoppingCartIllegalMsgLineCacheDAO addShoppingCartIllegalMsgLineCacheDAO = memoryDAOKitVMDAO.getAddShoppingCartIllegalMsgLineCacheDAO(accountOBJDTO);
		
		AddShoppingCartResultDTO addShoppingCartResultDTO = new AddShoppingCartResultDTO();
		
		List<AddShoppingCartGoodsVODTO> addShoppingCartGoodsVODTOs = addShoppingCartVODTO.getAddShoppingCartGoodsList();
		for(AddShoppingCartGoodsVODTO addShoppingCartGoodsVODTO : addShoppingCartGoodsVODTOs) {
			
			if(isLegal(addShoppingCartGoodsVODTO, shoppingCartMemoryDbDAO)) {
				
				addShoppingCartMsgLineCacheDAO.save(new AddShoppingCartMsgLineOBJDTO(addShoppingCartGoodsVODTO.getName(), addShoppingCartGoodsVODTO.getAddQuantity()));
				addShoppingCartGoods(addShoppingCartGoodsVODTO, shoppingCartMemoryDbDAO);
			}else {
				
				addShoppingCartIllegalMsgLineCacheDAO.save(new AddShoppingCartIllegalMsgLineOBJDTO(addShoppingCartGoodsVODTO.getName()));
			}
				
		}
		
		addShoppingCartResultDTO.setRedirectUrl(addShoppingCartVODTO.getCurrentUrl());
		
		return addShoppingCartResultDTO;
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