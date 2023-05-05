package temp.service.frontend;

import java.util.ArrayList;
import java.util.List;

import bean.dto.frontend.obj.memoryDb.shoppingCart.ShoppingCartOBJDTO;
import bean.dto.frontend.vo.readin.AddShoppingCartGoodsVODTO;
import bean.dto.frontend.vo.writeout.AddShoppingCartIllegalMsgLineVODTO;
import bean.dto.frontend.vo.writeout.AddShoppingCartIllegalMsgVODTO;
import bean.dto.frontend.vo.writeout.AddShoppingCartLegalMsgLineVODTO;
import bean.dto.frontend.vo.writeout.AddShoppingCartLegalMsgVODTO;
import bean.dto.virtualMachine.obj.memoryDAOKitVM.AccountOBJDTO;
import dao.memory.memoryDb.frontend.ShoppingCartMemoryDbDAO;
import dao.virtualDevice.memoryDAOKit.MemoryDAOKitVMDAO;
import temp.bean.dto.frontend.vo.readin.AddShoppingCartVODTO;
import temp.bean.dto.frontend.vo.writeout.AddShoppingCartResultVODTO;

public class AddShoppingCartService {

	private MemoryDAOKitVMDAO memoryDAOKitVMDAO;
	
	
	private static final AddShoppingCartService INSTANCE = new AddShoppingCartService();
	
	private AddShoppingCartService() {
		
		memoryDAOKitVMDAO = MemoryDAOKitVMDAO.getInstance();
	}
	
	public static AddShoppingCartService getInstance() {
		
		return INSTANCE;
	}
	
	public AddShoppingCartResultVODTO add(AddShoppingCartVODTO addShoppingCartVODTO, AccountOBJDTO accountOBJDTO) {
		
		ShoppingCartMemoryDbDAO shoppingCartMemoryDbDAO = memoryDAOKitVMDAO.getShoppingCartMemoryDbDAO(accountOBJDTO);
		
		AddShoppingCartResultVODTO addShoppingCartResultVODTO = new AddShoppingCartResultVODTO();
		
		AddShoppingCartIllegalMsgVODTO addShoppingCartIllegalMsgVODTO = new AddShoppingCartIllegalMsgVODTO();
		AddShoppingCartLegalMsgVODTO addShoppingCartLegalMsgVODTO = new AddShoppingCartLegalMsgVODTO();
		
		addShoppingCartIllegalMsgVODTO.setHasMsg(false);
		addShoppingCartLegalMsgVODTO.setHasMsg(false);
		
		List<AddShoppingCartIllegalMsgLineVODTO> addShoppingCartIllegalMsgLineVODTOs = new ArrayList<>();
		List<AddShoppingCartLegalMsgLineVODTO> addShoppingCartLegalMsgLineVODTOs = new ArrayList<>();
		
		
		List<AddShoppingCartGoodsVODTO> addShoppingCartGoodsVODTOs = addShoppingCartVODTO.getAddShoppingCartGoodsList();
		for(AddShoppingCartGoodsVODTO addShoppingCartGoodsVODTO : addShoppingCartGoodsVODTOs) {
			
			String name = addShoppingCartGoodsVODTO.getName();
			int addQuantity = addShoppingCartGoodsVODTO.getAddQuantity();
			
			if(isLegal(addShoppingCartGoodsVODTO, shoppingCartMemoryDbDAO)) {
				
				addShoppingCartGoods(addShoppingCartGoodsVODTO, shoppingCartMemoryDbDAO);
				addShoppingCartLegalMsgVODTO.setHasMsg(true);
				addShoppingCartLegalMsgLineVODTOs.add(new AddShoppingCartLegalMsgLineVODTO(name, addQuantity));
			}else {
				
				addShoppingCartIllegalMsgVODTO.setHasMsg(true);
				addShoppingCartIllegalMsgLineVODTOs.add(new AddShoppingCartIllegalMsgLineVODTO(name));
			}	
		}
		
		addShoppingCartIllegalMsgVODTO.setLines(addShoppingCartIllegalMsgLineVODTOs);
		addShoppingCartLegalMsgVODTO.setLines(addShoppingCartLegalMsgLineVODTOs);
		
		addShoppingCartResultVODTO.setAddShoppingCartIllegalMsg(addShoppingCartIllegalMsgVODTO);
		addShoppingCartResultVODTO.setAddShoppingCartLegalMsg(addShoppingCartLegalMsgVODTO);
		
		return addShoppingCartResultVODTO;
	}
	private boolean isLegal(AddShoppingCartGoodsVODTO addShoppingCartGoodsVODTO, ShoppingCartMemoryDbDAO shoppingCartMemoryDbDAO) {
		
		int id = addShoppingCartGoodsVODTO.getId();
		int addQuantity = addShoppingCartGoodsVODTO.getAddQuantity();
		int quantity = addShoppingCartGoodsVODTO.getQuantity();
		
		ShoppingCartOBJDTO shoppingCartOBJDTO = shoppingCartMemoryDbDAO.searchByPk(id);
		int originBuyQuantity = shoppingCartOBJDTO.getBuyQuantity();
		int buyQuantity = addQuantity + originBuyQuantity;
		
		return buyQuantity <= quantity;
	}
	private void addShoppingCartGoods(AddShoppingCartGoodsVODTO addShoppingCartGoodsVODTO, ShoppingCartMemoryDbDAO shoppingCartMemoryDbDAO) {
		
		int id = addShoppingCartGoodsVODTO.getId();
		int addQuantity = addShoppingCartGoodsVODTO.getAddQuantity();
		
		ShoppingCartOBJDTO shoppingCartOBJDTO = shoppingCartMemoryDbDAO.searchByPk(id);
		int originBuyQuantity = shoppingCartOBJDTO.getBuyQuantity();
		int buyQuantity = addQuantity + originBuyQuantity;
		
		shoppingCartOBJDTO.setBuyQuantity(buyQuantity);
		
		if(originBuyQuantity > 0)
			shoppingCartMemoryDbDAO.update(shoppingCartOBJDTO);
		else
			shoppingCartMemoryDbDAO.insert(shoppingCartOBJDTO);
	}
}