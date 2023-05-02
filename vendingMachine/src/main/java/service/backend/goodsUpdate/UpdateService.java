package service.backend.goodsUpdate;

import java.sql.SQLException;

import bean.dto.backend.goodsUpdate.vo.readin.GoodsUpdateFormVODTO;
import bean.dto.backend.goodsUpdate.vo.writeout.UpdateMsgVODTO;
import bean.dto.backend.goodsUpdate.vo.writeout.UpdateResultFormVODTO;
import bean.dto.backend.goodsUpdate.vo.writeout.UpdateResultVODTO;
import bean.dto.model.GoodsModelDTO;
import dao.virtualDevice.memoryDAOKit.MemoryDAOKitVMDAO;
import service.model.GoodsModelService;

public class UpdateService {

	private GoodsModelService goodsModelService;
	private MemoryDAOKitVMDAO memoryDAOKitVMDAO;
	
	private static final UpdateService INSTANCE = new UpdateService();
	
	private UpdateService() {
		
		goodsModelService = GoodsModelService.getInstance();
		memoryDAOKitVMDAO = MemoryDAOKitVMDAO.getInstance();
	}
	
	public static UpdateService getInstance() {
		
		return INSTANCE;
	}
	
	public UpdateResultVODTO update(GoodsUpdateFormVODTO goodsUpdateFormVODTO) {
		
		int id = goodsUpdateFormVODTO.getId();
		int result = 0;
		UpdateResultFormVODTO updateResultFormVODTO = new UpdateResultFormVODTO();
		GoodsModelDTO goodsModelDTO;
		String name = "";
		try {
			
			goodsModelDTO = goodsModelService.searchById(id);
			memoryDAOKitVMDAO.requireUpdateGoodsTablePagesRepositoryDAO();
			memoryDAOKitVMDAO.requireUpdateFrontendGoodsTablePagesRepositoryDAO();
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
			updateMsgVODTO.setSuccess(true);
		else
			updateMsgVODTO.setSuccess(false);

		updateMsgVODTO.setId(id);
		updateMsgVODTO.setName(name);
		
		return updateMsgVODTO;
	}
}
