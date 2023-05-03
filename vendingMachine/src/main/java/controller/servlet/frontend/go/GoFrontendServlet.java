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
import bean.dto.virtualMachine.obj.memoryDAOKitVM.AccountOBJDTO;
import bean.vo.frontend.readin.PageParameterVO;
import bean.vo.frontend.writeout.FrontendVO;
import listener.context.ParameterContextListener;
import service.frontend.prepare.FrontendService;
import template.exception.CheckerException;
import transformer.frontend.vo.readin.PageParameterVOTransformer;
import transformer.frontend.vo.writeout.FrontendVOTransformer;
import util.ServletUtil;

@SuppressWarnings("serial")
public class GoFrontendServlet extends HttpServlet {
	
	// url
	public static final String URL = "/vendingMachine/machine";
	private static final String FORWARD_URL = "WEB-INF/frontend/frontend.jsp";

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
		
		AccountOBJDTO accountOBJDTO = ServletUtil.getAccount(session);
		
		String imagesDirectorySymbolicLinkName = (String)context.getAttribute(ParameterContextListener.CTX_ATTR_IMAGES_DIRECTORY_SYMBOLIC_LINK_NAME);
		MemberModelDTO memberModelDTO = new MemberModelDTO("test", "test", "test");
		PageParameterVO pageParameterVO = getPageParameterVO(req);
		
		try {

			PageParameterVODTO pageParameterVODTO = pageParameterVOTransformer.voToDto(pageParameterVO);
			FrontendVODTO frontendVODTO = frontendService.prepare(pageParameterVODTO, memberModelDTO, imagesDirectorySymbolicLinkName, accountOBJDTO);
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