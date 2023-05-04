package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.dto.login.obj.statusCache.currentMember.CurrentMemberOBJDTO;
import bean.dto.login.obj.statusCache.notLoginMsg.NotLoginMsgOBJDTO;
import bean.dto.virtualMachine.obj.memoryDAOKitVM.AccountOBJDTO;
import controller.servlet.login.go.GoLoginServlet;
import dao.memory.statusCache.login.CurrentMemberStatusCacheDAO;
import dao.memory.statusCache.login.NotLoginMsgStatusCacheDAO;
import dao.virtualDevice.memoryDAOKit.MemoryDAOKitVMDAO;
import util.ServletUtil;

public class MemberFilter implements Filter {

	private static final String LOGIN_URL = GoLoginServlet.URL;
	
	private MemoryDAOKitVMDAO memoryDAOKitVMDAO;
	

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	
		Filter.super.init(filterConfig);
		
		memoryDAOKitVMDAO = MemoryDAOKitVMDAO.getInstance();
	}


	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		
		HttpSession session = req.getSession();
		
		AccountOBJDTO accountOBJDTO = ServletUtil.getAccount(session);
		CurrentMemberStatusCacheDAO currentMemberStatusCacheDAO = memoryDAOKitVMDAO.getCurrentMemberStatusCacheDAO(accountOBJDTO);
		NotLoginMsgStatusCacheDAO notLoginMsgStatusCacheDAO = memoryDAOKitVMDAO.getNotLoginMsgStatusCacheDAO(accountOBJDTO);
		
		
		CurrentMemberOBJDTO currentMemberOBJDTO = currentMemberStatusCacheDAO.getStatus();
	
		if(currentMemberOBJDTO == null) {
			
			notLoginMsgStatusCacheDAO.setStatus(new NotLoginMsgOBJDTO(true));
			resp.sendRedirect(LOGIN_URL);
		}else {
			
			chain.doFilter(req, resp);
		}
	}
	

}
