package service.frontend.prepare;

import bean.dto.frontend.vo.readin.PageParameterVODTO;
import bean.dto.frontend.vo.writeout.GoodsTableVODTO;
import dao.memory.memoryDb.frontend.ShoppingCartMemoryDbDAO;
import dao.memory.repository.frontend.GoodsTablePagesRepositoryDAO;

public class GoodsTableService {

	private GoodsTableEntriesService goodsTableEntriesService;
	
	
	private static final GoodsTableService INSTANCE = new GoodsTableService();
	
	private GoodsTableService() {
		
		goodsTableEntriesService = GoodsTableEntriesService.getInstance();
	}
	
	public static GoodsTableService getInstance() {
		
		return INSTANCE;
	}
	
	public GoodsTableVODTO prepare(PageParameterVODTO pageParameterVODTO, GoodsTablePagesRepositoryDAO goodsTablePagesRepositoryDAO, 
			ShoppingCartMemoryDbDAO shoppingCartMemoryDbDAO, String imagesDirectoryName) {
		
		GoodsTableVODTO goodsTableVODTO = new GoodsTableVODTO();
		
		goodsTableVODTO.setGoodsTableEntries(goodsTableEntriesService.prepare(pageParameterVODTO, goodsTablePagesRepositoryDAO, 
				shoppingCartMemoryDbDAO, imagesDirectoryName));
		
		return goodsTableVODTO;
	}
}
