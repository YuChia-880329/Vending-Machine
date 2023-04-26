package dao.memory.cache.frontend;

import bean.dto.frontend.obj.cache.clearShoppingCartMsgLine.ClearShoppingCartMsgLineOBJDTO;
import bean.obj.frontend.cache.clearShoppingCartMsgLine.ClearShoppingCartMsgLineOBJ;
import memory.cache.frontend.ClearShoppingCartMsgLineCache;
import template.memory.cache.CacheDAOTemplate;
import transformer.frontend.obj.cache.clearShoppingCartMsgLine.ClearShoppingCartMsgLineOBJTransformer;

public class ClearShoppingCartMsgLineCacheDAO extends CacheDAOTemplate<ClearShoppingCartMsgLineOBJ, ClearShoppingCartMsgLineCache, 
				ClearShoppingCartMsgLineOBJDTO, ClearShoppingCartMsgLineOBJTransformer> {

	public static final String SESSION_ATTR_DAO = "clearShoppingCartMsgCacheDAO";
	
	public ClearShoppingCartMsgLineCacheDAO(ClearShoppingCartMsgLineCache memory) {
		
		super(memory);
	}
	

	@Override
	protected ClearShoppingCartMsgLineOBJTransformer getTransformer() {
		
		return ClearShoppingCartMsgLineOBJTransformer.getInstance();
	}

}
