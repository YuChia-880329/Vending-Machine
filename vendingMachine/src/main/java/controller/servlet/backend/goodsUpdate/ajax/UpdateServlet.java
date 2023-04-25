package controller.servlet.backend.goodsUpdate.ajax;

import java.io.IOException;
import java.util.Map;

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
		
		HttpSession session = req.getSession();
		
		GoodsUpdateFormVO goodsUpdateFormVO = getInput(req);
		GoodsTablePagesRepositoryDAO goodsTablePagesRepositoryDAO = getGoodsTablePagesRepositoryDAO(session);
		dao.memory.repository.frontend.GoodsTablePagesRepositoryDAO frontendGoodsTablePagesRepositoryDAO = getFrontendGoodsTablePagesRepositoryDAO(session);
		
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
	private GoodsTablePagesRepositoryDAO getGoodsTablePagesRepositoryDAO(HttpSession session) {
		
		GoodsTablePagesRepositoryDAO goodsTablePagesRepositoryDAO = (GoodsTablePagesRepositoryDAO)session.getAttribute(GoodsTablePagesRepositoryDAO.DAO);
		
		if(goodsTablePagesRepositoryDAO == null) {
			
			GoodsTablePagesRepository goodsTablePagesRepository = new GoodsTablePagesRepository();
			goodsTablePagesRepositoryDAO = new GoodsTablePagesRepositoryDAO(goodsTablePagesRepository);
			
			session.setAttribute(GoodsTablePagesRepositoryDAO.DAO, goodsTablePagesRepositoryDAO);
		}
		
		return goodsTablePagesRepositoryDAO;
	}
	private dao.memory.repository.frontend.GoodsTablePagesRepositoryDAO getFrontendGoodsTablePagesRepositoryDAO(HttpSession session) {
		
		dao.memory.repository.frontend.GoodsTablePagesRepositoryDAO goodsTablePagesRepositoryDAO = (dao.memory.repository.frontend.GoodsTablePagesRepositoryDAO)session.getAttribute(GoodsTablePagesRepositoryDAO.DAO);
		
		if(goodsTablePagesRepositoryDAO == null) {
			
			memory.repository.frontend.GoodsTablePagesRepository goodsTablePagesRepository = new memory.repository.frontend.GoodsTablePagesRepository();
			goodsTablePagesRepositoryDAO = new dao.memory.repository.frontend.GoodsTablePagesRepositoryDAO(goodsTablePagesRepository);
			
			session.setAttribute(dao.memory.repository.frontend.GoodsTablePagesRepositoryDAO.DAO, goodsTablePagesRepositoryDAO);
		}
		
		return goodsTablePagesRepositoryDAO;
	}
}
