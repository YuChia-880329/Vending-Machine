package dao.memory.memoryDb.frontend;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;

public class FrontendMemoryDbDAOContextListener implements ServletContextListener {

	public static final String SHOPPING_CART_DAO_MAP = "shoppingCartDAOMap";
	public static final String ILLEGAL_MSG_DAO_MAP = "illegalMsgDAOMap";
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
		Map<HttpSession, ShoppingCartMemoryDbDAO> shoppingCartDAOMap = new HashMap<>();
		Map<HttpSession, IllegalMsgMemoryDbDAO> IllegalMsgMemoryDbDAOMap = new HashMap<>();
		
		
		sce.getServletContext().setAttribute(SHOPPING_CART_DAO_MAP, shoppingCartDAOMap);
		sce.getServletContext().setAttribute(ILLEGAL_MSG_DAO_MAP, IllegalMsgMemoryDbDAOMap);
	}

	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	}
}
