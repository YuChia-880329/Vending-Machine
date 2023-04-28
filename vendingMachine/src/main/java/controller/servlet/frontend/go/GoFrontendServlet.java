package controller.servlet.frontend.go;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.dto.frontend.vo.readin.PageParameterVODTO;
import bean.dto.frontend.vo.writeout.FrontendVODTO;
import bean.dto.model.MemberModelDTO;
import bean.vo.frontend.readin.PageParameterVO;
import bean.vo.frontend.writeout.FrontendVO;
import dao.memory.cache.frontend.AddShoppingCartIllegalMsgLineCacheDAO;
import dao.memory.cache.frontend.AddShoppingCartMsgLineCacheDAO;
import dao.memory.cache.frontend.ClearShoppingCartMsgLineCacheDAO;
import dao.memory.cache.frontend.ReceiptContentCacheDAO;
import dao.memory.cache.frontend.UpdateShoppingCartIllegalMsgLineCacheDAO;
import dao.memory.cache.frontend.UpdateShoppingCartMsgLineCacheDAO;
import dao.memory.memoryDb.frontend.ShoppingCartMemoryDbDAO;
import dao.memory.repository.frontend.GoodsTablePagesRepositoryDAO;
import listener.ParameterContextListener;
import service.frontend.prepare.FrontendService;
import template.exception.CheckerException;
import transformer.frontend.vo.readin.PageParameterVOTransformer;
import transformer.frontend.vo.writeout.FrontendVOTransformer;
import util.ServletUtil;

@SuppressWarnings("serial")
public class GoFrontendServlet extends HttpServlet {
	
	// url
	public static final String URL = "/vendingMachine/machine";
	private static final String FORWARD_URL = "WEB-INF/frontend/VM_Frontend.jsp";

	// request parameter
	public static final String REQ_PARAM_PAGE = "page";
	public static final String REQ_PARAM_NAME = "name";
	
	// request attribute
	private static final String REQ_ATTR_VO = "vo";
	
	
	private FrontendService frontendService;
	private PageParameterVOTransformer pageParameterVOTransformer;
	private FrontendVOTransformer frontendVOTransformer;
	
	@Override
	public void init() throws ServletException {
		
		frontendService = FrontendService.getInstance();
		pageParameterVOTransformer = PageParameterVOTransformer.getInstance();
		frontendVOTransformer = FrontendVOTransformer.getInstance();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ServletContext context = req.getServletContext();
		HttpSession session = req.getSession();
		
		GoodsTablePagesRepositoryDAO goodsTablePagesRepositoryDAO = ServletUtil.getFrontendGoodsTablePagesRepositoryDAO(session);
		ShoppingCartMemoryDbDAO shoppingCartMemoryDbDAO = ServletUtil.getShoppingCartMemoryDbDAO(session);
		AddShoppingCartIllegalMsgLineCacheDAO addShoppingCartIllegalMsgLineCacheDAO = ServletUtil.getAddShoppingCartIllegalMsgLineCacheDAO(session);
		AddShoppingCartMsgLineCacheDAO addShoppingCartMsgLineCacheDAO = ServletUtil.getAddShoppingCartMsgLineCacheDAO(session);
		ClearShoppingCartMsgLineCacheDAO clearShoppingCartMsgLineCacheDAO = ServletUtil.getClearShoppingCartMsgLineCacheDAO(session);
		UpdateShoppingCartIllegalMsgLineCacheDAO updateShoppingCartIllegalMsgLineCacheDAO = ServletUtil.getUpdateShoppingCartIllegalMsgLineCacheDAO(session);
		UpdateShoppingCartMsgLineCacheDAO updateShoppingCartMsgLineCacheDAO = ServletUtil.getUpdateShoppingCartMsgLineCacheDAO(session);
		ReceiptContentCacheDAO receiptContentCacheDAO = ServletUtil.getReceiptContentCacheDAO(session);
		
		String imagesDirectorySymbolicLinkName = (String)context.getAttribute(ParameterContextListener.CTX_ATTR_IMAGES_DIRECTORY_SYMBOLIC_LINK_NAME);
		MemberModelDTO memberModelDTO = new MemberModelDTO("test", "test", "test");
		PageParameterVO pageParameterVO = getPageParameterVO(req);
		
		try {

			PageParameterVODTO pageParameterVODTO = pageParameterVOTransformer.voToDto(pageParameterVO);
			FrontendVODTO frontendVODTO = frontendService.prepare(pageParameterVODTO, memberModelDTO, imagesDirectorySymbolicLinkName, 
					goodsTablePagesRepositoryDAO, shoppingCartMemoryDbDAO, addShoppingCartIllegalMsgLineCacheDAO, 
					addShoppingCartMsgLineCacheDAO, clearShoppingCartMsgLineCacheDAO, updateShoppingCartIllegalMsgLineCacheDAO,
					updateShoppingCartMsgLineCacheDAO, receiptContentCacheDAO);
			FrontendVO frontendVO = frontendVOTransformer.dtoToVo(frontendVODTO);
			
			req.setAttribute(REQ_ATTR_VO, frontendVO);
			req.getRequestDispatcher(FORWARD_URL).forward(req, resp);
		} catch (CheckerException ex) {
			
			ex.printStackTrace();
		}
	}
	
	private PageParameterVO getPageParameterVO(HttpServletRequest req) {
		
		String pageStr = req.getParameter(REQ_PARAM_PAGE);
		String name = req.getParameter(REQ_PARAM_NAME);
		
		PageParameterVO pageParameterVO = new PageParameterVO();
		
		pageParameterVO.setPage(pageStr);
		pageParameterVO.setName(name);
		
		return pageParameterVO;
	}
}