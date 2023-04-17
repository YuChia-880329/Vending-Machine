package controller.servlet.backend.goodsUpdate.ajax;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import bean.dto.backend.goodsUpdate.vo.readin.ChangeGoodsVODTO;
import bean.dto.backend.goodsUpdate.vo.writeout.UpdateFormGoodsVODTO;
import bean.vo.backend.goodsUpdate.readin.ChangeGoodsVO;
import bean.vo.backend.goodsUpdate.writeout.UpdateFormGoodsVO;
import service.backend.goodsUpdate.ChangeGoodsService;
import template.exception.CheckerException;
import transformer.backend.goodsUpdate.vo.readin.ChangeGoodsVOTransformer;
import transformer.backend.goodsUpdate.vo.writeout.UpdateFormGoodsVOTransformer;
import util.GsonUtil;

@SuppressWarnings("serial")
public class ChangeGoodsServlet extends HttpServlet {

	// url
	public static final String URL = "/vendingMachine/machine/backend/goodsUpdate/change";
	
	// request parameter
	public static final String REQ_PARAM_ID = "id";
	
	
	private ChangeGoodsVOTransformer changeGoodsVOTransformer;
	private ChangeGoodsService changeGoodsService;
	private UpdateFormGoodsVOTransformer updateFormGoodsVOTransformer;
	private Gson gson;

	@Override
	public void init() throws ServletException {

		changeGoodsVOTransformer = ChangeGoodsVOTransformer.getInstance();
		changeGoodsService = ChangeGoodsService.getInstance();
		updateFormGoodsVOTransformer = UpdateFormGoodsVOTransformer.getInstance();
		gson = GsonUtil.getGson();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ChangeGoodsVO changeGoodsVO = getChangeGoodsVO(req);
		try {
			
			ChangeGoodsVODTO changeGoodsVODTO = changeGoodsVOTransformer.voToDto(changeGoodsVO);
			UpdateFormGoodsVODTO updateFormGoodsVODTO = changeGoodsService.change(changeGoodsVODTO);
			UpdateFormGoodsVO updateFormGoodsVO = updateFormGoodsVOTransformer.dtoToVo(updateFormGoodsVODTO);
			
			resp.getWriter().append(gson.toJson(updateFormGoodsVO));
		} catch (CheckerException ex) {
			
			ex.printStackTrace();
		}
		
	}
	
	private ChangeGoodsVO getChangeGoodsVO(HttpServletRequest req) {
		
		String idStr = req.getParameter(REQ_PARAM_ID);
		
		ChangeGoodsVO changeGoodsVO = new ChangeGoodsVO();
		
		changeGoodsVO.setId(idStr);
		
		return changeGoodsVO;
	}
}
