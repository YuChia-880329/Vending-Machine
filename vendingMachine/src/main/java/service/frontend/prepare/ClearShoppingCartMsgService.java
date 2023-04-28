package service.frontend.prepare;

import java.util.List;

import bean.dto.frontend.obj.cache.clearShoppingCartMsgLine.ClearShoppingCartMsgLineOBJDTO;
import bean.dto.frontend.vo.writeout.ClearShoppingCartMsgVODTO;
import dao.memory.cache.frontend.ClearShoppingCartMsgLineCacheDAO;
import enumeration.Has;

public class ClearShoppingCartMsgService {

	private static final ClearShoppingCartMsgService INSTANCE = new ClearShoppingCartMsgService();
	
	private ClearShoppingCartMsgService() {
	}
	
	public static ClearShoppingCartMsgService getInstance() {
		
		return INSTANCE;
	}
	
	public ClearShoppingCartMsgVODTO prepare(ClearShoppingCartMsgLineCacheDAO clearShoppingCartMsgLineCacheDAO) {
		
		ClearShoppingCartMsgVODTO clearShoppingCartMsgVODTO = new ClearShoppingCartMsgVODTO();
		
		
		List<ClearShoppingCartMsgLineOBJDTO> clearShoppingCartMsgOBJDTOs = clearShoppingCartMsgLineCacheDAO.use(true);
		
		if(clearShoppingCartMsgOBJDTOs.size() > 0) {
			
			ClearShoppingCartMsgLineOBJDTO clearShoppingCartMsgOBJDTO = clearShoppingCartMsgOBJDTOs.get(0);
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
