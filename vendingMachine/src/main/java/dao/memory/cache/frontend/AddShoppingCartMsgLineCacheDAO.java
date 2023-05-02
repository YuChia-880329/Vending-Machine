package dao.memory.cache.frontend;

import bean.dto.frontend.obj.cache.addShoppingCartMsgLine.AddShoppingCartMsgLineOBJDTO;
import bean.obj.frontend.cache.addShoppingCartMsgLine.AddShoppingCartMsgLineOBJ;
import memory.cache.frontend.AddShoppingCartMsgLineCache;
import template.memory.cache.CacheDAOTemplate;
import transformer.frontend.obj.cache.addShoppingCartMsgLine.AddShoppingCartMsgLineOBJTransformer;

public class AddShoppingCartMsgLineCacheDAO extends CacheDAOTemplate<AddShoppingCartMsgLineOBJ, AddShoppingCartMsgLineCache, 
					AddShoppingCartMsgLineOBJDTO, AddShoppingCartMsgLineOBJTransformer> {

	public static final String SESSION_ATTR_DAO = "addShoppingCartMsgCacheDAO";
	
	public AddShoppingCartMsgLineCacheDAO() {
		
		super(getInitialCache());
	}
	
	private static AddShoppingCartMsgLineCache getInitialCache() {
		
		AddShoppingCartMsgLineCache cache = new AddShoppingCartMsgLineCache();
		
		return cache;
	}

	@Override
	protected AddShoppingCartMsgLineOBJTransformer getTransformer() {

		return AddShoppingCartMsgLineOBJTransformer.getInstance();
	}
}
