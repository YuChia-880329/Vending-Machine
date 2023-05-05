package temp.controller.servlet.frontend.ajax;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import bean.dto.virtualMachine.obj.memoryDAOKitVM.AccountOBJDTO;
import temp.bean.dto.frontend.vo.readin.UpdateShoppingCartVODTO;
import temp.bean.dto.frontend.vo.writeout.UpdateShoppingCartResultVODTO;
import temp.bean.vo.frontend.readin.UpdateShoppingCartVO;
import temp.bean.vo.frontend.writeout.UpdateShoppingCartResultVO;
import temp.service.frontend.UpdateShoppingCartService;
import temp.transformer.frontend.vo.readin.UpdateShoppingCartVOTransformer;
import temp.transformer.frontend.vo.writeout.UpdateShoppingCartResultVOTransformer;
import template.exception.CheckerException;
import util.GsonUtil;
import util.IOUtil;
import util.ServletUtil;

@SuppressWarnings("serial")
public class UpdateShoppingCartServlet extends HttpServlet {

	// url
	public static final String URL = "/vendingMachine/machine/tempUpdateShoppingCart";
	
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
		
		AccountOBJDTO accountOBJDTO = ServletUtil.getAccount(session);
		
		UpdateShoppingCartVO updateShoppingCartVO = gson.fromJson(IOUtil.read(req.getInputStream(), false), UpdateShoppingCartVO.class);

		try {
			
			UpdateShoppingCartVODTO updateShoppingCartVODTO = updateShoppingCartVOTransformer.voToDto(updateShoppingCartVO);
			UpdateShoppingCartResultVODTO updateShoppingCartResultVODTO = updateShoppingCartService.update(updateShoppingCartVODTO, accountOBJDTO);
			UpdateShoppingCartResultVO updateShoppingCartResultVO = updateShoppingCartResultVOTransformer.dtoToVo(updateShoppingCartResultVODTO);
			resp.getWriter().append(gson.toJson(updateShoppingCartResultVO));
		} catch (CheckerException ex) {
			
			ex.printStackTrace();
		}
	}
}
