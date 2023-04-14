package dao.memory.repository.backend.orderList;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;

public class OrderTablePagesDAOContextListener implements ServletContextListener {

	public static final String ORDER_TABLE_PAGES_DAO_MAP = "orderTablePagesDAOMap";
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {

		Map<HttpSession, OrderTablePagesDAO> orderTablePagesDAOMap = new HashMap<>();
		
		sce.getServletContext().setAttribute(ORDER_TABLE_PAGES_DAO_MAP, orderTablePagesDAOMap);
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
		
	}
}
