package controller.servlet.backend.go;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.vo.backend.orderList.readin.PageParameterVO;
import bean.vo.backend.orderList.writeout.BackendOrderListVO;
import dao.memory.repository.backend.orderList.OrderTablePagesRepositoryDAO;
import service.backend.orderList.prepare.GoBackendOrderListService;
import template.exception.CheckerException;
import transformer.backend.orderList.vo.readin.PageParameterVOTransformer;
import transformer.backend.orderList.vo.writeout.BackendOrderListVOTransformer;
import util.ServletUtil;

@SuppressWarnings("serial")
public class GoBackendOrderListServlet extends HttpServlet {
	
	// url
	public static final String URL = "/vendingMachine/machine/backend/orderList";
	private static final String FORWARD_URL = "../../WEB-INF/backend/VM_Backend_OrderList.jsp";

	// request parameter
	public static final String REQ_PARAM_PAGE = "page";
	public static final String REQ_PARAM_CUSTOMER_NAME = "customerName";
	public static final String REQ_PARAM_START_DATE = "startDate";
	public static final String REQ_PARAM_END_DATE = "endDate";
	public static final String REQ_PARAM_GOODS_NAME = "goodsName";
	public static final String REQ_PARAM_GOODS_PRICE_MIN = "goodsPriceMin";
	public static final String REQ_PARAM_GOODS_PRICE_MAX = "goodsPriceMax";
	public static final String REQ_PARAM_BUY_QUANTITY_MIN = "buyQuantityMin";
	public static final String REQ_PARAM_BUY_QUANTITY_MAX = "buyQuantityMax";
	public static final String REQ_PARAM_TOTAL_PRICE_MIN = "totalPriceMin";
	public static final String REQ_PARAM_TOTAL_PRICE_MAX = "totalPriceMax";
	
	// request attribute
	private static final String REQ_ATTR_VO = "vo";
	
	
	private GoBackendOrderListService goBackendOrderListService;
	private PageParameterVOTransformer pageParameterVOTransformer;
	private BackendOrderListVOTransformer backendOrderListVOTransformer;
	
	@Override
	public void init() throws ServletException {
		
		goBackendOrderListService = GoBackendOrderListService.getInstance();
		pageParameterVOTransformer = PageParameterVOTransformer.getInstance();
		backendOrderListVOTransformer = BackendOrderListVOTransformer.getInstance();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		OrderTablePagesRepositoryDAO orderTablePagesRepositoryDAO = ServletUtil.getOrderTablePagesRepositoryDAO(session);
		PageParameterVO pageParameterVO = getPageParameter(req);
		
		try {
			
			BackendOrderListVO backendOrderListVO = 
					backendOrderListVOTransformer.dtoToVo(goBackendOrderListService.prepare(
					pageParameterVOTransformer.voToDto(pageParameterVO), orderTablePagesRepositoryDAO));
		
			req.setAttribute(REQ_ATTR_VO, backendOrderListVO);
			req.getRequestDispatcher(FORWARD_URL).forward(req, resp);
		} catch (CheckerException ex) {
			
			ex.printStackTrace();
		}
	}
	
	private PageParameterVO getPageParameter(HttpServletRequest req) {
		
		String pageStr = req.getParameter(REQ_PARAM_PAGE);
		String customerName = req.getParameter(REQ_PARAM_CUSTOMER_NAME);
		String startDateStr = req.getParameter(REQ_PARAM_START_DATE);
		String endDateStr = req.getParameter(REQ_PARAM_END_DATE);
		String goodsName = req.getParameter(REQ_PARAM_GOODS_NAME);
		String goodsPriceMinStr = req.getParameter(REQ_PARAM_GOODS_PRICE_MIN);
		String goodsPriceMaxStr = req.getParameter(REQ_PARAM_GOODS_PRICE_MAX);
		String buyQuantityMinStr = req.getParameter(REQ_PARAM_BUY_QUANTITY_MIN);
		String buyQuantityMaxStr = req.getParameter(REQ_PARAM_BUY_QUANTITY_MAX);
		String totalPriceMinStr = req.getParameter(REQ_PARAM_TOTAL_PRICE_MIN);
		String totalPriceMaxStr = req.getParameter(REQ_PARAM_TOTAL_PRICE_MAX);
		
		PageParameterVO pageParameterVO = new PageParameterVO();
		
		pageParameterVO.setPage(pageStr);
		pageParameterVO.setCustomerName(customerName);
		pageParameterVO.setStartDate(startDateStr);
		pageParameterVO.setEndDate(endDateStr);
		pageParameterVO.setGoodsName(goodsName);
		pageParameterVO.setGoodsPriceMin(goodsPriceMinStr);
		pageParameterVO.setGoodsPriceMax(goodsPriceMaxStr);
		pageParameterVO.setBuyQuantityMin(buyQuantityMinStr);
		pageParameterVO.setBuyQuantityMax(buyQuantityMaxStr);
		pageParameterVO.setTotalPriceMin(totalPriceMinStr);
		pageParameterVO.setTotalPriceMax(totalPriceMaxStr);
		
		return pageParameterVO;
	}
}