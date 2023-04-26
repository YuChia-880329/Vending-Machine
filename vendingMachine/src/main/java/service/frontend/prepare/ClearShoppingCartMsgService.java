package service.frontend.prepare;

import java.util.List;

import bean.dto.frontend.obj.cache.clearShoppingCartMsg.ClearShoppingCartMsgOBJDTO;
import bean.dto.frontend.vo.writeout.ClearShoppingCartMsgVODTO;
import dao.memory.cache.frontend.ClearShoppingCartMsgCacheDAO;
import enumeration.Has;

public class ClearShoppingCartMsgService {

	private static final ClearShoppingCartMsgService INSTANCE = new ClearShoppingCartMsgService();
	
	private ClearShoppingCartMsgService() {
	}
	
	public static ClearShoppingCartMsgService getInstance() {
		
		return INSTANCE;
	}
	
	public ClearShoppingCartMsgVODTO prepare(ClearShoppingCartMsgCacheDAO clearShoppingCartMsgCacheDAO) {
		
		ClearShoppingCartMsgVODTO clearShoppingCartMsgVODTO = new ClearShoppingCartMsgVODTO();
		
		
		List<ClearShoppingCartMsgOBJDTO> clearShoppingCartMsgOBJDTOs = clearShoppingCartMsgCacheDAO.use();
		
		if(clearShoppingCartMsgOBJDTOs.size() > 0) {
			
			ClearShoppingCartMsgOBJDTO clearShoppingCartMsgOBJDTO = clearShoppingCartMsgOBJDTOs.get(0);
			if(clearShoppingCartMsgOBJDTO!=null && clearShoppingCartMsgOBJDTO.getHasMsg()==Has.TRUE) {
				
				clearShoppingCartMsgVODTO.setHasMsg(Has.TRUE);
			}else {
				
				clearShoppingCartMsgVODTO.setHasMsg(Has.FALSE);
			}
		}else {
			
			clearShoppingCartMsgVODTO.setHasMsg(Has.FALSE);
		}
		
		return clearShoppingCartMsgVODTO;
	}
}
