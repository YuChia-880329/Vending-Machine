package controller.servlet.backend.orderList;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.vo.backend.orderList.readin.PageParameterVO;
import controller.servlet.backend.go.GoBackendOrderListServlet;
import service.backend.orderList.UrlService;
import template.exception.CheckerException;
import transformer.backend.orderList.vo.readin.PageParameterVOTransformer;

@SuppressWarnings("serial")
public class SearchServlet extends HttpServlet {

	// url
	public static final String URL = "/vendingMachine/machine/backend/orderList/search";
	private static final String REDIRECT_URL = GoBackendOrderListServlet.URL;
	
	
	private UrlService urlService;
	private PageParameterVOTransformer pageParameterVOTransformer;
	
	@Override
	public void init() throws ServletException {
		
		urlService = UrlService.getInstance();
		pageParameterVOTransformer = PageParameterVOTransformer.getInstance();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.sendRedirect(getRedirectUrl(req));
	}
	
	private String getRedirectUrl(HttpServletRequest req) {
		
		String url = REDIRECT_URL;
		
		String customerName = req.getParameter(GoBackendOrderListServlet.REQ_PARAM_CUSTOMER_NAME);
		String startDateStr = req.getParameter(GoBackendOrderListServlet.REQ_PARAM_START_DATE);
		String endDateStr = req.getParameter(GoBackendOrderListServlet.REQ_PARAM_END_DATE);
		String goodsName = req.getParameter(GoBackendOrderListServlet.REQ_PARAM_GOODS_NAME);
		String goodsPriceMinStr = req.getParameter(GoBackendOrderListServlet.REQ_PARAM_GOODS_PRICE_MIN);
		String goodsPriceMaxStr = req.getParameter(GoBackendOrderListServlet.REQ_PARAM_GOODS_PRICE_MAX);
		String buyQuantityMinStr = req.getParameter(GoBackendOrderListServlet.REQ_PARAM_BUY_QUANTITY_MIN);
		String buyQuantityMaxStr = req.getParameter(GoBackendOrderListServlet.REQ_PARAM_BUY_QUANTITY_MAX);
		String totalPriceMinStr = req.getParameter(GoBackendOrderListServlet.REQ_PARAM_TOTAL_PRICE_MIN);
		String totalPriceMaxStr = req.getParameter(GoBackendOrderListServlet.REQ_PARAM_TOTAL_PRICE_MAX);
	
	
		PageParameterVO pageParameterVO = new PageParameterVO();
		
		pageParameterVO.setPage(null);
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
		
		try {
			
			url = urlService.generateURL(url, pageParameterVOTransformer.voToDto(pageParameterVO));
		} catch (CheckerException ex) {
			
			ex.printStackTrace();
		}
		
		return url;
	}
}
