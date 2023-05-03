package controller.servlet.login.ajax;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import bean.dto.login.vo.readin.LoginVODTO;
import bean.dto.login.vo.writeout.LoginResultVODTO;
import bean.dto.virtualMachine.obj.memoryDAOKitVM.AccountOBJDTO;
import bean.vo.login.readin.LoginFormVO;
import bean.vo.login.readin.LoginVO;
import bean.vo.login.writeout.LoginResultVO;
import service.login.LoginService;
import template.exception.CheckerException;
import transformer.login.vo.readin.LoginVOTransformer;
import transformer.login.vo.writeout.LoginResultVOTransformer;
import util.GsonUtil;
import util.ServletUtil;

@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {

	// url
	public static final String URL = "/vendingMachine/login";
	
	// request parameter
	public static final String REQ_PARAM_ACCOUNT = "account";
	public static final String REQ_PARAM_PWD = "pwd";
	
	private LoginVOTransformer loginVOTransformer;
	private LoginService loginService;
	private LoginResultVOTransformer loginResultVOTransformer;
	private Gson gson;
	
	@Override
	public void init() throws ServletException {
		
		loginVOTransformer = LoginVOTransformer.getInstance();
		loginService = LoginService.getInstance();
		loginResultVOTransformer = LoginResultVOTransformer.getInstance();
		gson = GsonUtil.getGson();
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		AccountOBJDTO accountOBJDTO = ServletUtil.getAccount(session);
		
		LoginVO loginVO = getLoginVO(req);
		
		try {
			
			LoginVODTO loginVODTO = loginVOTransformer.voToDto(loginVO);
			LoginResultVODTO loginResultVODTO = loginService.login(loginVODTO, accountOBJDTO);
			LoginResultVO loginResultVO = loginResultVOTransformer.dtoToVo(loginResultVODTO);
			resp.getWriter().append(gson.toJson(loginResultVO));
		} catch (CheckerException ex) {
			
			ex.printStackTrace();
		}
	}
	
	private LoginVO getLoginVO(HttpServletRequest req) {
		
		String account = req.getParameter(REQ_PARAM_ACCOUNT);
		String pwd = req.getParameter(REQ_PARAM_PWD);
		
		LoginVO loginVO = new LoginVO();
		
		LoginFormVO loginFormVO = new LoginFormVO();
		
		loginFormVO.setAccount(account);
		loginFormVO.setPassword(pwd);
		
		loginVO.setLoginForm(loginFormVO);
		
		return loginVO;
	}
}
