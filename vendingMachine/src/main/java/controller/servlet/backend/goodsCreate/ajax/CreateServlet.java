package controller.servlet.backend.goodsCreate.ajax;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.google.gson.Gson;

import bean.dto.backend.goodsCreate.vo.readin.CreateFormVODTO;
import bean.dto.backend.goodsCreate.vo.writeout.CreateResultVODTO;
import bean.vo.backend.goodsCreate.readin.CreateFormVO;
import bean.vo.backend.goodsCreate.writeout.CreateResultVO;
import dao.memory.repository.backend.goodsList.GoodsTablePagesRepositoryDAO;
import dao.memory.repository.backend.goodsList.GoodsTablePagesRepositoryDAOContextListener;
import listener.ParameterContextListener;
import memory.repository.backend.goodsList.GoodsTablePagesRepository;
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
		HttpSession session = req.getSession();
		
		GoodsTablePagesRepositoryDAO goodsTablePagesRepositoryDAO = getGoodsTablePagesRepositoryDAO(context, session);
		dao.memory.repository.frontend.GoodsTablePagesRepositoryDAO frontendGoodsTablePagesRepositoryDAO = getFrontendGoodsTablePagesRepositoryDAO(context, session);
		String imagesDirectorySymbolicLinkName = (String)context.getAttribute(ParameterContextListener.CTX_ATTR_IMAGES_DIRECTORY_SYMBOLIC_LINK_NAME);
		
		
		CreateFormVO createFormVO = getCreateFormVODTO(req);
		try {
			
			CreateFormVODTO createFormVODTO = createFormVOTransformer.voToDto(createFormVO);
			CreateResultVODTO createResultVODTO = createService.create(createFormVODTO, imagesDirectorySymbolicLinkName, goodsTablePagesRepositoryDAO, frontendGoodsTablePagesRepositoryDAO);
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
	private GoodsTablePagesRepositoryDAO getGoodsTablePagesRepositoryDAO(ServletContext context, HttpSession session) {
		
		@SuppressWarnings("unchecked")
		Map<HttpSession, GoodsTablePagesRepositoryDAO> goodsTablePagesRepositoryDAOMap = (Map<HttpSession, GoodsTablePagesRepositoryDAO>)context.getAttribute(GoodsTablePagesRepositoryDAOContextListener.GOODS_TABLE_PAGES_DAO_MAP);
		
		GoodsTablePagesRepositoryDAO goodsTablePagesRepositoryDAO = goodsTablePagesRepositoryDAOMap.get(session);
		
		if(goodsTablePagesRepositoryDAO == null) {
			
			GoodsTablePagesRepository goodsTablePagesRepository = new GoodsTablePagesRepository();
			goodsTablePagesRepositoryDAO = new GoodsTablePagesRepositoryDAO(goodsTablePagesRepository);
			
			goodsTablePagesRepositoryDAOMap.put(session, goodsTablePagesRepositoryDAO);
		}
		
		return goodsTablePagesRepositoryDAO;
	}
	private dao.memory.repository.frontend.GoodsTablePagesRepositoryDAO getFrontendGoodsTablePagesRepositoryDAO(ServletContext context, HttpSession session) {
		
		@SuppressWarnings("unchecked")
		Map<HttpSession, dao.memory.repository.frontend.GoodsTablePagesRepositoryDAO> goodsTablePagesRepositoryDAOMap = (Map<HttpSession, dao.memory.repository.frontend.GoodsTablePagesRepositoryDAO>)context.getAttribute(dao.memory.repository.frontend.GoodsTablePagesRepositoryDAOContextListener.GOODS_TABLE_PAGES_DAO_MAP);
		
		dao.memory.repository.frontend.GoodsTablePagesRepositoryDAO GoodsTablePagesRepositoryDAO = goodsTablePagesRepositoryDAOMap.get(session);
		
		if(GoodsTablePagesRepositoryDAO == null) {
			
			memory.repository.frontend.GoodsTablePagesRepository goodsTablePagesRepository = new memory.repository.frontend.GoodsTablePagesRepository();
			GoodsTablePagesRepositoryDAO = new dao.memory.repository.frontend.GoodsTablePagesRepositoryDAO(goodsTablePagesRepository);
			
			goodsTablePagesRepositoryDAOMap.put(session, GoodsTablePagesRepositoryDAO);
		}
		
		return GoodsTablePagesRepositoryDAO;
	}
}
