package controller.servlet.backend.go;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.dto.backend.goodsUpdate.vo.writeout.BackendGoodsUpdateVODTO;
import bean.vo.backend.goodsUpdate.writeout.BackendGoodsUpdateVO;
import service.backend.goodsUpdate.prepare.GoBackendGoodsUpdateService;
import transformer.backend.goodsUpdate.vo.writeout.BackendGoodsUpdateVOTransformer;

@SuppressWarnings("serial")
public class GoBackendGoodsUpdateServlet extends HttpServlet {
	
	// url
	public static final String URL = "/vendingMachine/machine/backend/goodsUpdate";
	private static final String FORWARD_URL = "../../WEB-INF/backend/backend_goodsUpdate.jsp";

	// attribute
	private static final String REQ_ATTR_VO = "vo";
	
	private GoBackendGoodsUpdateService goBackendGoodsUpdateService;
	private BackendGoodsUpdateVOTransformer backendGoodsUpdateVOTransformer;
	
	@Override
	public void init() throws ServletException {
		
		goBackendGoodsUpdateService = GoBackendGoodsUpdateService.getInstance();
		backendGoodsUpdateVOTransformer = BackendGoodsUpdateVOTransformer.getInstance();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		BackendGoodsUpdateVODTO backendGoodsUpdateVODTO = goBackendGoodsUpdateService.prepare();
		BackendGoodsUpdateVO backendGoodsUpdateVO = backendGoodsUpdateVOTransformer.dtoToVo(backendGoodsUpdateVODTO);
		 
		req.setAttribute(REQ_ATTR_VO, backendGoodsUpdateVO);
		req.getRequestDispatcher(FORWARD_URL).forward(req, resp);
	}
}