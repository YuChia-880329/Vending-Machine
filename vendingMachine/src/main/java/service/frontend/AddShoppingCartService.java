package service.frontend;

import java.util.ArrayList;

import bean.dto.frontend.obj.memoryDb.msg.MsgOBJDTO;
import bean.dto.frontend.obj.memoryDb.shoppingCart.ShoppingCartOBJDTO;
import bean.dto.frontend.vo.readin.AddShoppingCartGoodsVODTO;
import bean.dto.frontend.vo.readin.AddShoppingCartVODTO;
import bean.dto.frontend.vo.writeout.AddShoppingCartResultVODTO;
import dao.memory.memoryDb.frontend.MsgMemoryDbDAO;
import dao.memory.memoryDb.frontend.ShoppingCartMemoryDbDAO;
import enumeration.Has;

public class AddShoppingCartService {

	private static final String ILLEGAL_MSG_FORMAT = "商品 %s 購買數量超過庫存數量";
	
	private static final AddShoppingCartService INSTANCE = new AddShoppingCartService();
	
	private AddShoppingCartService() {
	}
	
	public static AddShoppingCartService getInstance() {
		
		return INSTANCE;
	}
	
	public AddShoppingCartResultVODTO add(AddShoppingCartVODTO addShoppingCartVODTO, 
			ShoppingCartMemoryDbDAO shoppingCartMemoryDbDAO, MsgMemoryDbDAO illegalMsgMemoryDbDAO) {
		
		AddShoppingCartResultVODTO addShoppingCartResultVODTO = new AddShoppingCartResultVODTO();
		
		MsgOBJDTO illegalMsgOBJDTO = new MsgOBJDTO();
		illegalMsgOBJDTO.setHasMsg(Has.FALSE);
		illegalMsgOBJDTO.setLines(new ArrayList<>());
		
		
		for(AddShoppingCartGoodsVODTO addShoppingCartGoodsVODTO : addShoppingCartVODTO.getAddShoppingCartGoodsList()) {
			
			if(addShoppingCartGoodsVODTO.getBuyQuantity() <= addShoppingCartGoodsVODTO.getQuantity()) {
				
				addShoppingCartGoods(addShoppingCartGoodsVODTO, shoppingCartMemoryDbDAO);
			}else {
				
				illegalMsgOBJDTO.setHasMsg(Has.TRUE);
				illegalMsgOBJDTO.getLines().add(getIllegalMsg(addShoppingCartGoodsVODTO));
			}
				
		}
		illegalMsgMemoryDbDAO.insert(illegalMsgOBJDTO);
		addShoppingCartResultVODTO.setQueryString(addShoppingCartVODTO.getQueryString());
		
		return addShoppingCartResultVODTO;
	}
	private void addShoppingCartGoods(AddShoppingCartGoodsVODTO addShoppingCartGoodsVODTO, ShoppingCartMemoryDbDAO shoppingCartMemoryDbDAO) {
		
		shoppingCartMemoryDbDAO.insert(shoppingCartGoodsVOToShoppingCartOBJ(addShoppingCartGoodsVODTO));
	}
	
	private ShoppingCartOBJDTO shoppingCartGoodsVOToShoppingCartOBJ(AddShoppingCartGoodsVODTO addShoppingCartGoodsVODTO) {
		
		ShoppingCartOBJDTO shoppingCartOBJDTO = new ShoppingCartOBJDTO();
		
		shoppingCartOBJDTO.setId(addShoppingCartGoodsVODTO.getId());
		shoppingCartOBJDTO.setBuyQuantity(addShoppingCartGoodsVODTO.getBuyQuantity());
		
		return shoppingCartOBJDTO;
	}
	private String getIllegalMsg(AddShoppingCartGoodsVODTO addShoppingCartGoodsVODTO) {
		
		return String.format(ILLEGAL_MSG_FORMAT, addShoppingCartGoodsVODTO.getName());
	}
}