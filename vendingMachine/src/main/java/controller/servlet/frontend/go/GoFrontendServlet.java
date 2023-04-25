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
import dao.memory.memoryDb.frontend.ShoppingCartMemoryDbDAO;
import dao.memory.memoryDb.frontend.AddShoppingCartMsgMemoryDbDAO;
import dao.memory.repository.frontend.GoodsTablePagesRepositoryDAO;
import listener.ParameterContextListener;
import memory.database.frontend.AddShoppingCartMsgMemoryDb;
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
			GoodsTablePagesRepositoryDAO goodsTablePagesRepositoryDAO = getGoodsTablePagesRepositoryDAO(session);
			ShoppingCartMemoryDbDAO shoppingCartMemoryDbDAO = getShoppingCartMemoryDbDAO(session);
			AddShoppingCartMsgMemoryDbDAO addShoppingCartMsgMemoryDbDAO = getAddShoppingCartMsgMemoryDbDAO(session);
			FrontendVODTO frontendVODTO = frontendService.prepare(pageParameterVODTO, imagesDirectorySymbolicLinkName, 
					goodsTablePagesRepositoryDAO, memberModelDTO, shoppingCartMemoryDbDAO, addShoppingCartMsgMemoryDbDAO);
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
	private GoodsTablePagesRepositoryDAO getGoodsTablePagesRepositoryDAO(HttpSession session) {

		GoodsTablePagesRepositoryDAO goodsTablePagesRepositoryDAO = (GoodsTablePagesRepositoryDAO)session.getAttribute(GoodsTablePagesRepositoryDAO.DAO);
		
		if(goodsTablePagesRepositoryDAO == null) {
			
			GoodsTablePagesRepository goodsTablePagesRepository = new GoodsTablePagesRepository();
			goodsTablePagesRepositoryDAO = new GoodsTablePagesRepositoryDAO(goodsTablePagesRepository);
			
			session.setAttribute(GoodsTablePagesRepositoryDAO.DAO, goodsTablePagesRepositoryDAO);
		}
		
		return goodsTablePagesRepositoryDAO;
	}
	private ShoppingCartMemoryDbDAO getShoppingCartMemoryDbDAO(HttpSession session) {
		
		ShoppingCartMemoryDbDAO shoppingCartMemoryDbDAO = (ShoppingCartMemoryDbDAO)session.getAttribute(ShoppingCartMemoryDbDAO.DAO);
		
		if(shoppingCartMemoryDbDAO == null) {
			
			ShoppingCartMemoryDb shoppingCartMemoryDb = new ShoppingCartMemoryDb();
			shoppingCartMemoryDbDAO = new ShoppingCartMemoryDbDAO(shoppingCartMemoryDb);
			
			session.setAttribute(ShoppingCartMemoryDbDAO.DAO, shoppingCartMemoryDbDAO);
		}
		
		return shoppingCartMemoryDbDAO;
	}
	private AddShoppingCartMsgMemoryDbDAO getAddShoppingCartMsgMemoryDbDAO(HttpSession session) {
		
		AddShoppingCartMsgMemoryDbDAO addShoppingCartMsgMemoryDbDAO = (AddShoppingCartMsgMemoryDbDAO)session.getAttribute(AddShoppingCartMsgMemoryDbDAO.DAO);
		
		if(addShoppingCartMsgMemoryDbDAO == null) {
			
			AddShoppingCartMsgMemoryDb addShoppingCartMsgMemoryDb = new AddShoppingCartMsgMemoryDb();
			addShoppingCartMsgMemoryDbDAO = new AddShoppingCartMsgMemoryDbDAO(addShoppingCartMsgMemoryDb);
			
			session.setAttribute(AddShoppingCartMsgMemoryDbDAO.DAO, addShoppingCartMsgMemoryDbDAO);
		}
		
		return addShoppingCartMsgMemoryDbDAO;
	}
}