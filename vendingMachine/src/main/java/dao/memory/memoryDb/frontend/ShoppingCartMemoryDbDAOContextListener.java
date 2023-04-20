package dao.memory.memoryDb.frontend;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;

import dao.memory.repository.backend.goodsList.GoodsTablePagesRepositoryDAO;

public class ShoppingCartMemoryDbDAOContextListener implements ServletContextListener {

	public static final String SHOPPING_CART_DAO_MAP = "shoppingCartDAOMap";
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
		Map<HttpSession, GoodsTablePagesRepositoryDAO> shoppingCartDAOMap = new HashMap<>();
		
		sce.getServletContext().setAttribute(SHOPPING_CART_DAO_MAP, shoppingCartDAOMap);
	}

	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	}
}
