package service.frontend;

import java.util.ArrayList;
import java.util.List;

import bean.dto.frontend.obj.memoryDb.shoppingCart.ShoppingCartOBJDTO;
import bean.dto.frontend.vo.readin.UpdateShoppingCartGoodsVODTO;
import bean.dto.frontend.vo.readin.UpdateShoppingCartVODTO;
import bean.dto.frontend.vo.writeout.UpdateShoppingCartIllegalMsgLineVODTO;
import bean.dto.frontend.vo.writeout.UpdateShoppingCartIllegalMsgVODTO;
import bean.dto.frontend.vo.writeout.UpdateShoppingCartLegalMsgLineVODTO;
import bean.dto.frontend.vo.writeout.UpdateShoppingCartLegalMsgVODTO;
import bean.dto.frontend.vo.writeout.UpdateShoppingCartResultVODTO;
import bean.dto.virtualMachine.obj.memoryDAOKitVM.AccountOBJDTO;
import dao.memory.memoryDb.frontend.ShoppingCartMemoryDbDAO;
import dao.virtualDevice.memoryDAOKit.MemoryDAOKitVMDAO;

public class UpdateShoppingCartService {

	private MemoryDAOKitVMDAO memoryDAOKitVMDAO;
	
	
	private static final UpdateShoppingCartService INSTANCE = new UpdateShoppingCartService();
	
	private UpdateShoppingCartService() {
		
		memoryDAOKitVMDAO = MemoryDAOKitVMDAO.getInstance();
	}
	
	public static UpdateShoppingCartService getInstance() {
		
		return INSTANCE;
	}
	
	public UpdateShoppingCartResultVODTO update(UpdateShoppingCartVODTO updateShoppingCartVODTO, AccountOBJDTO accountOBJDTO) {
		
		ShoppingCartMemoryDbDAO shoppingCartMemoryDbDAO = memoryDAOKitVMDAO.getShoppingCartMemoryDbDAO(accountOBJDTO);
		
		UpdateShoppingCartResultVODTO updateShoppingCartResultVODTO = new UpdateShoppingCartResultVODTO();
		
		UpdateShoppingCartIllegalMsgVODTO updateShoppingCartIllegalMsgVODTO = new UpdateShoppingCartIllegalMsgVODTO();
		UpdateShoppingCartLegalMsgVODTO updateShoppingCartLegalMsgVODTO = new UpdateShoppingCartLegalMsgVODTO();
		
		updateShoppingCartIllegalMsgVODTO.setHasMsg(false);
		updateShoppingCartLegalMsgVODTO.setHasMsg(false);
		
		List<UpdateShoppingCartIllegalMsgLineVODTO> updateShoppingCartIllegalMsgLineVODTOs = new ArrayList<>();
		List<UpdateShoppingCartLegalMsgLineVODTO> updateShoppingCartLegalMsgLineVODTOs = new ArrayList<>();
		
		
		List<UpdateShoppingCartGoodsVODTO> updateShoppingCartGoodsVODTOs = updateShoppingCartVODTO.getUpdateShoppingCartGoodsList();
		for(UpdateShoppingCartGoodsVODTO updateShoppingCartGoodsVODTO : updateShoppingCartGoodsVODTOs) {
			
			String name = updateShoppingCartGoodsVODTO.getName();
			int buyQuantity = updateShoppingCartGoodsVODTO.getBuyQuantity();
			
			if(isLegal(updateShoppingCartGoodsVODTO)) {
				
				if(updateShoppingCartGoods(updateShoppingCartGoodsVODTO, shoppingCartMemoryDbDAO)) {
					
					updateShoppingCartLegalMsgVODTO.setHasMsg(true);
					updateShoppingCartLegalMsgLineVODTOs.add(new UpdateShoppingCartLegalMsgLineVODTO(name, buyQuantity));
				}
			}else {
				
				updateShoppingCartIllegalMsgVODTO.setHasMsg(true);
				updateShoppingCartIllegalMsgLineVODTOs.add(new UpdateShoppingCartIllegalMsgLineVODTO(name));
			}	
		}
		
		updateShoppingCartIllegalMsgVODTO.setLines(updateShoppingCartIllegalMsgLineVODTOs);
		updateShoppingCartLegalMsgVODTO.setLines(updateShoppingCartLegalMsgLineVODTOs);
		
		updateShoppingCartResultVODTO.setUpdateShoppingCartIllegalMsg(updateShoppingCartIllegalMsgVODTO);
		updateShoppingCartResultVODTO.setUpdateShoppingCartLegalMsg(updateShoppingCartLegalMsgVODTO);
		
		return updateShoppingCartResultVODTO;
	}
	private boolean isLegal(UpdateShoppingCartGoodsVODTO updateShoppingCartGoodsVODTO) {
		
		int buyQuantity = updateShoppingCartGoodsVODTO.getBuyQuantity();
		int quantity = updateShoppingCartGoodsVODTO.getQuantity();
		
		return buyQuantity <= quantity;
	}
	private boolean updateShoppingCartGoods(UpdateShoppingCartGoodsVODTO updateShoppingCartGoodsVODTO, ShoppingCartMemoryDbDAO shoppingCartMemoryDbDAO) {
		
		int id = updateShoppingCartGoodsVODTO.getId();
		int buyQuantity = updateShoppingCartGoodsVODTO.getBuyQuantity();
		
		
		
		if(buyQuantity <= 0) {
			
			shoppingCartMemoryDbDAO.delete(id);
			return buyQuantity==0;
		}else {
			
			ShoppingCartOBJDTO shoppingCartOBJDTO = shoppingCartMemoryDbDAO.searchByPk(id);
			int originBuyQuantity = shoppingCartOBJDTO.getBuyQuantity();
			shoppingCartOBJDTO.setBuyQuantity(buyQuantity);
			shoppingCartMemoryDbDAO.update(shoppingCartOBJDTO);
			return originBuyQuantity != buyQuantity;
		}
		
	}
}
