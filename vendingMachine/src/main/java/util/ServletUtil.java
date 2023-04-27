package util;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

import javax.servlet.http.HttpSession;

import dao.memory.cache.frontend.AddShoppingCartIllegalMsgLineCacheDAO;
import dao.memory.cache.frontend.AddShoppingCartMsgLineCacheDAO;
import dao.memory.cache.frontend.ClearShoppingCartMsgLineCacheDAO;
import dao.memory.cache.frontend.UpdateShoppingCartIllegalMsgLineCacheDAO;
import dao.memory.cache.frontend.UpdateShoppingCartMsgLineCacheDAO;
import dao.memory.memoryDb.frontend.ShoppingCartMemoryDbDAO;
import dao.memory.repository.backend.goodsList.GoodsTablePagesRepositoryDAO;
import dao.memory.repository.backend.orderList.OrderTablePagesRepositoryDAO;
import memory.cache.frontend.AddShoppingCartIllegalMsgLineCache;
import memory.cache.frontend.AddShoppingCartMsgLineCache;
import memory.cache.frontend.ClearShoppingCartMsgLineCache;
import memory.cache.frontend.UpdateShoppingCartIllegalMsgLineCache;
import memory.cache.frontend.UpdateShoppingCartMsgLineCache;
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
	public static String concatQueryString(String url, String queryString) {
		
		if("".equals(queryString))
			return url;
		else
			return StringConcatUtil.concate(url, "?", queryString);
	}

	public static GoodsTablePagesRepositoryDAO getGoodsTablePagesRepositoryDAO(HttpSession session) {
		
		return getMemoryDAO(
				session, 
				GoodsTablePagesRepositoryDAO.SESSION_ATTR_DAO, 
				() -> new GoodsTablePagesRepository(), 
				memory -> new GoodsTablePagesRepositoryDAO(memory));
	}
	public static OrderTablePagesRepositoryDAO getOrderTablePagesRepositoryDAO(HttpSession session) {
		
		return getMemoryDAO(
				session, 
				OrderTablePagesRepositoryDAO.SESSION_ATTR_DAO, 
				() -> new OrderTablePagesRepository(), 
				memory -> new OrderTablePagesRepositoryDAO(memory));
	}
	public static dao.memory.repository.frontend.GoodsTablePagesRepositoryDAO getFrontendGoodsTablePagesRepositoryDAO(HttpSession session) {
		
		return getMemoryDAO(
				session, 
				dao.memory.repository.frontend.GoodsTablePagesRepositoryDAO.SESSION_ATTR_DAO, 
				() -> new memory.repository.frontend.GoodsTablePagesRepository(), 
				memory -> new dao.memory.repository.frontend.GoodsTablePagesRepositoryDAO(memory));
	}
	
	
	
	public static ShoppingCartMemoryDbDAO getShoppingCartMemoryDbDAO(HttpSession session) {
		
		return getMemoryDAO(
				session, 
				ShoppingCartMemoryDbDAO.SESSION_ATTR_DAO, 
				() -> new ShoppingCartMemoryDb(), 
				memory -> new ShoppingCartMemoryDbDAO(memory));
	}
	
	
	
	public static AddShoppingCartIllegalMsgLineCacheDAO getAddShoppingCartIllegalMsgLineCacheDAO(HttpSession session) {
		
		return getMemoryDAO(
				session, 
				AddShoppingCartIllegalMsgLineCacheDAO.SESSION_ATTR_DAO, 
				() -> new AddShoppingCartIllegalMsgLineCache(), 
				memory -> new AddShoppingCartIllegalMsgLineCacheDAO(memory));
	}
	public static AddShoppingCartMsgLineCacheDAO getAddShoppingCartMsgLineCacheDAO(HttpSession session) {
		
		return getMemoryDAO(
				session, 
				AddShoppingCartMsgLineCacheDAO.SESSION_ATTR_DAO, 
				() -> new AddShoppingCartMsgLineCache(), 
				memory -> new AddShoppingCartMsgLineCacheDAO(memory));
	}
	public static ClearShoppingCartMsgLineCacheDAO getClearShoppingCartMsgLineCacheDAO(HttpSession session) {
		
		return getMemoryDAO(
				session, 
				ClearShoppingCartMsgLineCacheDAO.SESSION_ATTR_DAO, 
				() -> new ClearShoppingCartMsgLineCache(), 
				memory -> new ClearShoppingCartMsgLineCacheDAO(memory));
	}
	public static UpdateShoppingCartIllegalMsgLineCacheDAO getUpdateShoppingCartIllegalMsgLineCacheDAO(HttpSession session) {
		
		return getMemoryDAO(
				session, 
				UpdateShoppingCartIllegalMsgLineCacheDAO.SESSION_ATTR_DAO, 
				() -> new UpdateShoppingCartIllegalMsgLineCache(), 
				memory -> new UpdateShoppingCartIllegalMsgLineCacheDAO(memory));
	}
	public static UpdateShoppingCartMsgLineCacheDAO getUpdateShoppingCartMsgLineCacheDAO(HttpSession session) {
		
		return getMemoryDAO(
				session, 
				UpdateShoppingCartMsgLineCacheDAO.SESSION_ATTR_DAO, 
				() -> new UpdateShoppingCartMsgLineCache(), 
				memory -> new UpdateShoppingCartMsgLineCacheDAO(memory));
	}
	
	
	private static <M, D> D getMemoryDAO(HttpSession session, String sessionAttrName, Supplier<M> memorySupl, Function<M, D> memoryDAOFctn){
		
		@SuppressWarnings("unchecked")
		D memoryDAO = (D)session.getAttribute(sessionAttrName);
		
		if(memoryDAO == null) {
			
			M memory = memorySupl.get();
			memoryDAO = memoryDAOFctn.apply(memory);
			
			session.setAttribute(sessionAttrName, memoryDAO);
		}
		
		return memoryDAO;
	}
}
