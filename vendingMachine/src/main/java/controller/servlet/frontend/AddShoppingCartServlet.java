package controller.servlet.frontend;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import bean.dto.frontend.vo.readin.AddShoppingCartVODTO;
import bean.dto.frontend.vo.writeout.AddShoppingCartResultVODTO;
import bean.vo.frontend.readin.AddShoppingCartVO;
import bean.vo.frontend.writeout.AddShoppingCartResultVO;
import controller.servlet.frontend.go.GoFrontendServlet;
import dao.memory.memoryDb.frontend.ShoppingCartMemoryDbDAO;
import dao.memory.memoryDb.frontend.AddShoppingCartMsgMemoryDbDAO;
import memory.database.frontend.AddShoppingCartMsgMemoryDb;
import memory.database.frontend.ShoppingCartMemoryDb;
import service.frontend.AddShoppingCartService;
import template.exception.CheckerException;
import transformer.frontend.vo.readin.AddShoppingCartVOTransformer;
import transformer.frontend.vo.writeout.AddShoppingCartResultVOTransformer;
import util.GsonUtil;
import util.StringConcatUtil;

@SuppressWarnings("serial")
public class AddShoppingCartServlet extends HttpServlet {

	// url
	public static final String URL = "/vendingMachine/machine/addShoppingCart";
	private static final String REDIRECT_URL = GoFrontendServlet.URL;
	
	// request parameter
	public static final String REQ_PARAM_DATA_JSON = "dataJson";
	
	
	private Gson gson;
	private AddShoppingCartVOTransformer shoppingCartVOTransformer;
	private AddShoppingCartService addShoppingCartService;
	private AddShoppingCartResultVOTransformer addShoppingCartResultVOTransformer;
	
	
	@Override
	public void init() throws ServletException {
		
		gson = GsonUtil.getGson();
		shoppingCartVOTransformer = AddShoppingCartVOTransformer.getInstance();
		addShoppingCartService = AddShoppingCartService.getInstance();
		addShoppingCartResultVOTransformer = AddShoppingCartResultVOTransformer.getInstance();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		AddShoppingCartVO shoppingCartVO = getShoppingCartVO(req);
		ShoppingCartMemoryDbDAO shoppingCartMemoryDbDAO = getShoppingCartMemoryDbDAO(session);
		AddShoppingCartMsgMemoryDbDAO illegalMsgMemoryDbDAO = getIllegalMsgMemoryDbDAO(session);
		try {
			
			AddShoppingCartVODTO shoppingCartVODTO = shoppingCartVOTransformer.voToDto(shoppingCartVO);
			AddShoppingCartResultVODTO addShoppingCartResultVODTO = addShoppingCartService.add(shoppingCartVODTO, shoppingCartMemoryDbDAO, illegalMsgMemoryDbDAO);
			AddShoppingCartResultVO addShoppingCartResultVO = addShoppingCartResultVOTransformer.dtoToVo(addShoppingCartResultVODTO);
			
			String url = getRedirectUrl(addShoppingCartResultVO);
			resp.sendRedirect(url);
		} catch (CheckerException ex) {
			
			ex.printStackTrace();
			resp.sendRedirect(REDIRECT_URL);
		}
	}
	
	private AddShoppingCartVO getShoppingCartVO(HttpServletRequest req) {
		
		String dataJson = req.getParameter(REQ_PARAM_DATA_JSON);
		return gson.fromJson(dataJson, AddShoppingCartVO.class);
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
	private AddShoppingCartMsgMemoryDbDAO getIllegalMsgMemoryDbDAO(HttpSession session) {
		
		AddShoppingCartMsgMemoryDbDAO msgMemoryDbDAO = (AddShoppingCartMsgMemoryDbDAO)session.getAttribute(AddShoppingCartMsgMemoryDbDAO.DAO);
		
		if(msgMemoryDbDAO == null) {
			
			AddShoppingCartMsgMemoryDb illegalMsgMemoryDb = new AddShoppingCartMsgMemoryDb();
			msgMemoryDbDAO = new AddShoppingCartMsgMemoryDbDAO(illegalMsgMemoryDb);
			
			session.setAttribute(AddShoppingCartMsgMemoryDbDAO.DAO, msgMemoryDbDAO);
		}
		
		return msgMemoryDbDAO;
	}
	
	private String getRedirectUrl(AddShoppingCartResultVO addShoppingCartResultVO) {
		
		String queryString = addShoppingCartResultVO.getQueryString();
		
		if("".equals(queryString))
			return REDIRECT_URL;
		else
			return StringConcatUtil.concate(REDIRECT_URL, "?", queryString);
	}
}
