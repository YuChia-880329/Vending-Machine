package transformer.frontend.obj.cache.receiptContent;

import bean.dto.frontend.obj.cache.receiptContent.TotalPriceMsgOBJDTO;
import bean.obj.frontend.cache.receiptContent.TotalPriceMsgOBJ;
import template.memory.cache.CacheTransformerTemplate;

public class TotalPriceMsgOBJTransformer extends CacheTransformerTemplate<TotalPriceMsgOBJ, TotalPriceMsgOBJDTO> {

	private static final TotalPriceMsgOBJTransformer INSTANCE = new TotalPriceMsgOBJTransformer();
	
	private TotalPriceMsgOBJTransformer() {
	}
	
	public static TotalPriceMsgOBJTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	protected TotalPriceMsgOBJDTO objToDtoTransform(TotalPriceMsgOBJ obj) {
		
		TotalPriceMsgOBJDTO dto = new TotalPriceMsgOBJDTO();
		
		dto.setTotalPrice(obj.getTotalPrice());
		
		return dto;
	}

	@Override
	protected TotalPriceMsgOBJ dtoToObjTransform(TotalPriceMsgOBJDTO dto) {
		
		TotalPriceMsgOBJ obj = new TotalPriceMsgOBJ();
		
		obj.setTotalPrice(dto.getTotalPrice());
		
		return obj;
	}
	
}
