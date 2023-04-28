package service.frontend;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bean.dto.frontend.CheckoutResultDTO;
import bean.dto.frontend.obj.cache.receiptContent.BoughtGoodsMsgOBJDTO;
import bean.dto.frontend.obj.cache.receiptContent.ChangeMsgOBJDTO;
import bean.dto.frontend.obj.cache.receiptContent.PaidMoneyMsgOBJDTO;
import bean.dto.frontend.obj.cache.receiptContent.ReceiptContentOBJDTO;
import bean.dto.frontend.obj.cache.receiptContent.TotalPriceMsgOBJDTO;
import bean.dto.frontend.obj.memoryDb.shoppingCart.ShoppingCartOBJDTO;
import bean.dto.frontend.vo.readin.AddShoppingCartGoodsVODTO;
import bean.dto.frontend.vo.readin.CheckoutVODTO;
import bean.dto.model.GoodsModelDTO;
import bean.dto.model.OrderModelDTO;
import dao.memory.cache.frontend.ReceiptContentCacheDAO;
import dao.memory.memoryDb.frontend.ShoppingCartMemoryDbDAO;
import dao.memory.repository.backend.goodsList.GoodsTablePagesRepositoryDAO;
import dao.memory.repository.backend.orderList.OrderTablePagesRepositoryDAO;
import enumeration.Has;
import service.model.GoodsModelService;
import service.model.OrderModelService;

public class CheckoutService {

	private GoodsModelService goodsModelService;
	private OrderModelService orderModelService;
	
	
	private static final CheckoutService INSTANCE = new CheckoutService();
	
	private CheckoutService() {
		
		goodsModelService = GoodsModelService.getInstance();
		orderModelService = OrderModelService.getInstance();
	}
	
	public static CheckoutService getInstance() {
		
		return INSTANCE;
	}
	
	public CheckoutResultDTO checkout(CheckoutVODTO checkoutVODTO, ShoppingCartMemoryDbDAO shoppingCartMemoryDbDAO, ReceiptContentCacheDAO receiptContentCacheDAO, 
			GoodsTablePagesRepositoryDAO goodsTablePagesRepositoryDAO, OrderTablePagesRepositoryDAO orderTablePagesRepositoryDAO, dao.memory.repository.frontend.GoodsTablePagesRepositoryDAO frontendGoodsTablePagesRepositoryDAO) {
		
		List<ShoppingCartOBJDTO> shoppingCartOBJDTOs = shoppingCartMemoryDbDAO.searchAll();
		Map<Integer, GoodsModelDTO> goodsModelDTOMap = new HashMap<>();
		
		try {
			for(ShoppingCartOBJDTO shoppingCartOBJDTO : shoppingCartOBJDTOs) {
				
				int id = shoppingCartOBJDTO.getId();
				goodsModelDTOMap.put(id, goodsModelService.searchById(id));
			}
			
			int paidMoney = checkoutVODTO.getCheckoutForm().getPaidMoney();
			int shouldPaid = checkoutShoppingCart(paidMoney, shoppingCartMemoryDbDAO, goodsModelDTOMap);
			
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
				
				goodsTablePagesRepositoryDAO.requireUpdate();
				orderTablePagesRepositoryDAO.requireUpdate();
				frontendGoodsTablePagesRepositoryDAO.requireUpdate();
			}
		} catch (SQLException ex) {
			
			ex.printStackTrace();
		}

		CheckoutResultDTO checkoutResultDTO = new CheckoutResultDTO();
		
		checkoutResultDTO.setQueryString(checkoutVODTO.getQueryString());
		
		return checkoutResultDTO;
	}
	private void addShoppingCart(List<AddShoppingCartGoodsVODTO> addShoppingCartGoodsList, ShoppingCartMemoryDbDAO shoppingCartMemoryDbDAO) {
		
		for(AddShoppingCartGoodsVODTO addShoppingCartGoodsVODTO : addShoppingCartGoodsList) {
			
			ShoppingCartOBJDTO shoppingCartOBJDTO = new ShoppingCartOBJDTO();
			
			int id = addShoppingCartGoodsVODTO.getId();
			int addQuantity = addShoppingCartGoodsVODTO.getBuyQuantity();
			shoppingCartOBJDTO.setId(id);
			shoppingCartOBJDTO.setBuyQuantity(0);
			
			shoppingCartMemoryDbDAO.insert(null);
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
			
			changeMsgOBJDTO.setHasMsg(Has.TRUE);
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
			
			changeMsgOBJDTO.setHasMsg(Has.FALSE);
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
}
