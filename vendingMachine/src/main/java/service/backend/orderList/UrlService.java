package service.backend.orderList;

import java.time.LocalDate;
import java.util.function.Function;

import bean.dto.backend.orderList.vo.readin.PageParameterVODTO;
import controller.servlet.backend.go.GoBackendOrderListServlet;
import util.DateTimeUtil;
import util.URLUtil;

public class UrlService {

	private static final UrlService INSTANCE = new UrlService();
	
	private UrlService() {
	}
	
	public static UrlService getInstance() {
		
		return INSTANCE;
	}
	
	public String generateURL(String url, PageParameterVODTO pageParameter) {
		
		Integer page = pageParameter.getPage();
		String customerName = pageParameter.getCustomerName();
		LocalDate startDate = pageParameter.getStartDate();
		LocalDate endDate = pageParameter.getEndDate();
		String goodsName = pageParameter.getGoodsName();
		Integer goodsPriceMin = pageParameter.getGoodsPriceMin();
		Integer goodsPriceMax = pageParameter.getGoodsPriceMax();
		Integer buyQuantityMin = pageParameter.getBuyQuantityMin();
		Integer buyQuantityMax = pageParameter.getBuyQuantityMax();
		Integer totalPriceMin = pageParameter.getTotalPriceMin();
		Integer totalPriceMax = pageParameter.getTotalPriceMax();
		
		return generateURL(url,
				page==null ? null : String.valueOf(page),
				customerName,
				startDate==null ? null : DateTimeUtil.localDateToString(startDate),
				endDate==null ? null : DateTimeUtil.localDateToString(endDate),
				goodsName,
				goodsPriceMin==null ? null : String.valueOf(goodsPriceMin),
				goodsPriceMax==null ? null : String.valueOf(goodsPriceMax),
				buyQuantityMin==null ? null : String.valueOf(buyQuantityMin),
				buyQuantityMax==null ? null : String.valueOf(buyQuantityMax),
				totalPriceMin==null ? null : String.valueOf(totalPriceMin),
				totalPriceMax==null ? null : String.valueOf(totalPriceMax));
	}
	
	public Function<Integer, String> getUrlFctn(String url, PageParameterVODTO pageParameter){
		
		return page -> {
			
			pageParameter.setPage(page);
			return generateURL(url, pageParameter);
		};
	}
	
	
	private String generateURL(String url, String pageStr, String customerName, 
			String startDateStr, String endDateStr, String goodsName, 
			String goodsPriceMinStr, String goodsPriceMaxStr, 
			String buyQuantityMinStr, String buyQuantityMaxStr, 
			String totalPriceMinStr, String totalPriceMaxStr) {
		
		boolean isFirstParam = true;
		url = URLUtil.concatParameter(url, GoBackendOrderListServlet.REQ_PARAM_PAGE, pageStr, isFirstParam);
		isFirstParam = URLUtil.isFirstParam(pageStr, isFirstParam);
		url = URLUtil.concatParameter(url, GoBackendOrderListServlet.REQ_PARAM_CUSTOMER_NAME, customerName, isFirstParam);
		isFirstParam = URLUtil.isFirstParam(customerName, isFirstParam);
		url = URLUtil.concatParameter(url, GoBackendOrderListServlet.REQ_PARAM_START_DATE, startDateStr, isFirstParam);
		isFirstParam = URLUtil.isFirstParam(startDateStr, isFirstParam);
		url = URLUtil.concatParameter(url, GoBackendOrderListServlet.REQ_PARAM_END_DATE, endDateStr, isFirstParam);
		isFirstParam = URLUtil.isFirstParam(endDateStr, isFirstParam);
		url = URLUtil.concatParameter(url, GoBackendOrderListServlet.REQ_PARAM_GOODS_NAME, goodsName, isFirstParam);
		isFirstParam = URLUtil.isFirstParam(goodsName, isFirstParam);
		url = URLUtil.concatParameter(url, GoBackendOrderListServlet.REQ_PARAM_GOODS_PRICE_MIN, goodsPriceMinStr, isFirstParam);
		isFirstParam = URLUtil.isFirstParam(goodsPriceMinStr, isFirstParam);
		url = URLUtil.concatParameter(url, GoBackendOrderListServlet.REQ_PARAM_GOODS_PRICE_MAX, goodsPriceMaxStr, isFirstParam);
		isFirstParam = URLUtil.isFirstParam(goodsPriceMaxStr, isFirstParam);
		
		url = URLUtil.concatParameter(url, GoBackendOrderListServlet.REQ_PARAM_BUY_QUANTITY_MIN, buyQuantityMinStr, isFirstParam);
		isFirstParam = URLUtil.isFirstParam(buyQuantityMinStr, isFirstParam);
		url = URLUtil.concatParameter(url, GoBackendOrderListServlet.REQ_PARAM_BUY_QUANTITY_MAX, buyQuantityMaxStr, isFirstParam);
		isFirstParam = URLUtil.isFirstParam(buyQuantityMaxStr, isFirstParam);
		url = URLUtil.concatParameter(url, GoBackendOrderListServlet.REQ_PARAM_TOTAL_PRICE_MIN, totalPriceMinStr, isFirstParam);
		isFirstParam = URLUtil.isFirstParam(totalPriceMinStr, isFirstParam);
		url = URLUtil.concatParameter(url, GoBackendOrderListServlet.REQ_PARAM_TOTAL_PRICE_MAX, totalPriceMaxStr, isFirstParam);
		isFirstParam = URLUtil.isFirstParam(totalPriceMaxStr, isFirstParam);
		
		return url;
	}
}
