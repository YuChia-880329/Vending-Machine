package dao.memory.cache.frontend;

import bean.dto.frontend.obj.cache.updateShoppingCartMsgLine.UpdateShoppingCartMsgLineOBJDTO;
import bean.obj.frontend.cache.updateShoppingCartMsgLine.UpdateShoppingCartMsgLineOBJ;
import memory.cache.frontend.UpdateShoppingCartMsgLineCache;
import template.memory.cache.CacheDAOTemplate;
import transformer.frontend.obj.cache.updateShoppingCartMsgLine.UpdateShoppingCartMsgLineOBJTransformer;

public class UpdateShoppingCartMsgLineCacheDAO extends CacheDAOTemplate<UpdateShoppingCartMsgLineOBJ, UpdateShoppingCartMsgLineCache, 
			UpdateShoppingCartMsgLineOBJDTO, UpdateShoppingCartMsgLineOBJTransformer> {

	public static final String SESSION_ATTR_DAO = "updateShoppingCartMsgLineCacheDAO";
	
	
	public UpdateShoppingCartMsgLineCacheDAO(UpdateShoppingCartMsgLineCache cache) {
		
		super(cache);
	}

	@Override
	protected UpdateShoppingCartMsgLineOBJTransformer getTransformer() {
		
		return UpdateShoppingCartMsgLineOBJTransformer.getInstance();
	}

}
