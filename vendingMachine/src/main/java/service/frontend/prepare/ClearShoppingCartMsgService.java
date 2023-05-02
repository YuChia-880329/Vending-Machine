package service.frontend.prepare;

import bean.dto.frontend.obj.statusCache.clearShoppingCartMsgLine.ClearShoppingCartMsgHasMsgOBJDTO;
import bean.dto.frontend.vo.writeout.ClearShoppingCartMsgVODTO;
import dao.memory.statusCache.frontend.ClearShoppingCartMsgStatusCacheDAO;

public class ClearShoppingCartMsgService {

	private static final ClearShoppingCartMsgService INSTANCE = new ClearShoppingCartMsgService();
	
	private ClearShoppingCartMsgService() {
	}
	
	public static ClearShoppingCartMsgService getInstance() {
		
		return INSTANCE;
	}
	
	public ClearShoppingCartMsgVODTO prepare(ClearShoppingCartMsgStatusCacheDAO clearShoppingCartMsgStatusCacheDAO) {

		ClearShoppingCartMsgVODTO clearShoppingCartMsgVODTO = new ClearShoppingCartMsgVODTO();
		
		ClearShoppingCartMsgHasMsgOBJDTO clearShoppingCartMsgOBJDTO = clearShoppingCartMsgStatusCacheDAO.getStatus();

		clearShoppingCartMsgVODTO.setHasMsg(clearShoppingCartMsgOBJDTO.getHasMsg());
		
		clearShoppingCartMsgStatusCacheDAO.setStatus(new ClearShoppingCartMsgHasMsgOBJDTO(false));
		
		return clearShoppingCartMsgVODTO;
	}
}
