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
	
	
	public static final String IMAGE_DIRECTORY_PATH = "vendingMachine/images";
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
	}
}
