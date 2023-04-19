package service.frontend.prepare;

import bean.dto.backend.goodsList.vo.readin.PageParameterVODTO;
import bean.dto.frontend.vo.writeout.GoodsTablePageVODTO;
import dao.memory.repository.backend.goodsList.GoodsTablePagesDAO;

public class GoodsTablePageService {

	public static final int PAGES_PER_PAGE_GROUP = 3;
	public static final int GOODS_PER_PAGE = 6;
	
	private static final GoodsTablePageService INSTANCE = new GoodsTablePageService();
	
	private GoodsTablePageService() {
	}
	
	public static GoodsTablePageService getInstance() {
		
		return INSTANCE;
	}
	
	public GoodsTablePageVODTO prepare(PageParameterVODTO pageParameterVODTO, GoodsTablePagesDAO goodsTablePagesDAO) {
		
		GoodsTablePageVODTO goodsTablePageVODTO = new GoodsTablePageVODTO();
		
		goodsTablePageVODTO.setGoodsTable(null);
		
		return goodsTablePageVODTO;
	}
}
