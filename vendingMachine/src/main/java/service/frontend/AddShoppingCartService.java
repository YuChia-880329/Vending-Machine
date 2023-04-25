package service.frontend;

import java.util.List;

import bean.dto.frontend.obj.memoryDb.addShoppingCartMsg.AddShoppingCartMsgOBJDTO;
import bean.dto.frontend.obj.memoryDb.shoppingCart.ShoppingCartOBJDTO;
import bean.dto.frontend.vo.readin.AddShoppingCartGoodsVODTO;
import bean.dto.frontend.vo.readin.AddShoppingCartVODTO;
import bean.dto.frontend.vo.writeout.AddShoppingCartResultVODTO;
import dao.memory.memoryDb.frontend.AddShoppingCartMsgMemoryDbDAO;
import dao.memory.memoryDb.frontend.ShoppingCartMemoryDbDAO;

public class AddShoppingCartService {

	private static final AddShoppingCartService INSTANCE = new AddShoppingCartService();
	
	private AddShoppingCartService() {
	}
	
	public static AddShoppingCartService getInstance() {
		
		return INSTANCE;
	}
	
	public AddShoppingCartResultVODTO add(AddShoppingCartVODTO addShoppingCartVODTO, 
			ShoppingCartMemoryDbDAO shoppingCartMemoryDbDAO, AddShoppingCartMsgMemoryDbDAO addShoppingCartMsgMemoryDbDAO) {
		
		AddShoppingCartResultVODTO addShoppingCartResultVODTO = new AddShoppingCartResultVODTO();
		
		List<AddShoppingCartGoodsVODTO> addShoppingCartGoodsVODTOs = addShoppingCartVODTO.getAddShoppingCartGoodsList();
		for(int i=1; i<=addShoppingCartGoodsVODTOs.size(); i++) {
			
			AddShoppingCartGoodsVODTO addShoppingCartGoodsVODTO = addShoppingCartGoodsVODTOs.get(i-1);
			
			if(isLegal(addShoppingCartGoodsVODTO, shoppingCartMemoryDbDAO)) {
				
				addShoppingCartGoods(addShoppingCartGoodsVODTO, shoppingCartMemoryDbDAO);
			}else {
				
				addShoppingCartMsgMemoryDbDAO.insert(new AddShoppingCartMsgOBJDTO(i, addShoppingCartGoodsVODTO.getName()));
			}
				
		}
		
		addShoppingCartResultVODTO.setQueryString(addShoppingCartVODTO.getQueryString());
		
		return addShoppingCartResultVODTO;
	}
	private boolean isLegal(AddShoppingCartGoodsVODTO addShoppingCartGoodsVODTO, ShoppingCartMemoryDbDAO shoppingCartMemoryDbDAO) {
		
		int id = addShoppingCartGoodsVODTO.getId();
		ShoppingCartOBJDTO shoppingCartOBJDTO = shoppingCartMemoryDbDAO.searchByPk(id);
		
		int buyQuantity = shoppingCartOBJDTO.getBuyQuantity() + addShoppingCartGoodsVODTO.getBuyQuantity();
		return (buyQuantity <= addShoppingCartGoodsVODTO.getQuantity());
	}
	private void addShoppingCartGoods(AddShoppingCartGoodsVODTO addShoppingCartGoodsVODTO, ShoppingCartMemoryDbDAO shoppingCartMemoryDbDAO) {
		
		int id = addShoppingCartGoodsVODTO.getId();
		ShoppingCartOBJDTO shoppingCartOBJDTO = shoppingCartMemoryDbDAO.searchByPk(id);
		
		int originBuyQuantity = shoppingCartOBJDTO.getBuyQuantity();
		int buyQuantity = originBuyQuantity + addShoppingCartGoodsVODTO.getBuyQuantity();
		addShoppingCartGoodsVODTO.setBuyQuantity(buyQuantity);
		shoppingCartOBJDTO = shoppingCartGoodsVOToShoppingCartOBJ(addShoppingCartGoodsVODTO);
		
		if(originBuyQuantity > 0)
			shoppingCartMemoryDbDAO.update(shoppingCartOBJDTO);
		else
			shoppingCartMemoryDbDAO.insert(shoppingCartOBJDTO);
	}
	
	private ShoppingCartOBJDTO shoppingCartGoodsVOToShoppingCartOBJ(AddShoppingCartGoodsVODTO addShoppingCartGoodsVODTO) {
		
		ShoppingCartOBJDTO shoppingCartOBJDTO = new ShoppingCartOBJDTO();
		
		shoppingCartOBJDTO.setId(addShoppingCartGoodsVODTO.getId());
		shoppingCartOBJDTO.setBuyQuantity(addShoppingCartGoodsVODTO.getBuyQuantity());
		
		return shoppingCartOBJDTO;
	}
}