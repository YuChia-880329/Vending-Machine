package service.backend.goodsList;

public class GoodsTablePagesService {

	public static final int PAGES_PER_PAGE_GROUP = 3;
	public static final int GOODS_PER_PAGE = 10;
	
	private static final GoodsTablePagesService INSTANCE = new GoodsTablePagesService();
	
	private GoodsTablePagesService() {
		
	}
	
	public static GoodsTablePagesService getInstance() {
		
		return INSTANCE;
	}
}
