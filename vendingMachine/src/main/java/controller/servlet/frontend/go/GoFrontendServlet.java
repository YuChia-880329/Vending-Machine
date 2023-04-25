package controller.servlet.frontend.go;

import java.io.IOException;
import java.util.Map;

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
import dao.memory.memoryDb.frontend.ShoppingCartMemoryDbDAO;
import dao.memory.memoryDb.frontend.FrontendMemoryDbDAOContextListener;
import dao.memory.memoryDb.frontend.MsgMemoryDbDAO;
import dao.memory.repository.frontend.GoodsTablePagesRepositoryDAO;
import dao.memory.repository.frontend.FrontendRepositoryDAOContextListener;
import listener.ParameterContextListener;
import memory.database.frontend.MsgMemoryDb;
import memory.database.frontend.ShoppingCartMemoryDb;
import memory.repository.frontend.GoodsTablePagesRepository;
import service.frontend.prepare.FrontendService;
import template.exception.CheckerException;
import transformer.frontend.vo.readin.PageParameterVOTransformer;
import transformer.frontend.vo.writeout.FrontendVOTransformer;

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
		
		PageParameterVO pageParameterVO = getPageParameterVO(req);

		try {
			MemberModelDTO memberModelDTO = new MemberModelDTO("test", "test", "test");
			PageParameterVODTO pageParameterVODTO = pageParameterVOTransformer.voToDto(pageParameterVO);
			String imagesDirectorySymbolicLinkName = (String)context.getAttribute(ParameterContextListener.CTX_ATTR_IMAGES_DIRECTORY_SYMBOLIC_LINK_NAME);
			GoodsTablePagesRepositoryDAO goodsTablePagesRepositoryDAO = getGoodsTablePagesRepositoryDAO(context, session);
			ShoppingCartMemoryDbDAO shoppingCartMemoryDbDAO = getShoppingCartMemoryDbDAO(context, session);
			MsgMemoryDbDAO illegalMsgMemoryDbDAO = getIllegalMsgMemoryDbDAO(context, session);
			FrontendVODTO frontendVODTO = frontendService.prepare(pageParameterVODTO, imagesDirectorySymbolicLinkName, 
					goodsTablePagesRepositoryDAO, memberModelDTO, shoppingCartMemoryDbDAO, illegalMsgMemoryDbDAO);
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
	private GoodsTablePagesRepositoryDAO getGoodsTablePagesRepositoryDAO(ServletContext context, HttpSession session) {
		
		@SuppressWarnings("unchecked")
		Map<HttpSession, GoodsTablePagesRepositoryDAO> goodsTablePagesRepositoryDAOMap = (Map<HttpSession, GoodsTablePagesRepositoryDAO>)context.getAttribute(FrontendRepositoryDAOContextListener.GOODS_TABLE_PAGES_DAO_MAP);
		
		GoodsTablePagesRepositoryDAO goodsTablePagesRepositoryDAO = goodsTablePagesRepositoryDAOMap.get(session);
		
		if(goodsTablePagesRepositoryDAO == null) {
			
			GoodsTablePagesRepository goodsTablePagesRepository = new GoodsTablePagesRepository();
			goodsTablePagesRepositoryDAO = new GoodsTablePagesRepositoryDAO(goodsTablePagesRepository);
			
			goodsTablePagesRepositoryDAOMap.put(session, goodsTablePagesRepositoryDAO);
		}
		
		return goodsTablePagesRepositoryDAO;
	}
	private ShoppingCartMemoryDbDAO getShoppingCartMemoryDbDAO(ServletContext context, HttpSession session) {
		
		@SuppressWarnings("unchecked")
		Map<HttpSession, ShoppingCartMemoryDbDAO> shoppingCartMemoryDbDAOMap = (Map<HttpSession, ShoppingCartMemoryDbDAO>)context.getAttribute(FrontendMemoryDbDAOContextListener.SHOPPING_CART_DAO_MAP);
		
		ShoppingCartMemoryDbDAO shoppingCartMemoryDbDAO = shoppingCartMemoryDbDAOMap.get(session);
		
		if(shoppingCartMemoryDbDAO == null) {
			
			ShoppingCartMemoryDb shoppingCartMemoryDb = new ShoppingCartMemoryDb();
			shoppingCartMemoryDbDAO = new ShoppingCartMemoryDbDAO(shoppingCartMemoryDb);
			
			shoppingCartMemoryDbDAOMap.put(session, shoppingCartMemoryDbDAO);
		}
		
		return shoppingCartMemoryDbDAO;
	}
	private MsgMemoryDbDAO getIllegalMsgMemoryDbDAO(ServletContext context, HttpSession session) {
		
		@SuppressWarnings("unchecked")
		Map<HttpSession, MsgMemoryDbDAO> illegalMsgMemoryDbDAOMap = (Map<HttpSession, MsgMemoryDbDAO>)context.getAttribute(FrontendMemoryDbDAOContextListener.ILLEGAL_MSG_DAO_MAP);
		
		MsgMemoryDbDAO illegalMsgMemoryDbDAO = illegalMsgMemoryDbDAOMap.get(session);
		
		if(illegalMsgMemoryDbDAO == null) {
			
			MsgMemoryDb illegalMsgMemoryDb = new MsgMemoryDb();
			illegalMsgMemoryDbDAO = new MsgMemoryDbDAO(illegalMsgMemoryDb);
			
			illegalMsgMemoryDbDAOMap.put(session, illegalMsgMemoryDbDAO);
		}
		
		return illegalMsgMemoryDbDAO;
	}
}