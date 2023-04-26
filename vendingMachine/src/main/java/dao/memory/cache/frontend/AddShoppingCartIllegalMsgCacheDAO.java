package dao.memory.cache.frontend;

import bean.dto.frontend.obj.cache.addShoppingCartIllegalMsg.AddShoppingCartIllegalMsgOBJDTO;
import bean.obj.frontend.cache.addShoppingCartIllegalMsg.AddShoppingCartIllegalMsgOBJ;
import memory.cache.frontend.AddShoppingCartIllegalMsgCache;
import template.memory.cache.CacheDAOTemplate;
import transformer.frontend.obj.cache.addShoppingCartIllegalMsg.AddShoppingCartIllegalMsgOBJTransformer;

public class AddShoppingCartIllegalMsgCacheDAO extends CacheDAOTemplate< AddShoppingCartIllegalMsgOBJ, AddShoppingCartIllegalMsgCache, 
				AddShoppingCartIllegalMsgOBJDTO, AddShoppingCartIllegalMsgOBJTransformer> {

	public static final String SESSION_ATTR_DAO = "addShoppingCartIllegalMsgCacheDAO";
	
	
	public AddShoppingCartIllegalMsgCacheDAO(AddShoppingCartIllegalMsgCache memory) {
		
		super(memory);
	}
	
	

	@Override
	protected AddShoppingCartIllegalMsgOBJTransformer getTransformer() {
		
		return AddShoppingCartIllegalMsgOBJTransformer.getInstance();
	}
}
