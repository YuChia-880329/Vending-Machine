package service.frontend.prepare;

import bean.dto.frontend.obj.repository.goodsTablePages.readin.GoodsTablePagesInputOBJDTO;
import bean.dto.frontend.obj.repository.goodsTablePages.writeout.GoodsTablePagesOBJDTO;
import bean.dto.frontend.vo.readin.PageParameterVODTO;
import bean.dto.frontend.vo.writeout.GoodsTablePageVODTO;
import bean.dto.vo.writeout.PaginationVODTO;
import controller.servlet.frontend.go.GoFrontendServlet;
import dao.memory.memoryDb.frontend.ShoppingCartMemoryDbDAO;
import dao.memory.repository.frontend.GoodsTablePagesRepositoryDAO;
import service.frontend.UrlService;
import service.prepare.PaginationService;

public class GoodsTablePageService {

	public static final int PAGES_PER_PAGE_GROUP = 3;
	public static final int GOODS_PER_PAGE = 6;
	
	
	private GoodsTableService goodsTableService;
	private PaginationService paginationService;
	private UrlService urlService;
	
	private static final GoodsTablePageService INSTANCE = new GoodsTablePageService();
	
	private GoodsTablePageService() {
		
		goodsTableService = GoodsTableService.getInstance();
		paginationService = PaginationService.getInstance();
		urlService = UrlService.getInstance();
	}
	
	public static GoodsTablePageService getInstance() {
		
		return INSTANCE;
	}
	
	public GoodsTablePageVODTO prepare(PageParameterVODTO pageParameterVODTO, GoodsTablePagesRepositoryDAO goodsTablePagesRepositoryDAO, ShoppingCartMemoryDbDAO shoppingCartMemoryDbDAO, String imagesDirectorySymbolicLinkName) {
		
		GoodsTablePageVODTO goodsTablePageVODTO = new GoodsTablePageVODTO();
		
		GoodsTablePagesOBJDTO goodsTablePagesOBJDTO = goodsTablePagesRepositoryDAO.getObjDto(pageParameterToGoodsTablePagesInput(pageParameterVODTO));
		
		goodsTablePageVODTO.setGoodsTable(goodsTableService.prepare(pageParameterVODTO, goodsTablePagesRepositoryDAO, shoppingCartMemoryDbDAO, imagesDirectorySymbolicLinkName));
		goodsTablePageVODTO.setPagination(preparePagination(pageParameterVODTO, goodsTablePagesOBJDTO));
		
		return goodsTablePageVODTO;
	}
	
	private PaginationVODTO preparePagination(PageParameterVODTO pageParameterVODTO, GoodsTablePagesOBJDTO goodsTablePagesOBJDTO) {
		
		return paginationService.prepare(
				pageParameterVODTO.getPage(), 
				PAGES_PER_PAGE_GROUP, 
				goodsTablePagesOBJDTO.getMaxPage(), 
				urlService.getUrlFctn(GoFrontendServlet.URL, pageParameterVODTO));
	}
	
	private GoodsTablePagesInputOBJDTO pageParameterToGoodsTablePagesInput(PageParameterVODTO pageParameterVODTO) {
		
		GoodsTablePagesInputOBJDTO goodsTablePagesInputOBJDTO = new GoodsTablePagesInputOBJDTO();
		
		goodsTablePagesInputOBJDTO.setCurrentPage(pageParameterVODTO.getPage());
		goodsTablePagesInputOBJDTO.setName(pageParameterVODTO.getName());
		
		return goodsTablePagesInputOBJDTO;
	}
}
