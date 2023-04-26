package util;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import dao.memory.cache.frontend.AddShoppingCartIllegalMsgCacheDAO;
import dao.memory.cache.frontend.AddShoppingCartMsgCacheDAO;
import dao.memory.cache.frontend.ClearShoppingCartMsgCacheDAO;
import dao.memory.memoryDb.frontend.ShoppingCartMemoryDbDAO;
import dao.memory.repository.backend.goodsList.GoodsTablePagesRepositoryDAO;
import dao.memory.repository.backend.orderList.OrderTablePagesRepositoryDAO;
import memory.cache.frontend.AddShoppingCartIllegalMsgCache;
import memory.cache.frontend.AddShoppingCartMsgCache;
import memory.cache.frontend.ClearShoppingCartMsgCache;
import memory.database.frontend.ShoppingCartMemoryDb;
import memory.repository.backend.goodsList.GoodsTablePagesRepository;
import memory.repository.backend.orderList.OrderTablePagesRepository;

public class ServletUtil {

	public static Map<String, String> getRequestBodyMap(String requestBodyStr){
		
		String[] strs = requestBodyStr.trim().split("&");
		
		Map<String, String> map = new HashMap<>();
		for(String str : strs) {
			
			String[] pair = str.split("=");
			map.put(pair[0], pair[1]);
		}
		
		return map;
	}
	
	
	public static GoodsTablePagesRepositoryDAO getGoodsTablePagesRepositoryDAO(HttpSession session) {
		
		GoodsTablePagesRepositoryDAO goodsTablePagesRepositoryDAO = (GoodsTablePagesRepositoryDAO)session.getAttribute(GoodsTablePagesRepositoryDAO.SESSION_ATTR_DAO);
		
		if(goodsTablePagesRepositoryDAO == null) {
			
			GoodsTablePagesRepository goodsTablePagesRepository = new GoodsTablePagesRepository();
			goodsTablePagesRepositoryDAO = new GoodsTablePagesRepositoryDAO(goodsTablePagesRepository);
			
			session.setAttribute(GoodsTablePagesRepositoryDAO.SESSION_ATTR_DAO, goodsTablePagesRepositoryDAO);
		}
		
		return goodsTablePagesRepositoryDAO;
	}
	public static OrderTablePagesRepositoryDAO getOrderTablePagesRepositoryDAO(HttpSession session) {
		
		OrderTablePagesRepositoryDAO orderTablePagesRepositoryDAO = (OrderTablePagesRepositoryDAO)session.getAttribute(OrderTablePagesRepositoryDAO.SESSION_ATTR_DAO);
		
		if(orderTablePagesRepositoryDAO == null) {
			
			OrderTablePagesRepository orderTablePagesRepository = new OrderTablePagesRepository();
			orderTablePagesRepositoryDAO = new OrderTablePagesRepositoryDAO(orderTablePagesRepository);

			session.setAttribute(OrderTablePagesRepositoryDAO.SESSION_ATTR_DAO, orderTablePagesRepositoryDAO);
		}
		
		return orderTablePagesRepositoryDAO;
	}
	public static dao.memory.repository.frontend.GoodsTablePagesRepositoryDAO getFrontendGoodsTablePagesRepositoryDAO(HttpSession session) {
		
		dao.memory.repository.frontend.GoodsTablePagesRepositoryDAO goodsTablePagesRepositoryDAO = (dao.memory.repository.frontend.GoodsTablePagesRepositoryDAO)session.getAttribute(dao.memory.repository.frontend.GoodsTablePagesRepositoryDAO.SESSION_ATTR_DAO);
		
		if(goodsTablePagesRepositoryDAO == null) {
			
			memory.repository.frontend.GoodsTablePagesRepository goodsTablePagesRepository = new memory.repository.frontend.GoodsTablePagesRepository();
			goodsTablePagesRepositoryDAO = new dao.memory.repository.frontend.GoodsTablePagesRepositoryDAO(goodsTablePagesRepository);
			
			session.setAttribute(dao.memory.repository.frontend.GoodsTablePagesRepositoryDAO.SESSION_ATTR_DAO, goodsTablePagesRepositoryDAO);
		}
		
		return goodsTablePagesRepositoryDAO;
	}
	
	
	public static ShoppingCartMemoryDbDAO getShoppingCartMemoryDbDAO(HttpSession session) {
		
		ShoppingCartMemoryDbDAO shoppingCartMemoryDbDAO = (ShoppingCartMemoryDbDAO)session.getAttribute(ShoppingCartMemoryDbDAO.SESSION_ATTR_DAO);
		
		if(shoppingCartMemoryDbDAO == null) {
			
			ShoppingCartMemoryDb shoppingCartMemoryDb = new ShoppingCartMemoryDb();
			shoppingCartMemoryDbDAO = new ShoppingCartMemoryDbDAO(shoppingCartMemoryDb);
			
			session.setAttribute(ShoppingCartMemoryDbDAO.SESSION_ATTR_DAO, shoppingCartMemoryDbDAO);
		}
		
		return shoppingCartMemoryDbDAO;
	}
	
	
	
	public static AddShoppingCartIllegalMsgCacheDAO getAddShoppingCartIllegalMsgCacheDAO(HttpSession session) {
		
		AddShoppingCartIllegalMsgCacheDAO addShoppingCartIllegalMsgCacheDAO = (AddShoppingCartIllegalMsgCacheDAO)session.getAttribute(AddShoppingCartIllegalMsgCacheDAO.SESSION_ATTR_DAO);
		
		if(addShoppingCartIllegalMsgCacheDAO == null) {
			
			AddShoppingCartIllegalMsgCache addShoppingCartIllegalMsgCache = new AddShoppingCartIllegalMsgCache();
			addShoppingCartIllegalMsgCacheDAO = new AddShoppingCartIllegalMsgCacheDAO(addShoppingCartIllegalMsgCache);
			
			session.setAttribute(AddShoppingCartIllegalMsgCacheDAO.SESSION_ATTR_DAO, addShoppingCartIllegalMsgCacheDAO);
		}
		
		return addShoppingCartIllegalMsgCacheDAO;
	}
	public static AddShoppingCartMsgCacheDAO getAddShoppingCartMsgCacheDAO(HttpSession session) {
		
		AddShoppingCartMsgCacheDAO addShoppingCartMsgCacheDAO = (AddShoppingCartMsgCacheDAO)session.getAttribute(AddShoppingCartMsgCacheDAO.SESSION_ATTR_DAO);
		
		if(addShoppingCartMsgCacheDAO == null) {
			
			AddShoppingCartMsgCache addShoppingCartMsgCache = new AddShoppingCartMsgCache();
			addShoppingCartMsgCacheDAO = new AddShoppingCartMsgCacheDAO(addShoppingCartMsgCache);
			
			session.setAttribute(AddShoppingCartMsgCacheDAO.SESSION_ATTR_DAO, addShoppingCartMsgCacheDAO);
		}
		
		return addShoppingCartMsgCacheDAO;
	}
	public static ClearShoppingCartMsgCacheDAO getClearShoppingCartMsgCacheDAO(HttpSession session) {
		
		ClearShoppingCartMsgCacheDAO clearShoppingCartMsgCacheDAO = (ClearShoppingCartMsgCacheDAO)session.getAttribute(ClearShoppingCartMsgCacheDAO.SESSION_ATTR_DAO);
		
		if(clearShoppingCartMsgCacheDAO == null) {
			
			ClearShoppingCartMsgCache clearShoppingCartMsgCache = new ClearShoppingCartMsgCache();
			clearShoppingCartMsgCacheDAO = new ClearShoppingCartMsgCacheDAO(clearShoppingCartMsgCache);
			
			session.setAttribute(ClearShoppingCartMsgCacheDAO.SESSION_ATTR_DAO, clearShoppingCartMsgCacheDAO);		}
		
		return clearShoppingCartMsgCacheDAO;
	}
}
