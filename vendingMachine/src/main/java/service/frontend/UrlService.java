package service.frontend;

import java.util.function.Function;

import bean.dto.frontend.vo.readin.PageParameterVODTO;
import controller.servlet.frontend.go.GoFrontendServlet;
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
		String name = pageParameter.getName();
		
		return generateURL(url, 
				page==null ? null : String.valueOf(page), 
				name==null ? null : name);
	}
	
	public Function<Integer, String> getUrlFctn(String url, PageParameterVODTO pageParameter){
		
		return page -> {
			
			pageParameter.setPage(page);
			return generateURL(url, pageParameter);
		};
	}
	
	
	private String generateURL(String url, String pageStr, String name) {
		
		boolean isFirstParam = true;
		
		url = URLUtil.concatParameter(url, GoFrontendServlet.REQ_PARAM_PAGE, pageStr, isFirstParam);
		isFirstParam = URLUtil.isFirstParam(pageStr, isFirstParam);
		url = URLUtil.concatParameter(url, GoFrontendServlet.REQ_PARAM_NAME, name, isFirstParam);
		isFirstParam = URLUtil.isFirstParam(name, isFirstParam);
		
		return url;
	}
}
