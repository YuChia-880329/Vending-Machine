package dao.memory.repository.backend.goodsList;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;

public class GoodsTablePagesRepositoryDAOContextListener implements ServletContextListener {

	public static final String GOODS_TABLE_PAGES_DAO_MAP = "goodsTablePagesDAOMap";

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
		Map<HttpSession, GoodsTablePagesRepositoryDAO> goodsTablePagesDAOMap = new HashMap<>();
		
		sce.getServletContext().setAttribute(GOODS_TABLE_PAGES_DAO_MAP, goodsTablePagesDAOMap);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
		
	}
}
