package controller.servlet.backend.goodsUpdate.ajax;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import bean.dto.backend.goodsUpdate.vo.readin.GoodsUpdateFormVODTO;
import bean.dto.backend.goodsUpdate.vo.writeout.UpdateResultVODTO;
import bean.vo.backend.goodsUpdate.readin.GoodsUpdateFormVO;
import bean.vo.backend.goodsUpdate.writeout.UpdateResultVO;
import dao.memory.repository.backend.goodsList.GoodsTablePagesRepositoryDAO;
import dao.memory.repository.backend.goodsList.GoodsTablePagesRepositoryDAOContextListener;
import memory.repository.backend.goodsList.GoodsTablePagesRepository;
import service.backend.goodsUpdate.UpdateService;
import template.exception.CheckerException;
import transformer.backend.goodsUpdate.vo.readin.GoodsUpdateFormVOTransformer;
import transformer.backend.goodsUpdate.vo.writeout.UpdateResultVOTransformer;
import util.GsonUtil;
import util.IOUtil;
import util.RequestUtil;

@SuppressWarnings("serial")
public class UpdateServlet extends HttpServlet {
	
	// url
	public static final String URL = "/vendingMachine/machine/backend/goodsUpdate/update";
	
	// request parameter
	public static final String REQ_PARAM_ID = "id";
	public static final String REQ_PARAM_PRICE = "price";
	public static final String REQ_PARAM_QAUNTITY = "addQuantity";
	public static final String REQ_PARAM_STATUS = "goodStatus";
	
	private GoodsUpdateFormVOTransformer goodsUpdateFormVOTransformer;
	private UpdateService updateService;
	private UpdateResultVOTransformer updateResultVOTransformer;
	private Gson gson;
	
	@Override
	public void init() throws ServletException {
		
		goodsUpdateFormVOTransformer = GoodsUpdateFormVOTransformer.getInstance();
		updateService = UpdateService.getInstance();
		gson = GsonUtil.getGson();
		updateResultVOTransformer = UpdateResultVOTransformer.getInstance();
	}
	
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ServletContext context = req.getServletContext();
		HttpSession session = req.getSession();
		
		GoodsUpdateFormVO goodsUpdateFormVO = getInput(req);
		GoodsTablePagesRepositoryDAO goodsTablePagesRepositoryDAO = getGoodsTablePagesRepositoryDAO(context, session);
		dao.memory.repository.frontend.GoodsTablePagesRepositoryDAO frontendGoodsTablePagesRepositoryDAO = getFrontendGoodsTablePagesRepositoryDAO(context, session);
		
		try {
			
			GoodsUpdateFormVODTO goodsUpdateFormVODTO = goodsUpdateFormVOTransformer.voToDto(goodsUpdateFormVO);
			UpdateResultVODTO updateResultVODTO = updateService.update(goodsUpdateFormVODTO, goodsTablePagesRepositoryDAO, frontendGoodsTablePagesRepositoryDAO);
			UpdateResultVO updateResultVO = updateResultVOTransformer.dtoToVo(updateResultVODTO);
			resp.getWriter().append(gson.toJson(updateResultVO));
		} catch (CheckerException ex) {

			ex.printStackTrace();
		}
	}
	
	private GoodsUpdateFormVO getInput(HttpServletRequest req) throws IOException {
		
		String requestBodyStr = IOUtil.read(req.getInputStream());
		Map<String, String> requestBody = RequestUtil.getRequestBodyMap(requestBodyStr);
		
		String idStr = requestBody.get(REQ_PARAM_ID);
		String priceStr = requestBody.get(REQ_PARAM_PRICE);
		String addQuantityStr = requestBody.get(REQ_PARAM_QAUNTITY);
		String statusStr = requestBody.get(REQ_PARAM_STATUS);
		
		
		GoodsUpdateFormVO goodsUpdateFormVO = new GoodsUpdateFormVO();
		
		goodsUpdateFormVO.setId(idStr);
		goodsUpdateFormVO.setPrice(priceStr);
		goodsUpdateFormVO.setAddQuantity(addQuantityStr);
		goodsUpdateFormVO.setStatus(statusStr);
		
		return goodsUpdateFormVO;
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
		
		dao.memory.repository.frontend.GoodsTablePagesRepositoryDAO goodsTablePagesRepositoryDAO = goodsTablePagesRepositoryDAOMap.get(session);
		
		if(goodsTablePagesRepositoryDAO == null) {
			
			memory.repository.frontend.GoodsTablePagesRepository goodsTablePagesRepository = new memory.repository.frontend.GoodsTablePagesRepository();
			goodsTablePagesRepositoryDAO = new dao.memory.repository.frontend.GoodsTablePagesRepositoryDAO(goodsTablePagesRepository);
			
			goodsTablePagesRepositoryDAOMap.put(session, goodsTablePagesRepositoryDAO);
		}
		
		return goodsTablePagesRepositoryDAO;
	}
}
