package controller.servlet.backend.go;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.dto.virtualMachine.obj.memoryDAOKitVM.AccountOBJDTO;
import bean.vo.backend.goodsList.readin.PageParameterVO;
import bean.vo.backend.goodsList.writeout.BackendGoodsListVO;
import service.backend.goodsList.prepare.GoBackendGoodsListService;
import template.exception.CheckerException;
import transformer.backend.goodsList.vo.readin.PageParameterVOTransformer;
import transformer.backend.goodsList.vo.writeout.BackendGoodsListVOTransformer;
import util.ServletUtil;

@SuppressWarnings("serial")
public class GoBackendGoodsListServlet extends HttpServlet {
	
	// url
	public static final String URL = "/vendingMachine/machine/backend/goodsList";
	private static final String FORWARD_URL = "../../WEB-INF/backend/backend_goodsList.jsp";
	
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
	
	private PageParameterVOTransformer pageParameterVOTransformer;
	private GoBackendGoodsListService goBackendGoodsListService;
	private BackendGoodsListVOTransformer backendGoodsListWOVOTransformer;
	
	@Override
	public void init() throws ServletException {
		
		pageParameterVOTransformer = PageParameterVOTransformer.getInstance();
		goBackendGoodsListService = GoBackendGoodsListService.getInstance();
		backendGoodsListWOVOTransformer = BackendGoodsListVOTransformer.getInstance();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		AccountOBJDTO accountOBJDTO = ServletUtil.getAccount(session);
		
		PageParameterVO pageParamterVO = getPageParameter(req);
		try {
			
			BackendGoodsListVO backendGoodsListWOVO = 
					backendGoodsListWOVOTransformer.dtoToVo(
							goBackendGoodsListService.prepare(
									pageParameterVOTransformer.voToDto(pageParamterVO), accountOBJDTO));
			req.setAttribute(REQ_ATTR_VO, backendGoodsListWOVO);
			req.getRequestDispatcher(FORWARD_URL).forward(req, resp);
		} catch (CheckerException ex) {
			
			ex.printStackTrace();
		}
		
	}
	
	private PageParameterVO getPageParameter(HttpServletRequest req) {
		
		String pageStr = req.getParameter(REQ_PARAM_PAGE);
		String idMinStr = req.getParameter(REQ_PARAM_ID_MIN);
		String idMaxStr = req.getParameter(REQ_PARAM_ID_MAX);
		String nameStr = req.getParameter(REQ_PARAM_NAME);
		String priceMinStr = req.getParameter(REQ_PARAM_PRICE_MIN);
		String priceMaxStr = req.getParameter(REQ_PARAM_PRICE_MAX);
		String quantityMinStr = req.getParameter(REQ_PARAM_QUANTITY_MIN);
		String quantityMaxStr = req.getParameter(REQ_PARAM_QUANTITY_MAX);
		String statusStr = req.getParameter(REQ_PARAM_STATUS);
		
		PageParameterVO pageParameter = new PageParameterVO();
		
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
