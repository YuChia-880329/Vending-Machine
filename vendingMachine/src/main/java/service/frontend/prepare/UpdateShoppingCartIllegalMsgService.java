package service.frontend.prepare;

import java.util.List;
import java.util.stream.Collectors;

import bean.dto.frontend.obj.cache.updateShoppingCartIllegalMsgLine.UpdateShoppingCartIllegalMsgLineOBJDTO;
import bean.dto.frontend.vo.writeout.UpdateShoppingCartIllegalMsgLineVODTO;
import bean.dto.frontend.vo.writeout.UpdateShoppingCartIllegalMsgVODTO;
import dao.memory.cache.frontend.UpdateShoppingCartIllegalMsgLineCacheDAO;
import enumeration.Has;

public class UpdateShoppingCartIllegalMsgService {

	private static final UpdateShoppingCartIllegalMsgService INSTANCE = new UpdateShoppingCartIllegalMsgService();
	
	private UpdateShoppingCartIllegalMsgService() {
	}
	
	public static UpdateShoppingCartIllegalMsgService getInstance() {
		
		return INSTANCE;
	}
	
	public UpdateShoppingCartIllegalMsgVODTO prepare(UpdateShoppingCartIllegalMsgLineCacheDAO updateShoppingCartIllegalMsgLineCacheDAO) {
		
		UpdateShoppingCartIllegalMsgVODTO updateShoppingCartIllegalMsgVODTO = new UpdateShoppingCartIllegalMsgVODTO();
		
		List<UpdateShoppingCartIllegalMsgLineOBJDTO> updateShoppingCartIllegalMsgLineOBJDTOs = updateShoppingCartIllegalMsgLineCacheDAO.use(true);
		
		updateShoppingCartIllegalMsgVODTO.setHasMsg(updateShoppingCartIllegalMsgLineOBJDTOs.size()>0 ? Has.TRUE : Has.FALSE);
		updateShoppingCartIllegalMsgVODTO.setLines(updateShoppingCartIllegalMsgLineOBJsToUpdateShoppingCartIllegalMsgLineVOs(updateShoppingCartIllegalMsgLineOBJDTOs));
		
		return updateShoppingCartIllegalMsgVODTO;
	}
	
	 
	private List<UpdateShoppingCartIllegalMsgLineVODTO> updateShoppingCartIllegalMsgLineOBJsToUpdateShoppingCartIllegalMsgLineVOs(List<UpdateShoppingCartIllegalMsgLineOBJDTO> updateShoppingCartIllegalMsgLineOBJDTOs){
		
		return updateShoppingCartIllegalMsgLineOBJDTOs.stream()
				.map(updateShoppingCartIllegalMsgLineVODTO -> updateShoppingCartIllegalMsgLineOBJToUpdateShoppingCartIllegalMsgLineVO(updateShoppingCartIllegalMsgLineVODTO))
				.collect(Collectors.toList());
	}
	private UpdateShoppingCartIllegalMsgLineVODTO updateShoppingCartIllegalMsgLineOBJToUpdateShoppingCartIllegalMsgLineVO(UpdateShoppingCartIllegalMsgLineOBJDTO updateShoppingCartIllegalMsgLineOBJDTO) {
		
		UpdateShoppingCartIllegalMsgLineVODTO updateShoppingCartIllegalMsgLineVODTO = new UpdateShoppingCartIllegalMsgLineVODTO();
		
		updateShoppingCartIllegalMsgLineVODTO.setName(updateShoppingCartIllegalMsgLineOBJDTO.getName());
		
		return updateShoppingCartIllegalMsgLineVODTO;
	}
}
