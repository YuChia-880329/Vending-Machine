package controller.servlet.backend.goodsList;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.vo.backend.goodsList.readin.PageParameterVO;
import controller.servlet.backend.go.GoBackendGoodsListServlet;
import service.backend.goodsList.UrlService;
import template.exception.CheckerException;
import transformer.backend.goodsList.vo.readin.PageParameterVOTransformer;

@SuppressWarnings("serial")
public class SearchServlet extends HttpServlet {

	// url
	public static final String URL = "/vendingMachine/machine/backend/goodsList/search";
	private static final String REDIRECT_URL = GoBackendGoodsListServlet.URL;
	
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
		
		String idMinStr = req.getParameter(GoBackendGoodsListServlet.REQ_PARAM_ID_MIN);
		String idMaxStr = req.getParameter(GoBackendGoodsListServlet.REQ_PARAM_ID_MAX);
		String nameStr = req.getParameter(GoBackendGoodsListServlet.REQ_PARAM_NAME);
		String priceMinStr = req.getParameter(GoBackendGoodsListServlet.REQ_PARAM_PRICE_MIN);
		String priceMaxStr = req.getParameter(GoBackendGoodsListServlet.REQ_PARAM_PRICE_MAX);
		String quantityMinStr = req.getParameter(GoBackendGoodsListServlet.REQ_PARAM_QUANTITY_MIN);
		String quantityMaxStr = req.getParameter(GoBackendGoodsListServlet.REQ_PARAM_QUANTITY_MAX);
		String statusStr = req.getParameter(GoBackendGoodsListServlet.REQ_PARAM_STATUS);
		
		PageParameterVO pageParameterVO = new PageParameterVO();
		
		pageParameterVO.setPage(null);
		pageParameterVO.setIdMin(idMinStr);
		pageParameterVO.setIdMax(idMaxStr);
		pageParameterVO.setName(nameStr);
		pageParameterVO.setPriceMin(priceMinStr);
		pageParameterVO.setPriceMax(priceMaxStr);
		pageParameterVO.setQuantityMin(quantityMinStr);
		pageParameterVO.setQuantityMax(quantityMaxStr);
		pageParameterVO.setStatus(statusStr);
		
		try {
			
			url = urlService.generateURL(url, pageParameterVOTransformer.voToDto(pageParameterVO));
		} catch (CheckerException ex) {
			
			ex.printStackTrace();
		}
		
		return url;
	}
}
