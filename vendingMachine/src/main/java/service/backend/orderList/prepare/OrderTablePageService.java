package service.backend.orderList.prepare;

import bean.dto.backend.orderList.obj.repository.orderTablePages.readin.OrderTablePagesInputOBJDTO;
import bean.dto.backend.orderList.obj.repository.orderTablePages.writeout.OrderTablePagesOBJDTO;
import bean.dto.backend.orderList.vo.readin.PageParameterVODTO;
import bean.dto.backend.orderList.vo.writeout.OrderTablePageVODTO;
import controller.servlet.backend.go.GoBackendOrderListServlet;
import dao.memory.repository.backend.orderList.OrderTablePagesRepositoryDAO;
import service.backend.orderList.UrlService;
import service.prepare.PaginationService;

public class OrderTablePageService {

	public static final int GOODS_PER_PAGE = 10;
	public static final int PAGES_PER_PAGE_GROUP = 3;
	
	private OrderTableService orderTableService;
	private PaginationService paginationService;
	private UrlService urlService;
	
	
	
	private static final OrderTablePageService INSTANCE = new OrderTablePageService();
	
	private OrderTablePageService() {
		
		orderTableService = OrderTableService.getInstance();
		paginationService = PaginationService.getInstance();
		urlService = UrlService.getInstance();
	}
	
	public static OrderTablePageService getInstance() {
		
		return INSTANCE;
	}
	
	public OrderTablePageVODTO prepare(PageParameterVODTO pageParameterVODTO, OrderTablePagesRepositoryDAO orderTablePagesRepositoryDAO) {
		
		OrderTablePageVODTO orderTablePageVODTO = new OrderTablePageVODTO();
		
		OrderTablePagesInputOBJDTO orderTablePagesInputOBJDTO = pageParameterVOToOrderTablePagesInputOBJ(pageParameterVODTO);
		OrderTablePagesOBJDTO orderTablePagesOBJDTO = orderTablePagesRepositoryDAO.getObjDto(orderTablePagesInputOBJDTO);
		
		int currentPage = pageParameterVODTO.getPage();
		int maxPage = orderTablePagesOBJDTO.getMaxPage();
		
		orderTablePageVODTO.setOrderTable(orderTableService.prepare(pageParameterVODTO, orderTablePagesRepositoryDAO));
		orderTablePageVODTO.setPagination(paginationService.prepare(
				currentPage, 
				PAGES_PER_PAGE_GROUP, 
				maxPage, 
				urlService.getUrlFctn(GoBackendOrderListServlet.URL, pageParameterVODTO)));
		
		return orderTablePageVODTO;
	}
	
	private OrderTablePagesInputOBJDTO pageParameterVOToOrderTablePagesInputOBJ(PageParameterVODTO pageParameterVODTO) {
		
		OrderTablePagesInputOBJDTO orderTablePagesInputOBJDTO = new OrderTablePagesInputOBJDTO();
		
		orderTablePagesInputOBJDTO.setCurrentPage(pageParameterVODTO.getPage().intValue());
		orderTablePagesInputOBJDTO.setCustomerName(pageParameterVODTO.getCustomerName());
		orderTablePagesInputOBJDTO.setStartDate(pageParameterVODTO.getStartDate());
		orderTablePagesInputOBJDTO.setEndDate(pageParameterVODTO.getEndDate());
		orderTablePagesInputOBJDTO.setGoodsName(pageParameterVODTO.getGoodsName());
		orderTablePagesInputOBJDTO.setGoodsPriceMin(pageParameterVODTO.getGoodsPriceMin());
		orderTablePagesInputOBJDTO.setGoodsPriceMax(pageParameterVODTO.getGoodsPriceMax());
		orderTablePagesInputOBJDTO.setBuyQuantityMin(pageParameterVODTO.getBuyQuantityMin());
		orderTablePagesInputOBJDTO.setBuyQuantityMax(pageParameterVODTO.getBuyQuantityMax());
		orderTablePagesInputOBJDTO.setTotalPriceMin(pageParameterVODTO.getTotalPriceMin());
		orderTablePagesInputOBJDTO.setTotalPriceMax(pageParameterVODTO.getTotalPriceMax());
		
		return orderTablePagesInputOBJDTO;
	}
}
