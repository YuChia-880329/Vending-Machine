package controller.servlet.backend.go;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class GoBackendGoodsUpdateServlet extends HttpServlet {
	
	public static final String URL = "/vendingMachine/machine/backend/goodsUpdate";
	
	private static final String FORWARD_URL = "../../WEB-INF/backend/VM_Backend_GoodsReplenishment.jsp";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher(FORWARD_URL).forward(req, resp);
	}
}