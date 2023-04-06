package controller.servlet.backend;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.servlet.backend.go.GoBackendGoodsListServlet;
import util.URLUtil;

@SuppressWarnings("serial")
public class BGLSearchServlet extends HttpServlet {

	// url
	public static final String URL = "/machine/backend/goodsList/search";
	private static final String REDIRECT_URL = GoBackendGoodsListServlet.URL;
	
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
		
		boolean isFirstParam = true;
		url = URLUtil.concatParameter(url, GoBackendGoodsListServlet.REQ_PARAM_ID_MIN, idMinStr, isFirstParam);
		isFirstParam = URLUtil.isFirstParam(idMaxStr, isFirstParam);
		url = URLUtil.concatParameter(url, GoBackendGoodsListServlet.REQ_PARAM_ID_MAX, idMaxStr, isFirstParam);
		isFirstParam = URLUtil.isFirstParam(nameStr, isFirstParam);
		url = URLUtil.concatParameter(url, GoBackendGoodsListServlet.REQ_PARAM_NAME, nameStr, isFirstParam);
		isFirstParam = URLUtil.isFirstParam(priceMinStr, isFirstParam);
		url = URLUtil.concatParameter(url, GoBackendGoodsListServlet.REQ_PARAM_PRICE_MIN, priceMinStr, isFirstParam);
		isFirstParam = URLUtil.isFirstParam(priceMaxStr, isFirstParam);
		url = URLUtil.concatParameter(url, GoBackendGoodsListServlet.REQ_PARAM_PRICE_MAX, priceMaxStr, isFirstParam);
		isFirstParam = URLUtil.isFirstParam(quantityMinStr, isFirstParam);
		url = URLUtil.concatParameter(url, GoBackendGoodsListServlet.REQ_PARAM_QUANTITY_MIN, quantityMinStr, isFirstParam);
		isFirstParam = URLUtil.isFirstParam(quantityMaxStr, isFirstParam);
		url = URLUtil.concatParameter(url, GoBackendGoodsListServlet.REQ_PARAM_QUANTITY_MAX, quantityMaxStr, isFirstParam);
		isFirstParam = URLUtil.isFirstParam(statusStr, isFirstParam);
		url = URLUtil.concatParameter(url, GoBackendGoodsListServlet.REQ_PARAM_STATUS, statusStr, isFirstParam);
		
		return url;
	}
	
}
