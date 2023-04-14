package service.backend.orderList;

import java.util.List;

import bean.dto.backend.orderList.obj.repository.orderTablePages.writeout.OrderTablePagesOBJDTO;
import bean.dto.backend.orderList.vo.readin.PageParameterVODTO;
import bean.dto.backend.orderList.vo.writeout.OrderTablePageVODTO;
import bean.dto.backend.orderList.vo.writeout.OrderTableRowVODTO;
import bean.dto.backend.orderList.vo.writeout.OrderTableVODTO;
import controller.servlet.backend.go.GoBackendOrderListServlet;
import dao.memory.repository.backend.orderList.OrderTablePagesDAO;
import service.vo.PaginationService;
import util.PaginationUtil;

public class OrderTablePageService {

	public static final int GOODS_PER_PAGE = 10;
	public static final int PAGES_PER_PAGE_GROUP = 3;
	
	private DTOTransformService dtoTransformService;
	private PaginationService paginationService;
	private UrlService urlService;
	
	
	private static final OrderTablePageService INSTANCE = new OrderTablePageService();
	
	private OrderTablePageService() {
		
		dtoTransformService = DTOTransformService.getInstance();
		paginationService = PaginationService.getInstance();
		urlService = UrlService.getInstance();
	}
	
	public static OrderTablePageService getInstance() {
		
		return INSTANCE;
	}
	
	public OrderTablePageVODTO prepare(PageParameterVODTO pageParameterVODTO, OrderTablePagesDAO orderTablePagesDAO) {
		
		OrderTablePageVODTO orderTablePageVODTO = new OrderTablePageVODTO();
		
		OrderTableVODTO orderTableVODTO = new OrderTableVODTO();
		
		OrderTablePagesOBJDTO orderTablePagesOBJDTO = orderTablePagesDAO.getObjDto(dtoTransformService.pageParameterVOToOrderTablePagesInputOBJ(pageParameterVODTO));
		
		int currentPage = pageParameterVODTO.getPage();
		List<OrderTableRowVODTO> orderTableRowVODTOs = dtoTransformService.orderTableRowOBJsToOrderTableRowVOs(
				orderTablePagesOBJDTO.getOrderTablePageMap().get(currentPage)
				.getOrderTable().getOrderTableRows());
		
		orderTableVODTO.setOrderTableRows(orderTableRowVODTOs);
		
		int maxPage = orderTablePagesOBJDTO.getMaxPage();
		
		orderTablePageVODTO.setOrderTable(orderTableVODTO);
		orderTablePageVODTO.setPagination(paginationService.getPagination(
				currentPage, 
				PaginationUtil.getStartPage(currentPage, PAGES_PER_PAGE_GROUP), 
				PaginationUtil.getEndPage(currentPage, PAGES_PER_PAGE_GROUP, maxPage), 
				maxPage, 
				urlService.getUrlFctn(GoBackendOrderListServlet.URL, pageParameterVODTO)));
		
		return orderTablePageVODTO;
	}
}
