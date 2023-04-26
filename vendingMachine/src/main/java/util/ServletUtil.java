package util;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import dao.memory.cache.frontend.AddShoppingCartIllegalMsgLineCacheDAO;
import dao.memory.cache.frontend.AddShoppingCartMsgLineCacheDAO;
import dao.memory.cache.frontend.ClearShoppingCartMsgLineCacheDAO;
import dao.memory.memoryDb.frontend.ShoppingCartMemoryDbDAO;
import dao.memory.repository.backend.goodsList.GoodsTablePagesRepositoryDAO;
import dao.memory.repository.backend.orderList.OrderTablePagesRepositoryDAO;
import memory.cache.frontend.AddShoppingCartIllegalMsgLineCache;
import memory.cache.frontend.AddShoppingCartMsgLineCache;
import memory.cache.frontend.ClearShoppingCartMsgLineCache;
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
	
	
	
	public static AddShoppingCartIllegalMsgLineCacheDAO getAddShoppingCartIllegalMsgLineCacheDAO(HttpSession session) {
		
		AddShoppingCartIllegalMsgLineCacheDAO addShoppingCartIllegalMsgLineCacheDAO = (AddShoppingCartIllegalMsgLineCacheDAO)session.getAttribute(AddShoppingCartIllegalMsgLineCacheDAO.SESSION_ATTR_DAO);
		
		if(addShoppingCartIllegalMsgLineCacheDAO == null) {
			
			AddShoppingCartIllegalMsgLineCache addShoppingCartIllegalMsgLineCache = new AddShoppingCartIllegalMsgLineCache();
			addShoppingCartIllegalMsgLineCacheDAO = new AddShoppingCartIllegalMsgLineCacheDAO(addShoppingCartIllegalMsgLineCache);
			
			session.setAttribute(AddShoppingCartIllegalMsgLineCacheDAO.SESSION_ATTR_DAO, addShoppingCartIllegalMsgLineCacheDAO);
		}
		
		return addShoppingCartIllegalMsgLineCacheDAO;
	}
	public static AddShoppingCartMsgLineCacheDAO getAddShoppingCartMsgLineCacheDAO(HttpSession session) {
		
		AddShoppingCartMsgLineCacheDAO addShoppingCartMsgLineCacheDAO = (AddShoppingCartMsgLineCacheDAO)session.getAttribute(AddShoppingCartMsgLineCacheDAO.SESSION_ATTR_DAO);
		
		if(addShoppingCartMsgLineCacheDAO == null) {
			
			AddShoppingCartMsgLineCache addShoppingCartMsgLineCache = new AddShoppingCartMsgLineCache();
			addShoppingCartMsgLineCacheDAO = new AddShoppingCartMsgLineCacheDAO(addShoppingCartMsgLineCache);
			
			session.setAttribute(AddShoppingCartMsgLineCacheDAO.SESSION_ATTR_DAO, addShoppingCartMsgLineCacheDAO);
		}
		
		return addShoppingCartMsgLineCacheDAO;
	}
	public static ClearShoppingCartMsgLineCacheDAO getClearShoppingCartMsgLineCacheDAO(HttpSession session) {
		
		ClearShoppingCartMsgLineCacheDAO clearShoppingCartMsgLineCacheDAO = (ClearShoppingCartMsgLineCacheDAO)session.getAttribute(ClearShoppingCartMsgLineCacheDAO.SESSION_ATTR_DAO);
		
		if(clearShoppingCartMsgLineCacheDAO == null) {
			
			ClearShoppingCartMsgLineCache clearShoppingCartMsgLineCache = new ClearShoppingCartMsgLineCache();
			clearShoppingCartMsgLineCacheDAO = new ClearShoppingCartMsgLineCacheDAO(clearShoppingCartMsgLineCache);
			
			session.setAttribute(ClearShoppingCartMsgLineCacheDAO.SESSION_ATTR_DAO, clearShoppingCartMsgLineCacheDAO);		}
		
		return clearShoppingCartMsgLineCacheDAO;
	}
}
