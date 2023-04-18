package controller.servlet.backend.goodsCreate.ajax;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.google.gson.Gson;

import bean.dto.backend.goodsCreate.vo.readin.CreateFormVODTO;
import bean.dto.backend.goodsCreate.vo.writeout.CreateResultVODTO;
import bean.vo.backend.goodsCreate.readin.CreateFormVO;
import bean.vo.backend.goodsCreate.writeout.CreateResultVO;
import service.backend.goodsCreate.CreateService;
import template.exception.CheckerException;
import transformer.backend.goodsCreate.vo.readin.CreateFormVOTransformer;
import transformer.backend.goodsCreate.vo.writeout.CreateResultVOTransformer;
import util.GsonUtil;

@SuppressWarnings("serial")
@MultipartConfig
public class CreateServlet extends HttpServlet {

	// url
	public static final String URL = "/vendingMachine/machine/backend/goodsCreate/create";
	
	// request parameter
	public static final String REQ_PARAM_NAME = "name";
	public static final String REQ_PARAM_DESCRIPTION = "description";
	public static final String REQ_PARAM_PRICE = "price";
	public static final String REQ_PARAM_QUANTITY = "quantity";
	public static final String REQ_PARAM_IMAGE = "image";
	public static final String REQ_PARAM_STATUS = "status";
	
	// context init parameter
	public static final String CTX_PARAM_DEPLOY_PATH = "deployPath";
	public static final String CTX_PARAM_PROJECT_NAME = "projectName";
	public static final String CTX_PARAM_IMAGES_DIRECTORY_SYMBOLIC_LINK_NAME = "imagesDirectorySymbolicLinkName";
	
	
	private CreateFormVOTransformer createFormVOTransformer;
	private CreateService createService;
	private CreateResultVOTransformer createResultVOTransformer;
	private Gson gson;
	
	@Override
	public void init() throws ServletException {
		
		createFormVOTransformer = CreateFormVOTransformer.getInstance();
		createService = CreateService.getInstance();
		createResultVOTransformer = CreateResultVOTransformer.getInstance();
		gson = GsonUtil.getGson();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ServletContext context = req.getServletContext();
		String deployPath = context.getInitParameter(CTX_PARAM_DEPLOY_PATH);
		String projectName = context.getInitParameter(CTX_PARAM_PROJECT_NAME);
		String imagesDirectorySymbolicLinkName = context.getInitParameter(CTX_PARAM_IMAGES_DIRECTORY_SYMBOLIC_LINK_NAME);
		
		CreateFormVO createFormVO = getCreateFormVODTO(req);
		try {
			
			CreateFormVODTO createFormVODTO = createFormVOTransformer.voToDto(createFormVO);
			CreateResultVODTO createResultVODTO = createService.create(createFormVODTO, deployPath, projectName, imagesDirectorySymbolicLinkName);
			CreateResultVO createResultVO = createResultVOTransformer.dtoToVo(createResultVODTO);
			resp.getWriter().append(gson.toJson(createResultVO));
		} catch (CheckerException ex) {
			
			ex.printStackTrace();
		}
	}
	
	private CreateFormVO getCreateFormVODTO(HttpServletRequest req) throws IOException, ServletException {
		
		String name = req.getParameter(REQ_PARAM_NAME);
		String description = req.getParameter(REQ_PARAM_DESCRIPTION);
		String priceStr = req.getParameter(REQ_PARAM_PRICE);
		String quantityStr = req.getParameter(REQ_PARAM_QUANTITY);
		Part imagePart = req.getPart(REQ_PARAM_IMAGE);
		String statusStr = req.getParameter(REQ_PARAM_STATUS);
		
		CreateFormVO createFormVO = new CreateFormVO();
		
		createFormVO.setName(name);
		createFormVO.setDescription(description);
		createFormVO.setPrice(priceStr);
		createFormVO.setQuantity(quantityStr);
		createFormVO.setImageName(imagePart.getSubmittedFileName());
		createFormVO.setImagePart(imagePart);
		createFormVO.setStatus(statusStr);
		
		return createFormVO;
	}
}
