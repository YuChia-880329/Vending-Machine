package controller.servlet.backend.go;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.vo.backend.goodsList.readin.PageParameterVO;
import bean.vo.backend.goodsList.writeout.BackendGoodsListVO;
import dao.memory.repository.backend.goodsList.GoodsTablePagesRepositoryDAO;
import memory.repository.backend.goodsList.GoodsTablePagesRepository;
import service.backend.goodsList.prepare.GoBackendGoodsListService;
import dao.memory.repository.backend.goodsList.BackendGoodsListRepositoryDAOContextListener;
import template.exception.CheckerException;
import transformer.backend.goodsList.vo.readin.PageParameterVOTransformer;
import transformer.backend.goodsList.vo.writeout.BackendGoodsListVOTransformer;

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
		
		ServletContext context = req.getServletContext();
		HttpSession session = req.getSession();
		
		GoodsTablePagesRepositoryDAO goodsTablePagesRepositoryDAO = getGoodsTablePagesDAO(context, session);
		PageParameterVO pageParamterVO = getPageParameter(req);
		try {
			
			BackendGoodsListVO backendGoodsListWOVO = 
					backendGoodsListWOVOTransformer.dtoToVo(
							goBackendGoodsListService.prepare(
									pageParameterVOTransformer.voToDto(pageParamterVO), goodsTablePagesRepositoryDAO));
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
	
	private GoodsTablePagesRepositoryDAO getGoodsTablePagesDAO(ServletContext context, HttpSession session) {
		
		@SuppressWarnings("unchecked")
		Map<HttpSession, GoodsTablePagesRepositoryDAO> goodsTablePagesDAOMap = (Map<HttpSession, GoodsTablePagesRepositoryDAO>)context.getAttribute(BackendGoodsListRepositoryDAOContextListener.GOODS_TABLE_PAGES_DAO_MAP);
		
		GoodsTablePagesRepositoryDAO goodsTablePagesDAO = goodsTablePagesDAOMap.get(session);
		
		if(goodsTablePagesDAO == null) {
			
			GoodsTablePagesRepository goodsTablePagesRepository = new GoodsTablePagesRepository();
			goodsTablePagesDAO = new GoodsTablePagesRepositoryDAO(goodsTablePagesRepository);
			
			goodsTablePagesDAOMap.put(session, goodsTablePagesDAO);
		}
		
		return goodsTablePagesDAO;
	}
}
