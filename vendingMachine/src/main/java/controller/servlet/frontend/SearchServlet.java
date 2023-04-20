package controller.servlet.frontend;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.vo.frontend.readin.PageParameterVO;
import controller.servlet.frontend.go.GoFrontendServlet;
import service.frontend.UrlService;
import template.exception.CheckerException;
import transformer.frontend.vo.readin.PageParameterVOTransformer;

@SuppressWarnings("serial")
public class SearchServlet extends HttpServlet {

	// url
	public static final String URL = "/vendingMachine/machine/search";
	private static final String REDIRECT_URL = GoFrontendServlet.URL;
	
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
		
		String name = req.getParameter(GoFrontendServlet.REQ_PARAM_NAME);
		
		PageParameterVO pageParameterVO = new PageParameterVO();
		
		pageParameterVO.setName(name);
		
		try {
			
			url = urlService.generateURL(url, pageParameterVOTransformer.voToDto(pageParameterVO));
		} catch (CheckerException ex) {
			
			ex.printStackTrace();
		}
		
		return url;
	}
}
