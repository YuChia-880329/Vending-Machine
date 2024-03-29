package controller.servlet.backend.goodsUpdate.ajax;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import bean.dto.backend.goodsUpdate.vo.readin.GoodsUpdateFormVODTO;
import bean.dto.backend.goodsUpdate.vo.writeout.UpdateResultVODTO;
import bean.vo.backend.goodsUpdate.readin.GoodsUpdateFormVO;
import bean.vo.backend.goodsUpdate.writeout.UpdateResultVO;
import service.backend.goodsUpdate.UpdateService;
import template.exception.CheckerException;
import transformer.backend.goodsUpdate.vo.readin.GoodsUpdateFormVOTransformer;
import transformer.backend.goodsUpdate.vo.writeout.UpdateResultVOTransformer;
import util.GsonUtil;
import util.IOUtil;
import util.ServletUtil;

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

		GoodsUpdateFormVO goodsUpdateFormVO = getInput(req);
		
		try {
			
			GoodsUpdateFormVODTO goodsUpdateFormVODTO = goodsUpdateFormVOTransformer.voToDto(goodsUpdateFormVO);
			UpdateResultVODTO updateResultVODTO = updateService.update(goodsUpdateFormVODTO);
			UpdateResultVO updateResultVO = updateResultVOTransformer.dtoToVo(updateResultVODTO);
			resp.getWriter().append(gson.toJson(updateResultVO));
		} catch (CheckerException ex) {

			ex.printStackTrace();
		}
	}
	
	private GoodsUpdateFormVO getInput(HttpServletRequest req) throws IOException {
		
		String requestBodyStr = IOUtil.read(req.getInputStream());
		Map<String, String> requestBody = ServletUtil.getRequestBodyMap(requestBodyStr);
		
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
}
