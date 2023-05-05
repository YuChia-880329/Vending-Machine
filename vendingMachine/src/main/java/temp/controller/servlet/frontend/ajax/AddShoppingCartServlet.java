package temp.controller.servlet.frontend.ajax;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import bean.dto.virtualMachine.obj.memoryDAOKitVM.AccountOBJDTO;
import temp.bean.dto.frontend.vo.readin.AddShoppingCartVODTO;
import temp.bean.dto.frontend.vo.writeout.AddShoppingCartResultVODTO;
import temp.bean.vo.frontend.readin.AddShoppingCartVO;
import temp.bean.vo.frontend.writeout.AddShoppingCartResultVO;
import temp.service.frontend.AddShoppingCartService;
import temp.transformer.frontend.vo.readin.AddShoppingCartVOTransformer;
import temp.transformer.frontend.vo.writeout.AddShoppingCartResultVOTransformer;
import template.exception.CheckerException;
import util.GsonUtil;
import util.IOUtil;
import util.ServletUtil;

@SuppressWarnings("serial")
public class AddShoppingCartServlet extends HttpServlet {

	// url
	public static final String URL = "/vendingMachine/machine/tempAddShoppingCart";
	
	
	private Gson gson;
	private AddShoppingCartVOTransformer addShoppingCartVOTransformer;
	private AddShoppingCartService addShoppingCartService;
	private AddShoppingCartResultVOTransformer addShoppingCartResultVOTransformer;
	
	
	@Override
	public void init() throws ServletException {

		gson = GsonUtil.getGson();
		addShoppingCartVOTransformer = AddShoppingCartVOTransformer.getInstance();
		addShoppingCartService = AddShoppingCartService.getInstance();
		addShoppingCartResultVOTransformer = AddShoppingCartResultVOTransformer.getInstance();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		AccountOBJDTO accountOBJDTO = ServletUtil.getAccount(session);
		

		AddShoppingCartVO addShoppingCartVO = gson.fromJson(IOUtil.read(req.getInputStream(), false), AddShoppingCartVO.class);

		try {
			
			AddShoppingCartVODTO addShoppingCartVODTO = addShoppingCartVOTransformer.voToDto(addShoppingCartVO);
			AddShoppingCartResultVODTO addShoppingCartResultVODTO = addShoppingCartService.add(addShoppingCartVODTO, accountOBJDTO);
			AddShoppingCartResultVO addShoppingCartResultVO = addShoppingCartResultVOTransformer.dtoToVo(addShoppingCartResultVODTO);
			resp.getWriter().append(gson.toJson(addShoppingCartResultVO));
		} catch (CheckerException ex) {
			
			ex.printStackTrace();
		}
	}
}
