package service.backend.goodsList;

import java.util.function.Function;

import bean.dto.backend.goodsList.vo.readin.PageParameterVODTO;
import controller.servlet.backend.go.GoBackendGoodsListServlet;
import enumeration.Status;
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
		Integer idMin = pageParameter.getIdMin();
		Integer idMax = pageParameter.getIdMax();
		String name = pageParameter.getName();
		Integer priceMin = pageParameter.getPriceMin();
		Integer priceMax = pageParameter.getPriceMax();
		Integer quantityMin = pageParameter.getQuantityMin();
		Integer quantityMax = pageParameter.getQuantityMax();
		Status status = pageParameter.getStatus();
		
		return generateURL(url, 
				page==null ? null : String.valueOf(page), 
				idMin==null ? null : String.valueOf(idMin), 
				idMax==null ? null : String.valueOf(idMax), 
				name, 
				priceMin==null ? null : String.valueOf(priceMin), 
				priceMax==null ? null : String.valueOf(priceMax), 
				quantityMin==null ? null : String.valueOf(quantityMin), 
				quantityMax==null ? null : String.valueOf(quantityMax), 
				status==null ? null : String.valueOf(status.getValue()));
	}
	
	public Function<Integer, String> getUrlFctn(String url, PageParameterVODTO pageParameter){
		
		return page -> {
			
			pageParameter.setPage(page);
			return generateURL(url, pageParameter);
		};
	}
	
	
	private String generateURL(String url, String pageStr, String idMinStr, String idMaxStr, String nameStr, 
			String priceMinStr, String priceMaxStr, String quantityMinStr, String quantityMaxStr, String statusStr) {
		
		boolean isFirstParam = true;
		url = URLUtil.concatParameter(url, GoBackendGoodsListServlet.REQ_PARAM_PAGE, pageStr, isFirstParam);
		isFirstParam = URLUtil.isFirstParam(pageStr, isFirstParam);
		url = URLUtil.concatParameter(url, GoBackendGoodsListServlet.REQ_PARAM_ID_MIN, idMinStr, isFirstParam);
		isFirstParam = URLUtil.isFirstParam(idMinStr, isFirstParam);
		url = URLUtil.concatParameter(url, GoBackendGoodsListServlet.REQ_PARAM_ID_MAX, idMaxStr, isFirstParam);
		isFirstParam = URLUtil.isFirstParam(idMaxStr, isFirstParam);
		url = URLUtil.concatParameter(url, GoBackendGoodsListServlet.REQ_PARAM_NAME, nameStr, isFirstParam);
		isFirstParam = URLUtil.isFirstParam(nameStr, isFirstParam);
		url = URLUtil.concatParameter(url, GoBackendGoodsListServlet.REQ_PARAM_PRICE_MIN, priceMinStr, isFirstParam);
		isFirstParam = URLUtil.isFirstParam(priceMinStr, isFirstParam);
		url = URLUtil.concatParameter(url, GoBackendGoodsListServlet.REQ_PARAM_PRICE_MAX, priceMaxStr, isFirstParam);
		isFirstParam = URLUtil.isFirstParam(priceMaxStr, isFirstParam);
		url = URLUtil.concatParameter(url, GoBackendGoodsListServlet.REQ_PARAM_QUANTITY_MIN, quantityMinStr, isFirstParam);
		isFirstParam = URLUtil.isFirstParam(quantityMinStr, isFirstParam);
		url = URLUtil.concatParameter(url, GoBackendGoodsListServlet.REQ_PARAM_QUANTITY_MAX, quantityMaxStr, isFirstParam);
		isFirstParam = URLUtil.isFirstParam(quantityMaxStr, isFirstParam);
		url = URLUtil.concatParameter(url, GoBackendGoodsListServlet.REQ_PARAM_STATUS, statusStr, isFirstParam);
		
		return url;
	}
}
