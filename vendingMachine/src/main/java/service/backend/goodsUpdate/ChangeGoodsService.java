package service.backend.goodsUpdate;

import java.sql.SQLException;

import bean.dto.backend.goodsUpdate.vo.readin.ChangeGoodsVODTO;
import bean.dto.backend.goodsUpdate.vo.writeout.UpdateFormGoodsVODTO;
import bean.dto.model.GoodsModelDTO;
import service.model.GoodsModelService;

public class ChangeGoodsService {

	private GoodsModelService goodsModelService;
	
	
	private static final ChangeGoodsService INSTANCE = new ChangeGoodsService();
	
	private ChangeGoodsService() {
		
		goodsModelService = GoodsModelService.getInstance();
	}
	
	public static ChangeGoodsService getInstance() {
		
		return INSTANCE;
	}
	
	public UpdateFormGoodsVODTO change(ChangeGoodsVODTO changeGoodsVODTO) {
		
		GoodsModelDTO goodsModelDTO;
		try {
			
			goodsModelDTO = goodsModelService.searchById(changeGoodsVODTO.getId());
			return goodsModelToUpdateFormGoodsVO(goodsModelDTO);
		} catch (SQLException ex) {
			
			ex.printStackTrace();
			return new UpdateFormGoodsVODTO();
		}
	}
	
	private UpdateFormGoodsVODTO goodsModelToUpdateFormGoodsVO(GoodsModelDTO goodsModelDTO) {
		
		UpdateFormGoodsVODTO updateFormGoodsVODTO = new UpdateFormGoodsVODTO();
		
		updateFormGoodsVODTO.setId(goodsModelDTO.getId());
		updateFormGoodsVODTO.setPrice(goodsModelDTO.getPrice());
		updateFormGoodsVODTO.setQuantity(goodsModelDTO.getQuantity());
		updateFormGoodsVODTO.setStatus(goodsModelDTO.getStatus());
		
		return updateFormGoodsVODTO;
	}
}
