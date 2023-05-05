package controller.servlet.frontend.ajax;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.dto.virtualMachine.obj.memoryDAOKitVM.AccountOBJDTO;
import service.frontend.GoBackendAjaxService;
import util.ServletUtil;

@SuppressWarnings("serial")
public class GoBackendServlet extends HttpServlet {

	// url
	public static final String URL = "/vendingMachine/machine/goBackend";
		

	private GoBackendAjaxService goBackendAjaxService;
	
	@Override
	public void init() throws ServletException {

		goBackendAjaxService = GoBackendAjaxService.getInstance();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		AccountOBJDTO accountOBJDTO = ServletUtil.getAccount(session);
		
		goBackendAjaxService.clear(accountOBJDTO);
	}
}
