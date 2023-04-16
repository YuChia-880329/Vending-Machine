package service.backend.goodsUpdate;

import bean.dto.backend.goodsUpdate.vo.writeout.UpdateFormGoodsVODTO;
import bean.dto.backend.goodsUpdate.vo.writeout.UpdateInputVODTO;
import bean.dto.backend.goodsUpdate.vo.writeout.UpdateMsgVODTO;
import bean.dto.backend.goodsUpdate.vo.writeout.UpdateResultVODTO;
import bean.dto.model.GoodsModelDTO;
import service.model.GoodsModelService;

public class UpdateService {
	
	private static String SUCCESS_RESULT_MSG_FORMAT = "已成功更新 id %d 商品";
	private static String FAILURE_RESULT_MSG = "更新失敗";
	

	private GoodsModelService goodsModelService;
	
	
	private static final UpdateService INSTANCE = new UpdateService();
	
	private UpdateService() {
		
		goodsModelService = GoodsModelService.getInstance();
	}
	
	public static UpdateService getInstance() {
		
		return INSTANCE;
	}
	
	public UpdateResultVODTO update(UpdateInputVODTO updateInputVODTO) {
		
		UpdateFormGoodsVODTO updateFormGoodsVODTO = updateInputVODTO.getUpdateFormGoods();
		int id = updateFormGoodsVODTO.getId();
		GoodsModelDTO goodsModelDTO = goodsModelService.searchById(id);
		goodsModelDTO = updateFormGoodsVOToGoodsModel(updateFormGoodsVODTO, goodsModelDTO);
		int result = goodsModelService.update(goodsModelDTO);
		
		UpdateResultVODTO updateResultVODTO = new UpdateResultVODTO();
		updateResultVODTO.setUpdateMsg(generateUpdateMsgVO(result, id));
		return updateResultVODTO;
	}
	private GoodsModelDTO updateFormGoodsVOToGoodsModel(UpdateFormGoodsVODTO updateFormGoodsVODTO, GoodsModelDTO oldGoodsModelDTO) {
		
		GoodsModelDTO goodsModelDTO = new GoodsModelDTO();
		
		goodsModelDTO.setId(updateFormGoodsVODTO.getId());
		goodsModelDTO.setName(oldGoodsModelDTO.getName());
		goodsModelDTO.setDescription(oldGoodsModelDTO.getDescription());
		goodsModelDTO.setPrice(oldGoodsModelDTO.getPrice());
		goodsModelDTO.setQuantity(updateFormGoodsVODTO.getQuantity());
		goodsModelDTO.setImageName(oldGoodsModelDTO.getImageName());
		goodsModelDTO.setStatus(updateFormGoodsVODTO.getStatus());
		
		return goodsModelDTO;
	}
	private UpdateMsgVODTO generateUpdateMsgVO(int result, int id) {
		
		UpdateMsgVODTO updateMsgVODTO = new UpdateMsgVODTO();
		
		if(result > 0)
			updateMsgVODTO.setMsg(String.format(SUCCESS_RESULT_MSG_FORMAT, id));
		else
			updateMsgVODTO.setMsg(FAILURE_RESULT_MSG);
		
		return updateMsgVODTO;
	}
}
