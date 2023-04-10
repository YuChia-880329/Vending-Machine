package controller.servlet.backend.go;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.vo.backend.goodsList.BGLSearchParameterVO;
import bean.vo.backend.goodsList.readin.BGLPageParameteRIVO;
import bean.vo.backend.goodsList.writeout.BackendGoodsListWOVO;
import memory.repository.backend.goodsList.goodsTablePages.GoodsTablePagesDAO;
import memory.repository.backend.goodsList.goodsTablePages.GoodsTablePagesSessionListener;
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
		
		HttpSession session = req.getSession();
		
		GoodsTablePagesDAO goodsTablePagesDAO = (GoodsTablePagesDAO)session.getAttribute(GoodsTablePagesSessionListener.GOODS_TABLE_PAGES_REPOSITORY_DAO);
		
		BGLPageParameteRIVO pageParamterVO = getPageParameter(req);
		try {
			
			BackendGoodsListWOVO backendGoodsListWOVO = 
					backendGoodsListWOVOTransformer.dtoToVo(
							goBackendGoodsListService.prepare(
							bglPageParameterRIVOTransformer.voToDto(pageParamterVO), goodsTablePagesDAO));
			req.setAttribute(REQ_ATTR_VO, backendGoodsListWOVO);
			req.getRequestDispatcher(FORWARD_URL).forward(req, resp);
		} catch (CheckerException ex) {
			
			ex.printStackTrace();
		}
		
	}
	
	private BGLPageParameteRIVO getPageParameter(HttpServletRequest req) {
		
		BGLPageParameteRIVO pageParameter = new BGLPageParameteRIVO();
		
		String pageStr = req.getParameter(REQ_PARAM_PAGE);
		String idMinStr = req.getParameter(REQ_PARAM_ID_MIN);
		String idMaxStr = req.getParameter(REQ_PARAM_ID_MAX);
		String nameStr = req.getParameter(REQ_PARAM_NAME);
		String priceMinStr = req.getParameter(REQ_PARAM_PRICE_MIN);
		String priceMaxStr = req.getParameter(REQ_PARAM_PRICE_MAX);
		String quantityMinStr = req.getParameter(REQ_PARAM_QUANTITY_MIN);
		String quantityMaxStr = req.getParameter(REQ_PARAM_QUANTITY_MAX);
		String statusStr = req.getParameter(REQ_PARAM_STATUS);
		
		BGLSearchParameterVO bglSearchParameterVO = new BGLSearchParameterVO();
		
		bglSearchParameterVO.setIdMin(idMinStr);
		bglSearchParameterVO.setIdMax(idMaxStr);
		bglSearchParameterVO.setName(nameStr);
		bglSearchParameterVO.setPriceMin(priceMinStr);
		bglSearchParameterVO.setPriceMax(priceMaxStr);
		bglSearchParameterVO.setQuantityMin(quantityMinStr);
		bglSearchParameterVO.setQuantityMax(quantityMaxStr);
		bglSearchParameterVO.setStatus(statusStr);
		
		pageParameter.setPage(pageStr);
		pageParameter.setSearchParameters(bglSearchParameterVO);
		
		return pageParameter;
	}
}
