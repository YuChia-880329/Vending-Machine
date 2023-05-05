package temp.controller.servlet.frontend.ajax;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import bean.dto.virtualMachine.obj.memoryDAOKitVM.AccountOBJDTO;
import temp.bean.dto.frontend.vo.readin.CheckoutVODTO;
import temp.bean.dto.frontend.vo.writeout.CheckoutResultVODTO;
import temp.bean.vo.frontend.readin.CheckoutVO;
import temp.bean.vo.frontend.writeout.CheckoutResultVO;
import temp.service.frontend.CheckoutService;
import temp.transformer.frontend.vo.readin.CheckoutVOTransformer;
import temp.transformer.frontend.vo.writeout.CheckoutResultVOTransformer;
import template.exception.CheckerException;
import util.GsonUtil;
import util.IOUtil;
import util.ServletUtil;

@SuppressWarnings("serial")
public class CheckoutServlet extends HttpServlet {

	// url
	public static final String URL = "/vendingMachine/machine/tempCheckout";
	
	private Gson gson;
	private CheckoutVOTransformer checkoutVOTransformer;
	private CheckoutService checkoutService;
	private CheckoutResultVOTransformer checkoutResultVOTransformer;
	
	@Override
	public void init() throws ServletException {

		gson = GsonUtil.getGson();
		checkoutVOTransformer = CheckoutVOTransformer.getInstance();
		checkoutService = CheckoutService.getInstance();
		checkoutResultVOTransformer = CheckoutResultVOTransformer.getInstance();
	}
		
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		AccountOBJDTO accountOBJDTO = ServletUtil.getAccount(session);
		
		CheckoutVO checkoutVO = gson.fromJson(IOUtil.read(req.getInputStream(), false), CheckoutVO.class);
		try {
			
			CheckoutVODTO checkoutVODTO = checkoutVOTransformer.voToDto(checkoutVO);
			CheckoutResultVODTO checkoutResultVODTO = checkoutService.checkout(checkoutVODTO, accountOBJDTO);
			CheckoutResultVO checkoutResultVO = checkoutResultVOTransformer.dtoToVo(checkoutResultVODTO);
			resp.getWriter().append(gson.toJson(checkoutResultVO));
		} catch (CheckerException ex) {
			
			ex.printStackTrace();
		}
	}
}
