package service.frontend;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import bean.dto.frontend.CheckoutResultDTO;
import bean.dto.frontend.obj.cache.addShoppingCartIllegalMsgLine.AddShoppingCartIllegalMsgLineOBJDTO;
import bean.dto.frontend.obj.cache.receiptContent.BoughtGoodsMsgOBJDTO;
import bean.dto.frontend.obj.cache.receiptContent.ChangeMsgOBJDTO;
import bean.dto.frontend.obj.cache.receiptContent.PaidMoneyMsgOBJDTO;
import bean.dto.frontend.obj.cache.receiptContent.ReceiptContentOBJDTO;
import bean.dto.frontend.obj.cache.receiptContent.TotalPriceMsgOBJDTO;
import bean.dto.frontend.obj.memoryDb.shoppingCart.ShoppingCartOBJDTO;
import bean.dto.frontend.obj.statusCache.checkoutMoneyIllegalMsgLineOBJ.CheckoutMoneyIllegalMsgHasMsgOBJDTO;
import bean.dto.frontend.vo.readin.AddShoppingCartGoodsVODTO;
import bean.dto.frontend.vo.readin.CheckoutVODTO;
import bean.dto.model.GoodsModelDTO;
import bean.dto.model.OrderModelDTO;
import bean.dto.virtualMachine.obj.memoryDAOKitVM.AccountOBJDTO;
import dao.memory.cache.frontend.AddShoppingCartIllegalMsgLineCacheDAO;
import dao.memory.cache.frontend.ReceiptContentCacheDAO;
import dao.memory.memoryDb.frontend.ShoppingCartMemoryDbDAO;
import dao.memory.statusCache.frontend.CheckoutMoneyIllegalMsgStatusCacheDAO;
import dao.virtualDevice.memoryDAOKit.MemoryDAOKitVMDAO;
import service.model.GoodsModelService;
import service.model.OrderModelService;

public class CheckoutService {

	private GoodsModelService goodsModelService;
	private OrderModelService orderModelService;
	private ShoppingCartService shoppingCartService;
	private MemoryDAOKitVMDAO memoryDAOKitVMDAO;
	
	
	private static final CheckoutService INSTANCE = new CheckoutService();
	
	private CheckoutService() {
		
		goodsModelService = GoodsModelService.getInstance();
		orderModelService = OrderModelService.getInstance();
		shoppingCartService = ShoppingCartService.getInstance();
		memoryDAOKitVMDAO = MemoryDAOKitVMDAO.getInstance();
	}
	
	public static CheckoutService getInstance() {
		
		return INSTANCE;
	}
	
	public CheckoutResultDTO checkout(CheckoutVODTO checkoutVODTO, AccountOBJDTO accountOBJDTO) {
		
		ShoppingCartMemoryDbDAO shoppingCartMemoryDbDAO = memoryDAOKitVMDAO.getShoppingCartMemoryDbDAO(accountOBJDTO);
		AddShoppingCartIllegalMsgLineCacheDAO addShoppingCartIllegalMsgLineCacheDAO = memoryDAOKitVMDAO.getAddShoppingCartIllegalMsgLineCacheDAO(accountOBJDTO);
		CheckoutMoneyIllegalMsgStatusCacheDAO checkoutMoneyIllegalMsgStatusCacheDAO = memoryDAOKitVMDAO.getCheckoutMoneyIllegalMsgStatusCacheDAO(accountOBJDTO);
		ReceiptContentCacheDAO receiptContentCacheDAO = memoryDAOKitVMDAO.getReceiptContentCacheDAO(accountOBJDTO);
		
		addShoppingCart(checkoutVODTO.getAddShoppingCartGoodsList(), shoppingCartMemoryDbDAO, 
				addShoppingCartIllegalMsgLineCacheDAO);
		
		List<ShoppingCartOBJDTO> shoppingCartOBJDTOs = shoppingCartMemoryDbDAO.searchAll();
		Map<Integer, GoodsModelDTO> goodsModelDTOMap = new HashMap<>();
		
		try {
			for(ShoppingCartOBJDTO shoppingCartOBJDTO : shoppingCartOBJDTOs) {
				
				int id = shoppingCartOBJDTO.getId();
				goodsModelDTOMap.put(id, goodsModelService.searchById(id));
			}
			
			int paidMoney = checkoutVODTO.getCheckoutForm().getPaidMoney();
			int shouldPaid = checkoutShoppingCart(paidMoney, shoppingCartMemoryDbDAO, goodsModelDTOMap);
			
			if(paidMoney < shouldPaid) {
				
				checkoutMoneyIllegalMsgStatusCacheDAO.setStatus(new CheckoutMoneyIllegalMsgHasMsgOBJDTO(true));
			}
			
			ReceiptContentOBJDTO receiptOBJDTO = checkoutReceipt(paidMoney, shouldPaid, shoppingCartMemoryDbDAO, goodsModelDTOMap);
			receiptContentCacheDAO.clearCache();
			receiptContentCacheDAO.save(receiptOBJDTO);
			
			
			if(paidMoney >= shouldPaid) {
				

				List<OrderModelDTO> orderModelDTOs = checkoutOrders(shoppingCartMemoryDbDAO, goodsModelDTOMap);
				
				for(OrderModelDTO orderModelDTO : orderModelDTOs) {
					
					orderModelService.add(orderModelDTO);
				}
				
				for(GoodsModelDTO goodsModelDTO : goodsModelDTOMap.values()) {
					
					goodsModelService.update(goodsModelDTO);
				}
				
				shoppingCartMemoryDbDAO.deleteAll();
				
				memoryDAOKitVMDAO.requireUpdateGoodsTablePagesRepositoryDAO();
				memoryDAOKitVMDAO.requireUpdateOrderTablePagesRepositoryDAO();
				memoryDAOKitVMDAO.requireUpdateFrontendGoodsTablePagesRepositoryDAO();
			}
		} catch (SQLException ex) {
			
			ex.printStackTrace();
		}

		CheckoutResultDTO checkoutResultDTO = new CheckoutResultDTO();
		
		checkoutResultDTO.setQueryString(checkoutVODTO.getQueryString());
		
		return checkoutResultDTO;
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
	
	private int checkoutShoppingCart(int paidMoney, ShoppingCartMemoryDbDAO shoppingCartMemoryDbDAO, Map<Integer, GoodsModelDTO> goodsModelDTOMap) {
		
		int shouldPaid = 0;
		List<ShoppingCartOBJDTO> shoppingCartOBJDTOs = shoppingCartMemoryDbDAO.searchAll();
		for(ShoppingCartOBJDTO shoppingCartOBJDTO : shoppingCartOBJDTOs) {
			
			int id = shoppingCartOBJDTO.getId();
			GoodsModelDTO goodsModelDTO = goodsModelDTOMap.get(id);
			
			int buyQuantity = shoppingCartOBJDTO.getBuyQuantity();
			int price = goodsModelDTO.getPrice();
			int quantity = goodsModelDTO.getQuantity();
			
			goodsModelDTO.setQuantity(quantity - buyQuantity);
			goodsModelDTOMap.put(id, goodsModelDTO);
			
			shouldPaid += buyQuantity * price;
		}

		return shouldPaid;
	}
	private ReceiptContentOBJDTO checkoutReceipt(int paidMoney, int shouldPaid, ShoppingCartMemoryDbDAO shoppingCartMemoryDbDAO, Map<Integer, GoodsModelDTO> goodsModelDTOMap) {
		
		ReceiptContentOBJDTO receiptOBJDTO = new ReceiptContentOBJDTO();
		
		ChangeMsgOBJDTO changeMsgOBJDTO = new ChangeMsgOBJDTO();
		List<BoughtGoodsMsgOBJDTO> boughtGoodsMsgOBJDTOs = new ArrayList<>();
		
		if(paidMoney >= shouldPaid) {
			
			int change = paidMoney - shouldPaid;
			
			changeMsgOBJDTO.setHasMsg(true);
			changeMsgOBJDTO.setChange(change);
			
			List<ShoppingCartOBJDTO> shoppingCartOBJDTOs = shoppingCartMemoryDbDAO.searchAll();
			for(ShoppingCartOBJDTO shoppingCartOBJDTO : shoppingCartOBJDTOs) {
				
				int id = shoppingCartOBJDTO.getId();
				GoodsModelDTO goodsModelDTO = goodsModelDTOMap.get(id);
				
				int price = goodsModelDTO.getPrice();
				String name = goodsModelDTO.getName();
				
				boughtGoodsMsgOBJDTOs.add(new BoughtGoodsMsgOBJDTO(name, price, shoppingCartOBJDTO.getBuyQuantity()));
			}
		}else {
			
			changeMsgOBJDTO.setHasMsg(false);
			changeMsgOBJDTO.setChange(0);
		}
		
		receiptOBJDTO.setPaidMoneyMsg(new PaidMoneyMsgOBJDTO(paidMoney));
		receiptOBJDTO.setTotalPriceMsg(new TotalPriceMsgOBJDTO(shouldPaid));
		receiptOBJDTO.setChangeMsg(changeMsgOBJDTO);
		receiptOBJDTO.setBoughtGoodsMsgs(boughtGoodsMsgOBJDTOs);
		
		return receiptOBJDTO;
	}
	
	private List<OrderModelDTO> checkoutOrders(ShoppingCartMemoryDbDAO shoppingCartMemoryDbDAO, Map<Integer, GoodsModelDTO> goodsModelDTOMap) {
		
		List<OrderModelDTO> orderModelDTOs = new ArrayList<>();
		
		List<ShoppingCartOBJDTO> shoppingCartOBJDTOs = shoppingCartMemoryDbDAO.searchAll();
		for(ShoppingCartOBJDTO shoppingCartOBJDTO : shoppingCartOBJDTOs) {
			
			int id = shoppingCartOBJDTO.getId();
			GoodsModelDTO goodsModelDTO = goodsModelDTOMap.get(id);
			
			OrderModelDTO orderModelDTO = new OrderModelDTO();
			
			orderModelDTO.setDateTime(LocalDateTime.now());
			orderModelDTO.setCustomerId("A124243295");
			orderModelDTO.setGoodsId(id);
			orderModelDTO.setGoodsPrice(goodsModelDTO.getPrice());
			orderModelDTO.setBuyQuantity(shoppingCartOBJDTO.getBuyQuantity());
			
			orderModelDTOs.add(orderModelDTO);
		}
		
		return orderModelDTOs;
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
