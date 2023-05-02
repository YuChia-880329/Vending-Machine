package dao.memory.cache.frontend;

import bean.dto.frontend.obj.cache.addShoppingCartIllegalMsgLine.AddShoppingCartIllegalMsgLineOBJDTO;
import bean.obj.frontend.cache.addShoppingCartIllegalMsgLine.AddShoppingCartIllegalMsgLineOBJ;
import memory.cache.frontend.AddShoppingCartIllegalMsgLineCache;
import template.memory.cache.CacheDAOTemplate;
import transformer.frontend.obj.cache.addShoppingCartIllegalMsgLine.AddShoppingCartIllegalMsgLineOBJTransformer;

public class AddShoppingCartIllegalMsgLineCacheDAO extends CacheDAOTemplate< AddShoppingCartIllegalMsgLineOBJ, AddShoppingCartIllegalMsgLineCache, 
				AddShoppingCartIllegalMsgLineOBJDTO, AddShoppingCartIllegalMsgLineOBJTransformer> {

	public static final String SESSION_ATTR_DAO = "addShoppingCartIllegalMsgCacheDAO";
	
	
	public AddShoppingCartIllegalMsgLineCacheDAO() {
		
		super(getInitialCache());
	}
	
	private static AddShoppingCartIllegalMsgLineCache getInitialCache() {
		
		AddShoppingCartIllegalMsgLineCache cache = new AddShoppingCartIllegalMsgLineCache();
		
		return cache;
	}
	
	

	@Override
	protected AddShoppingCartIllegalMsgLineOBJTransformer getTransformer() {
		
		return AddShoppingCartIllegalMsgLineOBJTransformer.getInstance();
	}
}
