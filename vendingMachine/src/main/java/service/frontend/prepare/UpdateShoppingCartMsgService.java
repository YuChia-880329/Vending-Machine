package service.frontend.prepare;

import java.util.List;
import java.util.stream.Collectors;

import bean.dto.frontend.obj.cache.updateShoppingCartMsgLine.UpdateShoppingCartMsgLineOBJDTO;
import bean.dto.frontend.vo.writeout.UpdateShoppingCartMsgLineVODTO;
import bean.dto.frontend.vo.writeout.UpdateShoppingCartMsgVODTO;
import dao.memory.cache.frontend.UpdateShoppingCartMsgLineCacheDAO;

public class UpdateShoppingCartMsgService {

	private static final UpdateShoppingCartMsgService INSTANCE = new UpdateShoppingCartMsgService();
	
	private UpdateShoppingCartMsgService() {
	}
	
	public static UpdateShoppingCartMsgService getInstance() {
		
		return INSTANCE;
	}
	
	public UpdateShoppingCartMsgVODTO prepare(UpdateShoppingCartMsgLineCacheDAO updateShoppingCartMsgLineCacheDAO) {
		
		UpdateShoppingCartMsgVODTO updateShoppingCartMsgVODTO = new UpdateShoppingCartMsgVODTO();
		
		List<UpdateShoppingCartMsgLineOBJDTO> updateShoppingCartMsgLineOBJDTOs = updateShoppingCartMsgLineCacheDAO.use(true);
		
		updateShoppingCartMsgVODTO.setHasMsg(updateShoppingCartMsgLineOBJDTOs.size()>0 ? true : false);
		updateShoppingCartMsgVODTO.setLines(updateShoppingCartMsgLineOBJsToUpdateShoppingCartMsgLineVOs(updateShoppingCartMsgLineOBJDTOs));
		
		return updateShoppingCartMsgVODTO;
	}
	
	private List<UpdateShoppingCartMsgLineVODTO> updateShoppingCartMsgLineOBJsToUpdateShoppingCartMsgLineVOs(List<UpdateShoppingCartMsgLineOBJDTO> updateShoppingCartMsgLineOBJDTOs){
		
		return updateShoppingCartMsgLineOBJDTOs.stream()
				.map(updateShoppingCartMsgLineOBJDTO -> updateShoppingCartMsgLineOBJToUpdateShoppingCartMsgLineVO(updateShoppingCartMsgLineOBJDTO))
				.collect(Collectors.toList());
	}
	private UpdateShoppingCartMsgLineVODTO updateShoppingCartMsgLineOBJToUpdateShoppingCartMsgLineVO(UpdateShoppingCartMsgLineOBJDTO updateShoppingCartMsgLineOBJDTO) {
		
		UpdateShoppingCartMsgLineVODTO updateShoppingCartMsgLineVODTO = new UpdateShoppingCartMsgLineVODTO();
		
		updateShoppingCartMsgLineVODTO.setName(updateShoppingCartMsgLineOBJDTO.getName());
		updateShoppingCartMsgLineVODTO.setBuyQuantity(updateShoppingCartMsgLineOBJDTO.getBuyQuantity());
		
		return updateShoppingCartMsgLineVODTO;
	}
	
	
}
