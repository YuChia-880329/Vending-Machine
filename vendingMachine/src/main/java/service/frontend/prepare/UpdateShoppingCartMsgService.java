package service.frontend.prepare;

import java.util.List;
import java.util.stream.Collectors;

import bean.dto.frontend.obj.cache.updateShoppingCartMsgLine.UpdateShoppingCartMsgLineOBJDTO;
import bean.dto.frontend.vo.writeout.UpdateShoppingCartLegalMsgLineVODTO;
import bean.dto.frontend.vo.writeout.UpdateShoppingCartLegalMsgVODTO;
import dao.memory.cache.frontend.UpdateShoppingCartMsgLineCacheDAO;

public class UpdateShoppingCartMsgService {

	private static final UpdateShoppingCartMsgService INSTANCE = new UpdateShoppingCartMsgService();
	
	private UpdateShoppingCartMsgService() {
	}
	
	public static UpdateShoppingCartMsgService getInstance() {
		
		return INSTANCE;
	}
	
	public UpdateShoppingCartLegalMsgVODTO prepare(UpdateShoppingCartMsgLineCacheDAO updateShoppingCartMsgLineCacheDAO) {
		
		UpdateShoppingCartLegalMsgVODTO updateShoppingCartMsgVODTO = new UpdateShoppingCartLegalMsgVODTO();
		
		List<UpdateShoppingCartMsgLineOBJDTO> updateShoppingCartMsgLineOBJDTOs = updateShoppingCartMsgLineCacheDAO.use(true);
		
		updateShoppingCartMsgVODTO.setHasMsg(updateShoppingCartMsgLineOBJDTOs.size()>0 ? true : false);
		updateShoppingCartMsgVODTO.setLines(updateShoppingCartMsgLineOBJsToUpdateShoppingCartMsgLineVOs(updateShoppingCartMsgLineOBJDTOs));
		
		return updateShoppingCartMsgVODTO;
	}
	
	private List<UpdateShoppingCartLegalMsgLineVODTO> updateShoppingCartMsgLineOBJsToUpdateShoppingCartMsgLineVOs(List<UpdateShoppingCartMsgLineOBJDTO> updateShoppingCartMsgLineOBJDTOs){
		
		return updateShoppingCartMsgLineOBJDTOs.stream()
				.map(updateShoppingCartMsgLineOBJDTO -> updateShoppingCartMsgLineOBJToUpdateShoppingCartMsgLineVO(updateShoppingCartMsgLineOBJDTO))
				.collect(Collectors.toList());
	}
	private UpdateShoppingCartLegalMsgLineVODTO updateShoppingCartMsgLineOBJToUpdateShoppingCartMsgLineVO(UpdateShoppingCartMsgLineOBJDTO updateShoppingCartMsgLineOBJDTO) {
		
		UpdateShoppingCartLegalMsgLineVODTO updateShoppingCartMsgLineVODTO = new UpdateShoppingCartLegalMsgLineVODTO();
		
		updateShoppingCartMsgLineVODTO.setName(updateShoppingCartMsgLineOBJDTO.getName());
		updateShoppingCartMsgLineVODTO.setBuyQuantity(updateShoppingCartMsgLineOBJDTO.getBuyQuantity());
		
		return updateShoppingCartMsgLineVODTO;
	}
	
	
}
