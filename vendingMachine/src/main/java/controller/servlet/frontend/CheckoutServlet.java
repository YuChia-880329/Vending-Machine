package controller.servlet.frontend;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import bean.dto.frontend.CheckoutResultDTO;
import bean.dto.frontend.vo.readin.CheckoutVODTO;
import bean.dto.frontend.vo.writeout.AddShoppingCartIllegalMsgLineVODTO;
import bean.vo.frontend.readin.CheckoutVO;
import controller.servlet.frontend.go.GoFrontendServlet;
import dao.memory.cache.frontend.AddShoppingCartIllegalMsgLineCacheDAO;
import dao.memory.cache.frontend.AddShoppingCartMsgLineCacheDAO;
import dao.memory.cache.frontend.ReceiptContentCacheDAO;
import dao.memory.memoryDb.frontend.ShoppingCartMemoryDbDAO;
import dao.memory.repository.backend.goodsList.GoodsTablePagesRepositoryDAO;
import dao.memory.repository.backend.orderList.OrderTablePagesRepositoryDAO;
import service.frontend.CheckoutService;
import template.exception.CheckerException;
import transformer.frontend.vo.readin.CheckoutVOTransformer;
import util.GsonUtil;
import util.ServletUtil;

@SuppressWarnings("serial")
public class CheckoutServlet extends HttpServlet {

	// url
	public static final String URL = "/vendingMachine/machine/checkout";
	private static final String REDIRECT_URL = GoFrontendServlet.URL;
	
	// request parameter
	public static final String REQ_PARAM_DATA_JSON = "dataJson";
	
	
	private CheckoutService checkoutService;
	private CheckoutVOTransformer checkoutVOTransformer;
	private Gson gson;
	
	@Override
	public void init() throws ServletException {
		
		checkoutService = CheckoutService.getInstance();
		checkoutVOTransformer = CheckoutVOTransformer.getInstance();
		gson = GsonUtil.getGson();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		ShoppingCartMemoryDbDAO shoppingCartMemoryDbDAO = ServletUtil.getShoppingCartMemoryDbDAO(session);
		ReceiptContentCacheDAO receiptContentCacheDAO = ServletUtil.getReceiptContentCacheDAO(session);
		GoodsTablePagesRepositoryDAO goodsTablePagesRepositoryDAO = ServletUtil.getGoodsTablePagesRepositoryDAO(session);
		OrderTablePagesRepositoryDAO orderTablePagesRepositoryDAO = ServletUtil.getOrderTablePagesRepositoryDAO(session);
		dao.memory.repository.frontend.GoodsTablePagesRepositoryDAO frontendGoodsTablePagesRepositoryDAO = ServletUtil.getFrontendGoodsTablePagesRepositoryDAO(session);
		AddShoppingCartIllegalMsgLineCacheDAO addShoppingCartIllegalMsgLineCacheDAO = ServletUtil.getAddShoppingCartIllegalMsgLineCacheDAO(session);
		
		
		CheckoutVO checkoutVO = gson.fromJson(req.getParameter(REQ_PARAM_DATA_JSON), CheckoutVO.class);
		
		try {
			
			CheckoutVODTO checkoutVODTO = checkoutVOTransformer.voToDto(checkoutVO);
			CheckoutResultDTO checkoutResultDTO = checkoutService.checkout(checkoutVODTO, 
					shoppingCartMemoryDbDAO, receiptContentCacheDAO, goodsTablePagesRepositoryDAO, 
					orderTablePagesRepositoryDAO, frontendGoodsTablePagesRepositoryDAO, 
					addShoppingCartIllegalMsgLineCacheDAO);
			resp.sendRedirect(ServletUtil.concatQueryString(REDIRECT_URL, checkoutResultDTO.getQueryString()));
		} catch (CheckerException ex) {

			ex.printStackTrace();
			resp.sendRedirect(REDIRECT_URL);
		}
	}
}
