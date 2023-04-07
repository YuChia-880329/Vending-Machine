package controller.servlet.backend.go;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.vo.backend.goodsList.readin.BGLPageParameterRIVO;
import bean.vo.backend.goodsList.writeout.BackendGoodsListWOVO;
import service.backend.goodsList.GoBackendGoodsListService;
import template.exception.CheckerException;
import transformer.vo.backend.goodsList.readin.BGLPageParameterRIVOTransformer;
import transformer.vo.backend.goodsList.writeout.BackendGoodsListWOVOTransformer;


@SuppressWarnings("serial")
public class GoBackendGoodsListServlet extends HttpServlet {
	
	// url
	public static final String URL = "/vendingMachine/machine/backend/goodsList";
	private static final String FORWARD_URL = "../../WEB-INF/backend/VM_Backend_GoodsList.jsp";
	
	// request parameter
	public static final String REQ_PARAM_PAGE = "page";
	public static final String REQ_PARAM_ID_MIN = "filterIdMin";
	public static final String REQ_PARAM_ID_MAX = "filterIdMax";
	public static final String REQ_PARAM_NAME = "filterName";
	public static final String REQ_PARAM_PRICE_MIN = "filterPriceMin";
	public static final String REQ_PARAM_PRICE_MAX = "filterPriceMax";
	public static final String REQ_PARAM_QUANTITY_MIN = "filterQuantityMin";
	public static final String REQ_PARAM_QUANTITY_MAX = "filterQuantityMax";
	public static final String REQ_PARAM_STATUS = "filterStatus";
	
	// request attribute
	private static final String REQ_ATTR_VO = "vo";
	
	private BGLPageParameterRIVOTransformer bglPageParameterRIVOTransformer;
	private GoBackendGoodsListService goBackendGoodsListService;
	private BackendGoodsListWOVOTransformer backendGoodsListWOVOTransformer;
	
	@Override
	public void init() throws ServletException {
		
		bglPageParameterRIVOTransformer = BGLPageParameterRIVOTransformer.getInstance();
		goBackendGoodsListService = GoBackendGoodsListService.getInstance();
		backendGoodsListWOVOTransformer = BackendGoodsListWOVOTransformer.getInstance();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		BGLPageParameterRIVO pageParamterVO = getPageParameter(req);
		try {
			
			BackendGoodsListWOVO backendGoodsListWOVO = backendGoodsListWOVOTransformer.dtoToVo(
					goBackendGoodsListService.prepare(
							bglPageParameterRIVOTransformer.voToDto(pageParamterVO)));
			req.setAttribute(REQ_ATTR_VO, backendGoodsListWOVO);
			req.getRequestDispatcher(FORWARD_URL).forward(req, resp);
		} catch (CheckerException ex) {
			
			ex.printStackTrace();
		}
		
	}
	
	private BGLPageParameterRIVO getPageParameter(HttpServletRequest req) {
		
		BGLPageParameterRIVO pageParameter = new BGLPageParameterRIVO();
		
		String pageStr = req.getParameter(REQ_PARAM_PAGE);
		String idMinStr = req.getParameter(REQ_PARAM_ID_MIN);
		String idMaxStr = req.getParameter(REQ_PARAM_ID_MAX);
		String nameStr = req.getParameter(REQ_PARAM_NAME);
		String priceMinStr = req.getParameter(REQ_PARAM_PRICE_MIN);
		String priceMaxStr = req.getParameter(REQ_PARAM_PRICE_MAX);
		String quantityMinStr = req.getParameter(REQ_PARAM_QUANTITY_MIN);
		String quantityMaxStr = req.getParameter(REQ_PARAM_QUANTITY_MAX);
		String statusStr = req.getParameter(REQ_PARAM_STATUS);
		
		pageParameter.setPage(pageStr);
		pageParameter.setIdMin(idMinStr);
		pageParameter.setIdMax(idMaxStr);
		pageParameter.setName(nameStr);
		pageParameter.setPriceMin(priceMinStr);
		pageParameter.setPriceMax(priceMaxStr);
		pageParameter.setQuantityMin(quantityMinStr);
		pageParameter.setQuantityMax(quantityMaxStr);
		pageParameter.setStatus(statusStr);
		
		return pageParameter;
	}
}
