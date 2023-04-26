package dao.memory.cache.frontend;

import bean.dto.frontend.obj.cache.clearShoppingCartMsg.ClearShoppingCartMsgOBJDTO;
import bean.obj.frontend.cache.clearShoppingCartMsg.ClearShoppingCartMsgOBJ;
import memory.cache.frontend.ClearShoppingCartMsgCache;
import template.memory.cache.CacheDAOTemplate;
import transformer.frontend.obj.cache.clearShoppingCartMsg.ClearShoppingCartMsgOBJTransformer;

public class ClearShoppingCartMsgCacheDAO extends CacheDAOTemplate<ClearShoppingCartMsgOBJ, ClearShoppingCartMsgCache, 
				ClearShoppingCartMsgOBJDTO, ClearShoppingCartMsgOBJTransformer> {

	public static final String SESSION_ATTR_DAO = "clearShoppingCartMsgCacheDAO";
	
	public ClearShoppingCartMsgCacheDAO(ClearShoppingCartMsgCache memory) {
		
		super(memory);
	}
	

	@Override
	protected ClearShoppingCartMsgOBJTransformer getTransformer() {
		
		return ClearShoppingCartMsgOBJTransformer.getInstance();
	}

}
