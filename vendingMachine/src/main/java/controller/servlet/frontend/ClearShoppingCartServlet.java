package controller.servlet.frontend;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import bean.dto.frontend.ClearShoppingCartResultDTO;
import bean.dto.frontend.vo.readin.ClearShoppingCartVODTO;
import bean.dto.virtualMachine.obj.memoryDAOKitVM.AccountOBJDTO;
import bean.vo.frontend.readin.ClearShoppingCartVO;
import controller.servlet.frontend.go.GoFrontendServlet;
import service.frontend.ClearShoppingCartService;
import template.exception.CheckerException;
import transformer.frontend.vo.readin.ClearShoppingCartVOTransformer;
import util.GsonUtil;
import util.ServletUtil;

@SuppressWarnings("serial")
public class ClearShoppingCartServlet extends HttpServlet {

	// url
	public static final String URL = "/vendingMachine/machine/clearShoppingCart";
	private static final String REDIRECT_URL = GoFrontendServlet.URL;
	
	// request parameter
	public static final String REQ_PARAM_DATA_JSON = "dataJson";
	
	
	private Gson gson;
	private ClearShoppingCartVOTransformer clearShoppingCartVOTransformer;
	private ClearShoppingCartService clearShoppingCartService;
	
	@Override
	public void init() throws ServletException {
		
		gson = GsonUtil.getGson();
		clearShoppingCartVOTransformer = ClearShoppingCartVOTransformer.getInstance();
		clearShoppingCartService = ClearShoppingCartService.getInstance();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		AccountOBJDTO accountOBJDTO = ServletUtil.getAccount(session);
	
		ClearShoppingCartVO clearShoppingCartVO = getClearShoppingCartVO(req);
		
		try {
			
			ClearShoppingCartVODTO clearShoppingCartVODTO = clearShoppingCartVOTransformer.voToDto(clearShoppingCartVO);
			ClearShoppingCartResultDTO clearShoppingCartResultDTO = clearShoppingCartService.clear(clearShoppingCartVODTO, accountOBJDTO);
			resp.sendRedirect(ServletUtil.concatQueryString(REDIRECT_URL, clearShoppingCartResultDTO.getQueryString()));
		} catch (CheckerException ex) {

			ex.printStackTrace();
			resp.sendRedirect(REDIRECT_URL);
		}
	}
	
	private ClearShoppingCartVO getClearShoppingCartVO(HttpServletRequest req) {
		
		String dataJson = req.getParameter(REQ_PARAM_DATA_JSON);
		return gson.fromJson(dataJson, ClearShoppingCartVO.class);
	}
}
