package dao.memory.cache.frontend;

import bean.dto.frontend.obj.cache.updateShoppingCartIllegalMsgLine.UpdateShoppingCartIllegalMsgLineOBJDTO;
import bean.obj.frontend.cache.updateShoppingCartIllegalMsgLine.UpdateShoppingCartIllegalMsgLineOBJ;
import memory.cache.frontend.UpdateShoppingCartIllegalMsgLineCache;
import template.memory.cache.CacheDAOTemplate;
import transformer.frontend.obj.cache.updateShoppingCartIllegalMsgLine.UpdateShoppingCartIllegalMsgLineOBJTransformer;

public class UpdateShoppingCartIllegalMsgLineCacheDAO extends CacheDAOTemplate<UpdateShoppingCartIllegalMsgLineOBJ, 
				UpdateShoppingCartIllegalMsgLineCache, UpdateShoppingCartIllegalMsgLineOBJDTO, UpdateShoppingCartIllegalMsgLineOBJTransformer> {

	public static final String SESSION_ATTR_DAO = "updateShoppingCartIllegalMsgLineCacheDAO";
	
	
	public UpdateShoppingCartIllegalMsgLineCacheDAO(UpdateShoppingCartIllegalMsgLineCache cache) {
		
		super(cache);
	}

	@Override
	protected UpdateShoppingCartIllegalMsgLineOBJTransformer getTransformer() {
		
		return UpdateShoppingCartIllegalMsgLineOBJTransformer.getInstance();
	}

}
