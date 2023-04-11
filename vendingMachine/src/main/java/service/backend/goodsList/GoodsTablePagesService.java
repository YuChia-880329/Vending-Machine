package service.backend.goodsList;

import java.util.List;

import bean.dto.backend.goodsList.obj.repository.goodsTablePages.writeout.GoodsTablePagesOBJDTO;
import bean.dto.backend.goodsList.vo.readin.PageParameterVODTO;
import bean.dto.backend.goodsList.vo.writeout.GoodsTablePageVODTO;
import bean.dto.backend.goodsList.vo.writeout.GoodsTableRowVODTO;
import bean.dto.backend.goodsList.vo.writeout.GoodsTableVODTO;
import controller.servlet.backend.go.GoBackendGoodsListServlet;
import dao.memory.repository.backend.goodsList.GoodsTablePagesDAO;
import service.vo.PaginationService;
import util.PaginationUtil;

public class GoodsTablePagesService {

	public static final int PAGES_PER_PAGE_GROUP = 3;
	public static final int GOODS_PER_PAGE = 10;
	
	private PaginationService paginationService;
	private UrlService urlService;
	private DTOTransformService dtoTransformService;
	
	
	private static final GoodsTablePagesService INSTANCE = new GoodsTablePagesService();
	
	private GoodsTablePagesService() {
		
		paginationService = PaginationService.getInstance();
		urlService = UrlService.getInstance();
		dtoTransformService = DTOTransformService.getInstance();
	}
	
	public static GoodsTablePagesService getInstance() {
		
		return INSTANCE;
	}
	
	public GoodsTablePageVODTO prepare(PageParameterVODTO pageParameter, GoodsTablePagesDAO goodsTablePagesDAO) {
		
		GoodsTablePageVODTO goodsTablePageVODTO = new GoodsTablePageVODTO();
		
		GoodsTableVODTO goodsTableVODTO = new GoodsTableVODTO();
		
		GoodsTablePagesOBJDTO goodsTablePagesOBJDTO = goodsTablePagesDAO.getObjDto(dtoTransformService.pageParameterVOToGoodsTablePagesInputOBJ(pageParameter));
		
		int currentPage = pageParameter.getPage();
		List<GoodsTableRowVODTO> goodsTableRowVODTOs = dtoTransformService.goodsOBJsToGoodsTableRowVOs(goodsTablePagesOBJDTO
				.getGoodsTablePageMap().get(currentPage)
				.getGoodsTable().getGoodsList());
		
		goodsTableVODTO.setGoodsTableRows(goodsTableRowVODTOs);
		
		int maxPage = goodsTablePagesOBJDTO.getMaxPage();
		goodsTablePageVODTO.setGoodsTable(goodsTableVODTO);
		goodsTablePageVODTO.setSearchParameter(pageParameter.getSearchParameter());
		goodsTablePageVODTO.setPagination(paginationService.getPagination(
				currentPage, 
				PaginationUtil.getStartPage(currentPage, PAGES_PER_PAGE_GROUP), 
				PaginationUtil.getEndPage(currentPage, PAGES_PER_PAGE_GROUP, maxPage), 
				maxPage, 
				urlService.getUrlFctn(GoBackendGoodsListServlet.URL, pageParameter)));
		
		return goodsTablePageVODTO;
	}
}
