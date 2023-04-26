package controller.servlet.frontend;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import bean.dto.frontend.vo.readin.ClearShoppingCartVODTO;
import bean.dto.frontend.vo.writeout.ClearShoppingCartResultVODTO;
import bean.vo.frontend.readin.ClearShoppingCartVO;
import bean.vo.frontend.writeout.ClearShoppingCartResultVO;
import controller.servlet.frontend.go.GoFrontendServlet;
import dao.memory.cache.frontend.ClearShoppingCartMsgLineCacheDAO;
import dao.memory.memoryDb.frontend.ShoppingCartMemoryDbDAO;
import service.frontend.ClearShoppingCartService;
import template.exception.CheckerException;
import transformer.frontend.vo.readin.ClearShoppingCartVOTransformer;
import transformer.frontend.vo.writeout.ClearShoppingCartResultVOTransformer;
import util.GsonUtil;
import util.ServletUtil;
import util.StringConcatUtil;

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
	private ClearShoppingCartResultVOTransformer clearShoppingCartResultVOTransformer;
	
	@Override
	public void init() throws ServletException {
		
		gson = GsonUtil.getGson();
		clearShoppingCartVOTransformer = ClearShoppingCartVOTransformer.getInstance();
		clearShoppingCartService = ClearShoppingCartService.getInstance();
		clearShoppingCartResultVOTransformer = ClearShoppingCartResultVOTransformer.getInstance();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		ShoppingCartMemoryDbDAO shoppingCartMemoryDbDAO = ServletUtil.getShoppingCartMemoryDbDAO(session);
		ClearShoppingCartMsgLineCacheDAO clearShoppingCartMsgLineCacheDAO = ServletUtil.getClearShoppingCartMsgLineCacheDAO(session);
	
		ClearShoppingCartVO clearShoppingCartVO = getClearShoppingCartVO(req);
		
		try {
			
			ClearShoppingCartVODTO clearShoppingCartVODTO = clearShoppingCartVOTransformer.voToDto(clearShoppingCartVO);
			ClearShoppingCartResultVODTO clearShoppingCartResultVODTO = clearShoppingCartService.clear(clearShoppingCartVODTO, shoppingCartMemoryDbDAO, clearShoppingCartMsgLineCacheDAO);
			ClearShoppingCartResultVO clearShoppingCartResultVO = clearShoppingCartResultVOTransformer.dtoToVo(clearShoppingCartResultVODTO);
			resp.sendRedirect(getRedirectUrl(clearShoppingCartResultVO));
		} catch (CheckerException ex) {

			ex.printStackTrace();
			resp.sendRedirect(REDIRECT_URL);
		}
	}
	
	private ClearShoppingCartVO getClearShoppingCartVO(HttpServletRequest req) {
		
		String dataJson = req.getParameter(REQ_PARAM_DATA_JSON);
		return gson.fromJson(dataJson, ClearShoppingCartVO.class);
	}
	
	private String getRedirectUrl(ClearShoppingCartResultVO clearShoppingCartResultVO) {
		
		String queryString = clearShoppingCartResultVO.getQueryString();
		
		if("".equals(queryString))
			return REDIRECT_URL;
		else
			return StringConcatUtil.concate(REDIRECT_URL, "?", queryString);
	}
}
