package controller.servlet.frontend;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import bean.dto.frontend.vo.readin.UpdateShoppingCartVODTO;
import bean.dto.frontend.vo.writeout.UpdateShoppingCartResultVODTO;
import bean.vo.frontend.readin.UpdateShoppingCartVO;
import bean.vo.frontend.writeout.UpdateShoppingCartResultVO;
import controller.servlet.frontend.go.GoFrontendServlet;
import dao.memory.cache.frontend.UpdateShoppingCartIllegalMsgLineCacheDAO;
import dao.memory.cache.frontend.UpdateShoppingCartMsgLineCacheDAO;
import dao.memory.memoryDb.frontend.ShoppingCartMemoryDbDAO;
import service.frontend.UpdateShoppingCartService;
import template.exception.CheckerException;
import transformer.frontend.vo.readin.UpdateShoppingCartVOTransformer;
import transformer.frontend.vo.writeout.UpdateShoppingCartResultVOTransformer;
import util.GsonUtil;
import util.ServletUtil;

@SuppressWarnings("serial")
public class UpdateShoppingCartServlet extends HttpServlet {
	
	// url
	public static final String URL = "/vendingMachine/machine/updateShoppingCart";
	private static final String REDIRECT_URL = GoFrontendServlet.URL;

	// request parameter
	public static final String REQ_PARAM_DATA_JSON = "dataJson";
	
	
	private Gson gson;
	private UpdateShoppingCartVOTransformer updateShoppingCartVOTransformer;
	private UpdateShoppingCartService updateShoppingCartService;
	private UpdateShoppingCartResultVOTransformer updateShoppingCartResultVOTransformer;
	
	
	@Override
	public void init() throws ServletException {
		
		gson = GsonUtil.getGson();
		updateShoppingCartVOTransformer = UpdateShoppingCartVOTransformer.getInstance();
		updateShoppingCartService = UpdateShoppingCartService.getInstance();
		updateShoppingCartResultVOTransformer = UpdateShoppingCartResultVOTransformer.getInstance();
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		
		ShoppingCartMemoryDbDAO shoppingCartMemoryDbDAO = ServletUtil.getShoppingCartMemoryDbDAO(session);
		UpdateShoppingCartIllegalMsgLineCacheDAO updateShoppingCartIllegalMsgLineCacheDAO = ServletUtil.getUpdateShoppingCartIllegalMsgLineCacheDAO(session);
		UpdateShoppingCartMsgLineCacheDAO updateShoppingCartMsgLineCacheDAO = ServletUtil.getUpdateShoppingCartMsgLineCacheDAO(session);
		
		UpdateShoppingCartVO updateShoppingCartVO = gson.fromJson(req.getParameter(REQ_PARAM_DATA_JSON), UpdateShoppingCartVO.class);
		
		try {
			
			UpdateShoppingCartVODTO updateShoppingCartVODTO = updateShoppingCartVOTransformer.voToDto(updateShoppingCartVO);
			UpdateShoppingCartResultVODTO updateShoppingCartResultVODTO = updateShoppingCartService.update(updateShoppingCartVODTO, shoppingCartMemoryDbDAO, 
					updateShoppingCartIllegalMsgLineCacheDAO, updateShoppingCartMsgLineCacheDAO);
			UpdateShoppingCartResultVO updateShoppingCartResultVO =updateShoppingCartResultVOTransformer.dtoToVo(updateShoppingCartResultVODTO);
		
			resp.sendRedirect(ServletUtil.concatQueryString(REDIRECT_URL, updateShoppingCartResultVO.getQueryString()));
		} catch (CheckerException ex) {
			
			ex.printStackTrace();
			resp.sendRedirect(REDIRECT_URL);
		}
	}
}
