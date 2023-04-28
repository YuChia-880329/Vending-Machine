package dao.memory.cache.frontend;

import bean.dto.frontend.obj.cache.receiptContent.ReceiptContentOBJDTO;
import bean.obj.frontend.cache.receiptContent.ReceiptContentOBJ;
import memory.cache.frontend.ReceiptContentCache;
import template.memory.cache.CacheDAOTemplate;
import transformer.frontend.obj.cache.receiptContent.ReceiptContentOBJTransformer;

public class ReceiptContentCacheDAO extends CacheDAOTemplate<ReceiptContentOBJ, ReceiptContentCache, ReceiptContentOBJDTO, ReceiptContentOBJTransformer> {

	public static final String SESSION_ATTR_DAO = "receiptContentCacheDAO";
	
	public ReceiptContentCacheDAO(ReceiptContentCache cache) {
		
		super(cache);
	}

	@Override
	protected ReceiptContentOBJTransformer getTransformer() {
		
		return ReceiptContentOBJTransformer.getInstance();
	}	
}
