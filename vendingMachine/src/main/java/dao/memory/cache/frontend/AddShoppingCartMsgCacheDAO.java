package dao.memory.cache.frontend;

import bean.dto.frontend.obj.cache.addShoppingCartMsg.AddShoppingCartMsgOBJDTO;
import bean.obj.frontend.cache.addShoppingCartMsg.AddShoppingCartMsgOBJ;
import memory.cache.frontend.AddShoppingCartMsgCache;
import template.memory.cache.CacheDAOTemplate;
import transformer.frontend.obj.cache.addShoppingCartMsg.AddShoppingCartMsgOBJTransformer;

public class AddShoppingCartMsgCacheDAO extends CacheDAOTemplate<AddShoppingCartMsgOBJ, AddShoppingCartMsgCache, 
					AddShoppingCartMsgOBJDTO, AddShoppingCartMsgOBJTransformer> {

	public static final String SESSION_ATTR_DAO = "addShoppingCartMsgCacheDAO";
	
	public AddShoppingCartMsgCacheDAO(AddShoppingCartMsgCache cache) {
		
		super(cache);
	}

	@Override
	protected AddShoppingCartMsgOBJTransformer getTransformer() {

		return AddShoppingCartMsgOBJTransformer.getInstance();
	}
}
