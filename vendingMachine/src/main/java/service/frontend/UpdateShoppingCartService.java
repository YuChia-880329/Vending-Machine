package service.frontend;

import java.util.List;
import java.util.function.Function;

import bean.dto.frontend.obj.cache.updateShoppingCartIllegalMsgLine.UpdateShoppingCartIllegalMsgLineOBJDTO;
import bean.dto.frontend.obj.cache.updateShoppingCartMsgLine.UpdateShoppingCartMsgLineOBJDTO;
import bean.dto.frontend.obj.memoryDb.shoppingCart.ShoppingCartOBJDTO;
import bean.dto.frontend.vo.readin.UpdateShoppingCartGoodsVODTO;
import bean.dto.frontend.vo.readin.UpdateShoppingCartVODTO;
import bean.dto.frontend.vo.writeout.UpdateShoppingCartResultVODTO;
import dao.memory.cache.frontend.UpdateShoppingCartIllegalMsgLineCacheDAO;
import dao.memory.cache.frontend.UpdateShoppingCartMsgLineCacheDAO;
import dao.memory.memoryDb.frontend.ShoppingCartMemoryDbDAO;

public class UpdateShoppingCartService {

	private ShoppingCartService shoppingCartService;
	
	
	private static final UpdateShoppingCartService INSTANCE = new UpdateShoppingCartService();
	
	private UpdateShoppingCartService() {
		
		shoppingCartService = ShoppingCartService.getInstance();
	}
	
	public static UpdateShoppingCartService getInstance() {
		
		return INSTANCE;
	}
	
	
	public UpdateShoppingCartResultVODTO update(
			UpdateShoppingCartVODTO updateShoppingCartVODTO, 
			ShoppingCartMemoryDbDAO shoppingCartMemoryDbDAO,
			UpdateShoppingCartIllegalMsgLineCacheDAO updateShoppingCartIllegalMsgLineCacheDAO,
			UpdateShoppingCartMsgLineCacheDAO updateShoppingCartMsgLineCacheDAO) {
		
		UpdateShoppingCartResultVODTO updateShoppingCartResultVODTO = new UpdateShoppingCartResultVODTO();
		
		List<UpdateShoppingCartGoodsVODTO> updateShoppingCartGoodsVODTOs = updateShoppingCartVODTO.getUpdateShoppingCartGoodsList();
		for(int i=0; i<updateShoppingCartGoodsVODTOs.size(); i++) {
			
			UpdateShoppingCartGoodsVODTO updateShoppingCartGoodsVODTO = updateShoppingCartGoodsVODTOs.get(i);
			ShoppingCartOBJDTO shoppingCartOBJDTO = shoppingCartMemoryDbDAO.searchByPk(updateShoppingCartGoodsVODTO.getId());
			
			if(isLegal(updateShoppingCartGoodsVODTO, shoppingCartMemoryDbDAO)) {
				
				if(updateShoppingCartGoodsVODTO.getBuyQuantity() != shoppingCartOBJDTO.getBuyQuantity()) {
					
					updateShoppingCartGoods(updateShoppingCartGoodsVODTO, shoppingCartMemoryDbDAO);
					updateShoppingCartMsgLineCacheDAO.save(new UpdateShoppingCartMsgLineOBJDTO(
							updateShoppingCartGoodsVODTO.getName(), 
							updateShoppingCartGoodsVODTO.getBuyQuantity()));
				}
			}else {
				
				updateShoppingCartIllegalMsgLineCacheDAO.save(new UpdateShoppingCartIllegalMsgLineOBJDTO(
						updateShoppingCartGoodsVODTO.getName()));
			}
		}
		
		updateShoppingCartResultVODTO.setQueryString(updateShoppingCartVODTO.getQueryString());
		
		return updateShoppingCartResultVODTO;
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
