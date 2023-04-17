package controller.servlet.backend.goodsCreate.ajax;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class CreateServlet extends HttpServlet {

	// url
	public static final String URL = "/vendingMachine/machine/backend/goodsCreate/create";
	
	
	// context init parameter
	private static final String CTX_PARAM_DEPLOY_PATH = "deployPath";
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println(req.getContextPath());
		
	}
}
