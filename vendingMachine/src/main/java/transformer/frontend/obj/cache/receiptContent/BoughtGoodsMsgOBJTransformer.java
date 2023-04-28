package transformer.frontend.obj.cache.receiptContent;

import bean.dto.frontend.obj.cache.receiptContent.BoughtGoodsMsgOBJDTO;
import bean.obj.frontend.cache.receiptContent.BoughtGoodsMsgOBJ;
import template.memory.cache.CacheTransformerTemplate;

public class BoughtGoodsMsgOBJTransformer extends CacheTransformerTemplate<BoughtGoodsMsgOBJ, BoughtGoodsMsgOBJDTO> {

	private static final BoughtGoodsMsgOBJTransformer INSTANCE = new BoughtGoodsMsgOBJTransformer();
	
	private BoughtGoodsMsgOBJTransformer() {
	}
	
	public static BoughtGoodsMsgOBJTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	protected BoughtGoodsMsgOBJDTO objToDtoTransform(BoughtGoodsMsgOBJ obj) {
		
		BoughtGoodsMsgOBJDTO dto = new BoughtGoodsMsgOBJDTO();
		
		dto.setName(obj.getName());
		dto.setPrice(obj.getPrice());
		dto.setBuyQuantity(obj.getBuyQuantity());
		
		return dto;
	}

	@Override
	protected BoughtGoodsMsgOBJ dtoToObjTransform(BoughtGoodsMsgOBJDTO dto) {

		BoughtGoodsMsgOBJ obj = new BoughtGoodsMsgOBJ();
		
		obj.setName(dto.getName());
		obj.setPrice(dto.getPrice());
		obj.setBuyQuantity(dto.getBuyQuantity());
		
		return obj;
	}
}
