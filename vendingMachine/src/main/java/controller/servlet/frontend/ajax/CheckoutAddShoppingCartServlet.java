package controller.servlet.frontend.ajax;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import bean.dto.frontend.vo.readin.CheckoutAddShoppingCartVODTO;
import bean.dto.virtualMachine.obj.memoryDAOKitVM.AccountOBJDTO;
import bean.vo.frontend.readin.CheckoutAddShoppingCartVO;
import service.frontend.CheckoutAddShoppingCartService;
import template.exception.CheckerException;
import transformer.frontend.vo.readin.CheckoutAddShoppingCartVOTransformer;
import util.GsonUtil;
import util.IOUtil;
import util.ServletUtil;

@SuppressWarnings("serial")
public class CheckoutAddShoppingCartServlet extends HttpServlet {

	// url
	public static final String URL = "/vendingMachine/machine/checkoutAddShoppingCart";
	
	private Gson gson;
	private CheckoutAddShoppingCartService checkoutAddShoppingCartService;
	private CheckoutAddShoppingCartVOTransformer checkoutAddShoppingCartVOTransformer;
	
	
	@Override
	public void init() throws ServletException {

		gson = GsonUtil.getGson();
		checkoutAddShoppingCartService = CheckoutAddShoppingCartService.getInstance();
		checkoutAddShoppingCartVOTransformer = CheckoutAddShoppingCartVOTransformer.getInstance();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		AccountOBJDTO accountOBJDTO = ServletUtil.getAccount(session);
		
		String dataStr = IOUtil.read(req.getInputStream(), false);
		CheckoutAddShoppingCartVO checkoutAddShoppingCartVO = gson.fromJson(dataStr, CheckoutAddShoppingCartVO.class);
		
		try {
			
			CheckoutAddShoppingCartVODTO checkoutAddShoppingCartVODTO = checkoutAddShoppingCartVOTransformer.voToDto(checkoutAddShoppingCartVO);
			checkoutAddShoppingCartService.addShoppingCart(checkoutAddShoppingCartVODTO, accountOBJDTO);
		} catch (CheckerException ex) {
			
			ex.printStackTrace();
		}
	}
}
