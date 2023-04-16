package service.backend.goodsList.prepare;

import bean.dto.backend.goodsList.vo.readin.PageParameterVODTO;
import bean.dto.backend.goodsList.vo.writeout.GoodsTableVODTO;
import dao.memory.repository.backend.goodsList.GoodsTablePagesDAO;

public class GoodsTableService {
	
	private GoodsTableRowsService goodsTableRowsService;
	
	
	private static final GoodsTableService INSTANCE = new GoodsTableService();
	
	private GoodsTableService() {
		
		goodsTableRowsService = GoodsTableRowsService.getInstance();
	}
	
	public static GoodsTableService getInstance() {
		
		return INSTANCE;
	}
	
	public GoodsTableVODTO prepare(PageParameterVODTO pageParameterVODTO, GoodsTablePagesDAO goodsTablePagesDAO) {
		
		GoodsTableVODTO goodsTableVODTO = new GoodsTableVODTO();
		
		goodsTableVODTO.setGoodsTableRows(goodsTableRowsService.prepare(pageParameterVODTO, goodsTablePagesDAO));
		
		return goodsTableVODTO;
	}
}
