package service.backend.goodsList.prepare;

import bean.dto.backend.goodsList.obj.repository.goodsTablePages.readin.GoodsTablePagesInputOBJDTO;
import bean.dto.backend.goodsList.obj.repository.goodsTablePages.writeout.GoodsTablePagesOBJDTO;
import bean.dto.backend.goodsList.vo.readin.PageParameterVODTO;
import bean.dto.backend.goodsList.vo.writeout.GoodsTablePageVODTO;
import controller.servlet.backend.go.GoBackendGoodsListServlet;
import dao.memory.repository.backend.goodsList.GoodsTablePagesDAO;
import service.backend.goodsList.UrlService;
import service.vo.PaginationService;

public class GoodsTablePageService {

	public static final int PAGES_PER_PAGE_GROUP = 3;
	public static final int GOODS_PER_PAGE = 10;
	
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
	
	public GoodsTablePageVODTO prepare(PageParameterVODTO pageParameterVODTO, GoodsTablePagesDAO goodsTablePagesDAO) {
		
		GoodsTablePageVODTO goodsTablePageVODTO = new GoodsTablePageVODTO();
		
		GoodsTablePagesInputOBJDTO goodsTablePagesInputOBJDTO = pageParameterVOToGoodsTablePagesInputOBJ(pageParameterVODTO);
		GoodsTablePagesOBJDTO goodsTablePagesOBJDTO =  goodsTablePagesDAO.getObjDto(goodsTablePagesInputOBJDTO);
		int currentPage = pageParameterVODTO.getPage();
		int maxPage = goodsTablePagesOBJDTO.getMaxPage();
		
		goodsTablePageVODTO.setGoodsTable(goodsTableService.prepare(pageParameterVODTO, goodsTablePagesDAO));
		goodsTablePageVODTO.setPagination(paginationService.prepare(
				currentPage, 
				PAGES_PER_PAGE_GROUP, 
				maxPage, 
				urlService.getUrlFctn(GoBackendGoodsListServlet.URL, pageParameterVODTO)));
		
		return goodsTablePageVODTO;
	}
	
	private GoodsTablePagesInputOBJDTO pageParameterVOToGoodsTablePagesInputOBJ(PageParameterVODTO pageParameterVODTO) {
		
		GoodsTablePagesInputOBJDTO goodsTablePagesInputOBJDTO = new GoodsTablePagesInputOBJDTO();

		goodsTablePagesInputOBJDTO.setCurrentPage(pageParameterVODTO.getPage().intValue());
		goodsTablePagesInputOBJDTO.setIdMin(pageParameterVODTO.getIdMin());
		goodsTablePagesInputOBJDTO.setIdMax(pageParameterVODTO.getIdMax());
		goodsTablePagesInputOBJDTO.setName(pageParameterVODTO.getName());
		goodsTablePagesInputOBJDTO.setPriceMin(pageParameterVODTO.getPriceMin());
		goodsTablePagesInputOBJDTO.setPriceMax(pageParameterVODTO.getPriceMax());
		goodsTablePagesInputOBJDTO.setQuantityMin(pageParameterVODTO.getQuantityMin());
		goodsTablePagesInputOBJDTO.setQuantityMax(pageParameterVODTO.getQuantityMax());
		goodsTablePagesInputOBJDTO.setStatus(pageParameterVODTO.getStatus());
		
		return goodsTablePagesInputOBJDTO;
	}
}
