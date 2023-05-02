package service.frontend;

import java.util.List;
import java.util.function.Function;

import bean.dto.frontend.UpdateShoppingCartResultDTO;
import bean.dto.frontend.obj.cache.updateShoppingCartIllegalMsgLine.UpdateShoppingCartIllegalMsgLineOBJDTO;
import bean.dto.frontend.obj.cache.updateShoppingCartMsgLine.UpdateShoppingCartMsgLineOBJDTO;
import bean.dto.frontend.obj.memoryDb.shoppingCart.ShoppingCartOBJDTO;
import bean.dto.frontend.vo.readin.UpdateShoppingCartGoodsVODTO;
import bean.dto.frontend.vo.readin.UpdateShoppingCartVODTO;
import bean.dto.virtualMachine.obj.memoryDAOKitVM.AccountOBJDTO;
import dao.memory.cache.frontend.UpdateShoppingCartIllegalMsgLineCacheDAO;
import dao.memory.cache.frontend.UpdateShoppingCartMsgLineCacheDAO;
import dao.memory.memoryDb.frontend.ShoppingCartMemoryDbDAO;
import dao.virtualDevice.memoryDAOKit.MemoryDAOKitVMDAO;

public class UpdateShoppingCartService {

	private ShoppingCartService shoppingCartService;
	private MemoryDAOKitVMDAO memoryDAOKitVMDAO;
	
	
	private static final UpdateShoppingCartService INSTANCE = new UpdateShoppingCartService();
	
	private UpdateShoppingCartService() {
		
		shoppingCartService = ShoppingCartService.getInstance();
		memoryDAOKitVMDAO = MemoryDAOKitVMDAO.getInstance();
	}
	
	public static UpdateShoppingCartService getInstance() {
		
		return INSTANCE;
	}
	
	
	public UpdateShoppingCartResultDTO update(UpdateShoppingCartVODTO updateShoppingCartVODTO, AccountOBJDTO accountOBJDTO) {
		
		ShoppingCartMemoryDbDAO shoppingCartMemoryDbDAO = memoryDAOKitVMDAO.getShoppingCartMemoryDbDAO(accountOBJDTO);
		UpdateShoppingCartMsgLineCacheDAO updateShoppingCartMsgLineCacheDAO = memoryDAOKitVMDAO.getUpdateShoppingCartMsgLineCacheDAO(accountOBJDTO);
		UpdateShoppingCartIllegalMsgLineCacheDAO updateShoppingCartIllegalMsgLineCacheDAO = memoryDAOKitVMDAO.getUpdateShoppingCartIllegalMsgLineCacheDAO(accountOBJDTO);
		
		UpdateShoppingCartResultDTO updateShoppingCartResultDTO = new UpdateShoppingCartResultDTO();
		
		List<UpdateShoppingCartGoodsVODTO> updateShoppingCartGoodsVODTOs = updateShoppingCartVODTO.getUpdateShoppingCartGoodsList();
		for(int i=0; i<updateShoppingCartGoodsVODTOs.size(); i++) {
			
			UpdateShoppingCartGoodsVODTO updateShoppingCartGoodsVODTO = updateShoppingCartGoodsVODTOs.get(i);
			ShoppingCartOBJDTO shoppingCartOBJDTO = shoppingCartMemoryDbDAO.searchByPk(updateShoppingCartGoodsVODTO.getId());
			
			if(isLegal(updateShoppingCartGoodsVODTO, shoppingCartMemoryDbDAO)) {
				
				int buyQuantity = updateShoppingCartGoodsVODTO.getBuyQuantity();
				if(buyQuantity != shoppingCartOBJDTO.getBuyQuantity()) {
					
					if(buyQuantity == 0)
						shoppingCartMemoryDbDAO.delete(updateShoppingCartGoodsVODTO.getId());
					else
						updateShoppingCartGoods(updateShoppingCartGoodsVODTO, shoppingCartMemoryDbDAO);
					
					updateShoppingCartMsgLineCacheDAO.save(new UpdateShoppingCartMsgLineOBJDTO(
							updateShoppingCartGoodsVODTO.getName(), 
							buyQuantity));
				}
			}else {
				
				updateShoppingCartIllegalMsgLineCacheDAO.save(new UpdateShoppingCartIllegalMsgLineOBJDTO(
						updateShoppingCartGoodsVODTO.getName()));
			}
		}
		
		updateShoppingCartResultDTO.setQueryString(updateShoppingCartVODTO.getQueryString());
		
		return updateShoppingCartResultDTO;
	}
	
	private boolean isLegal(UpdateShoppingCartGoodsVODTO updateShoppingCartGoodsVODTO, ShoppingCartMemoryDbDAO shoppingCartMemoryDbDAO) {
		
		int id = updateShoppingCartGoodsVODTO.getId();
		int buyQuantity = updateShoppingCartGoodsVODTO.getBuyQuantity();
		int quantity = updateShoppingCartGoodsVODTO.getQuantity();
		
		return shoppingCartService.isLegal(id, quantity, getBuyQuantityFctn(buyQuantity), shoppingCartMemoryDbDAO);
	}
	private void updateShoppingCartGoods(UpdateShoppingCartGoodsVODTO updateShoppingCartGoodsVODTO, ShoppingCartMemoryDbDAO shoppingCartMemoryDbDAO) {
		
		int id = updateShoppingCartGoodsVODTO.getId();
		int buyQuantity = updateShoppingCartGoodsVODTO.getBuyQuantity();
		
		shoppingCartService.saveShoppingCartGoods(id, getBuyQuantityFctn(buyQuantity), shoppingCartMemoryDbDAO);
	}
	
	private Function<ShoppingCartOBJDTO, Integer> getBuyQuantityFctn(int buyQuantity){
		
		return shoppingCartOBJDTO -> {
			
			return buyQuantity;
		};
	}
}
