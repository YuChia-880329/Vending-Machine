package service.frontend.prepare;

import java.util.List;

import bean.dto.frontend.obj.statusCache.clearShoppingCartMsgLine.ClearShoppingCartMsgHasMsgOBJDTO;
import bean.dto.frontend.vo.writeout.ClearShoppingCartMsgVODTO;
import dao.memory.statusCache.frontend.ClearShoppingCartMsgStatusCacheDAO;
import enumeration.Has;

public class ClearShoppingCartMsgService {

	private static final ClearShoppingCartMsgService INSTANCE = new ClearShoppingCartMsgService();
	
	private ClearShoppingCartMsgService() {
	}
	
	public static ClearShoppingCartMsgService getInstance() {
		
		return INSTANCE;
	}
	
	public ClearShoppingCartMsgVODTO prepare(ClearShoppingCartMsgStatusCacheDAO clearShoppingCartMsgLineCacheDAO) {
		
		ClearShoppingCartMsgVODTO clearShoppingCartMsgVODTO = new ClearShoppingCartMsgVODTO();
		
		
		List<ClearShoppingCartMsgHasMsgOBJDTO> clearShoppingCartMsgOBJDTOs = clearShoppingCartMsgLineCacheDAO.use(true);
		
		if(clearShoppingCartMsgOBJDTOs.size() > 0) {
			
			ClearShoppingCartMsgHasMsgOBJDTO clearShoppingCartMsgOBJDTO = clearShoppingCartMsgOBJDTOs.get(0);
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
