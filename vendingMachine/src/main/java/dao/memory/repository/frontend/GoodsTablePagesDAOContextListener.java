package dao.memory.repository.frontend;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;

public class GoodsTablePagesDAOContextListener implements ServletContextListener {

	public static final String GOODS_TABLE_PAGES_DAO_MAP = "goodsTablePagesDAOMap";

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
		Map<HttpSession, GoodsTablePagesDAO> goodsTablePagesDAOMap = new HashMap<>();
		
		sce.getServletContext().setAttribute(GOODS_TABLE_PAGES_DAO_MAP, goodsTablePagesDAOMap);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
		
	}
}
