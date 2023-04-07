package controller.servlet.backend;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.vo.backend.goodsList.readin.BGLPageParameterRIVO;
import controller.servlet.backend.go.GoBackendGoodsListServlet;
import service.backend.goodsList.BGLUrlService;
import template.exception.CheckerException;
import transformer.vo.backend.goodsList.readin.BGLPageParameterRIVOTransformer;

@SuppressWarnings("serial")
public class BGLSearchServlet extends HttpServlet {

	// url
	public static final String URL = "/vendingMachine/machine/backend/goodsList/search";
	private static final String REDIRECT_URL = GoBackendGoodsListServlet.URL;
	
	private BGLUrlService bglUrlService;
	private BGLPageParameterRIVOTransformer bglPageParameterRIVOTransformer;
	
	@Override
	public void init() throws ServletException {
		
		bglUrlService = BGLUrlService.getInstance();
		bglPageParameterRIVOTransformer = BGLPageParameterRIVOTransformer.getInstance();
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
		
		BGLPageParameterRIVO pageParameterVO = new BGLPageParameterRIVO();
		
		pageParameterVO.setIdMin(idMinStr);
		pageParameterVO.setIdMax(idMaxStr);
		pageParameterVO.setName(nameStr);
		pageParameterVO.setPriceMin(priceMinStr);
		pageParameterVO.setPriceMax(priceMaxStr);
		pageParameterVO.setQuantityMin(quantityMinStr);
		pageParameterVO.setQuantityMax(quantityMaxStr);
		pageParameterVO.setStatus(statusStr);
		
		try {
			
			url = bglUrlService.generateURL(url, bglPageParameterRIVOTransformer.voToDto(pageParameterVO));
		} catch (CheckerException ex) {
			
			ex.printStackTrace();
		}
		
		return url;
	}
	
}
