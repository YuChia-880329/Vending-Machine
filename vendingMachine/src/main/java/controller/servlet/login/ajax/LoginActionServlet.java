package controller.servlet.login.ajax;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import bean.dto.login.vo.readin.LoginActionVODTO;
import bean.dto.login.vo.writeout.LoginResultVODTO;
import bean.dto.virtualMachine.obj.memoryDAOKitVM.AccountOBJDTO;
import bean.vo.login.readin.LoginFormVO;
import bean.vo.login.readin.LoginActionVO;
import bean.vo.login.writeout.LoginResultVO;
import service.login.LoginActionService;
import template.exception.CheckerException;
import transformer.login.vo.readin.LoginActionVOTransformer;
import transformer.login.vo.writeout.LoginResultVOTransformer;
import util.GsonUtil;
import util.ServletUtil;

@SuppressWarnings("serial")
public class LoginActionServlet extends HttpServlet {

	// url
	public static final String URL = "/vendingMachine/loginAction";
	
	// request parameter
	public static final String REQ_PARAM_ACCOUNT = "account";
	public static final String REQ_PARAM_PWD = "pwd";
	
	private LoginActionVOTransformer loginVOTransformer;
	private LoginActionService loginService;
	private LoginResultVOTransformer loginResultVOTransformer;
	private Gson gson;
	
	@Override
	public void init() throws ServletException {
		
		loginVOTransformer = LoginActionVOTransformer.getInstance();
		loginService = LoginActionService.getInstance();
		loginResultVOTransformer = LoginResultVOTransformer.getInstance();
		gson = GsonUtil.getGson();
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		AccountOBJDTO accountOBJDTO = ServletUtil.getAccount(session);
		
		LoginActionVO loginActionVO = getLoginVO(req);
		
		try {
			
			LoginActionVODTO loginActionVODTO = loginVOTransformer.voToDto(loginActionVO);
			LoginResultVODTO loginResultVODTO = loginService.login(loginActionVODTO, accountOBJDTO);
			LoginResultVO loginResultVO = loginResultVOTransformer.dtoToVo(loginResultVODTO);
			resp.getWriter().append(gson.toJson(loginResultVO));
		} catch (CheckerException ex) {
			
			ex.printStackTrace();
		}
	}
	
	private LoginActionVO getLoginVO(HttpServletRequest req) {
		
		String account = req.getParameter(REQ_PARAM_ACCOUNT);
		String pwd = req.getParameter(REQ_PARAM_PWD);
		
		LoginActionVO loginVO = new LoginActionVO();
		
		LoginFormVO loginFormVO = new LoginFormVO();
		
		loginFormVO.setAccount(account);
		loginFormVO.setPassword(pwd);
		
		loginVO.setLoginForm(loginFormVO);
		
		return loginVO;
	}
}
