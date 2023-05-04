package controller.servlet.login.go;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.dto.login.vo.writeout.LoginVODTO;
import bean.dto.obj.statusCache.currentMember.CurrentMemberOBJDTO;
import bean.dto.virtualMachine.obj.memoryDAOKitVM.AccountOBJDTO;
import bean.vo.login.writeout.LoginVO;
import controller.servlet.frontend.go.GoFrontendServlet;
import dao.memory.statusCache.CurrentMemberStatusCacheDAO;
import dao.virtualDevice.memoryDAOKit.MemoryDAOKitVMDAO;
import listener.context.ParameterContextListener;
import service.login.prepare.GoLoginService;
import transformer.login.vo.writeout.LoginVOTransformer;
import util.ServletUtil;

@SuppressWarnings("serial")
public class GoLoginServlet extends HttpServlet {

	// url
	public static final String URL = "/vendingMachine/login";
	private static final String FORWARD_URL = "login.jsp";
	private static final String FRONTEND_URL = GoFrontendServlet.URL;
	
	// request attribute
	private static final String REQ_ATTR_VO = "vo";
	
	private MemoryDAOKitVMDAO memoryDAOKitVMDAO;
	private GoLoginService goLoginService;
	private LoginVOTransformer loginVOTransformer;
	
	@Override
	public void init() throws ServletException {

		memoryDAOKitVMDAO = MemoryDAOKitVMDAO.getInstance();
		goLoginService = GoLoginService.getInstance();
		loginVOTransformer = LoginVOTransformer.getInstance();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ServletContext context = req.getServletContext();
		HttpSession session = req.getSession();

		String imagesDirectoryName = (String)context.getAttribute(ParameterContextListener.CTX_ATTR_IMAGES_DIRECTORY_NAME);
		
		AccountOBJDTO accountOBJDTO = ServletUtil.getAccount(session);
		
		if(hasLogin(accountOBJDTO)) {
			
			resp.sendRedirect(FRONTEND_URL);
		}else {
			
			LoginVODTO loginVODTO = goLoginService.prepare(accountOBJDTO, imagesDirectoryName);
			LoginVO loginVO = loginVOTransformer.dtoToVo(loginVODTO);
			
			req.setAttribute(REQ_ATTR_VO, loginVO);
			req.getRequestDispatcher(FORWARD_URL).forward(req, resp);
		}
	}
	
	private boolean hasLogin(AccountOBJDTO accountOBJDTO) {
		
		CurrentMemberStatusCacheDAO currentMemberStatusCacheDAO = memoryDAOKitVMDAO.getCurrentMemberStatusCacheDAO(accountOBJDTO);
	
		CurrentMemberOBJDTO currentMemberOBJDTO = currentMemberStatusCacheDAO.getStatus();
	
		if(currentMemberOBJDTO!=null)
			return true;
		else
			return false;
	}
}
