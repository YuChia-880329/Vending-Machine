package memory.repository.backend.goodsList.goodsTablePages;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class GoodsTablePagesSessionListener implements HttpSessionListener {

	public static final String GOODS_TABLE_PAGES_REPOSITORY_DAO = "goodsTablePagesRepositoryDao";
	
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		
		GoodsTablePagesRepository goodsTablePagesRepository = new GoodsTablePagesRepository();
		GoodsTablePagesDAO goodsTablePagesDAO = new GoodsTablePagesDAO(goodsTablePagesRepository);
		
		se.getSession().setAttribute(GOODS_TABLE_PAGES_REPOSITORY_DAO, goodsTablePagesDAO);
	}
}
