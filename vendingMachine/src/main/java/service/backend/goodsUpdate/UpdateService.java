package service.backend.goodsUpdate;

import java.sql.SQLException;

import bean.dto.backend.goodsUpdate.vo.readin.GoodsUpdateFormVODTO;
import bean.dto.backend.goodsUpdate.vo.writeout.UpdateMsgVODTO;
import bean.dto.backend.goodsUpdate.vo.writeout.UpdateResultFormVODTO;
import bean.dto.backend.goodsUpdate.vo.writeout.UpdateResultVODTO;
import bean.dto.model.GoodsModelDTO;
import dao.memory.repository.backend.goodsList.GoodsTablePagesRepositoryDAO;
import service.model.GoodsModelService;

public class UpdateService {
	
	private static String SUCCESS_RESULT_MSG_FORMAT = "已成功更新 id %d 商品 : %s";
	private static String FAILURE_RESULT_MSG = "更新失敗";
	

	private GoodsModelService goodsModelService;
	
	
	private static final UpdateService INSTANCE = new UpdateService();
	
	private UpdateService() {
		
		goodsModelService = GoodsModelService.getInstance();
	}
	
	public static UpdateService getInstance() {
		
		return INSTANCE;
	}
	
	public UpdateResultVODTO update(GoodsUpdateFormVODTO goodsUpdateFormVODTO, 
			GoodsTablePagesRepositoryDAO goodsTablePagesRepositoryDAO, 
			dao.memory.repository.frontend.GoodsTablePagesRepositoryDAO frontendGoodsTablePagesRepositoryDAO) {
		
		int id = goodsUpdateFormVODTO.getId();
		int result = 0;
		UpdateResultFormVODTO updateResultFormVODTO = new UpdateResultFormVODTO();
		GoodsModelDTO goodsModelDTO;
		String name = "";
		try {
			
			goodsModelDTO = goodsModelService.searchById(id);
			goodsTablePagesRepositoryDAO.requireUpdate();
			frontendGoodsTablePagesRepositoryDAO.requireUpdate();
			goodsModelDTO = updateFormGoodsVOToGoodsModel(goodsUpdateFormVODTO, goodsModelDTO);
			updateResultFormVODTO.setQuantity(goodsModelDTO.getQuantity());
			result = goodsModelService.update(goodsModelDTO);
			name = goodsModelDTO.getName();
		} catch (SQLException ex) {
			
			ex.printStackTrace();
			updateResultFormVODTO.setQuantity(goodsUpdateFormVODTO.getAddQuantity());
		}
		
		UpdateResultVODTO updateResultVODTO = new UpdateResultVODTO();
		
		updateResultVODTO.setUpdateMsg(generateUpdateMsgVO(result, id, name));
		updateResultVODTO.setUpdateResultForm(updateResultFormVODTO);
		
		return updateResultVODTO;
	}
	private GoodsModelDTO updateFormGoodsVOToGoodsModel(GoodsUpdateFormVODTO goodsUpdateFormVODTO, GoodsModelDTO oldGoodsModelDTO) {
		
		GoodsModelDTO goodsModelDTO = new GoodsModelDTO();
		
		goodsModelDTO.setId(goodsUpdateFormVODTO.getId());
		goodsModelDTO.setName(oldGoodsModelDTO.getName());
		goodsModelDTO.setDescription(oldGoodsModelDTO.getDescription());
		goodsModelDTO.setPrice(goodsUpdateFormVODTO.getPrice());
		goodsModelDTO.setQuantity(goodsUpdateFormVODTO.getAddQuantity() + oldGoodsModelDTO.getQuantity());
		goodsModelDTO.setImageName(oldGoodsModelDTO.getImageName());
		goodsModelDTO.setStatus(goodsUpdateFormVODTO.getStatus());
		
		return goodsModelDTO;
	}
	private UpdateMsgVODTO generateUpdateMsgVO(int result, int id, String name) {
		
		UpdateMsgVODTO updateMsgVODTO = new UpdateMsgVODTO();
		
		if(result > 0)
			updateMsgVODTO.setMsg(String.format(SUCCESS_RESULT_MSG_FORMAT, id, name));
		else
			updateMsgVODTO.setMsg(FAILURE_RESULT_MSG);
		
		return updateMsgVODTO;
	}
}
