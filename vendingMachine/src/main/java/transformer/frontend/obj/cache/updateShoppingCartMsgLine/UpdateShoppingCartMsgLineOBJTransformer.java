package transformer.frontend.obj.cache.updateShoppingCartMsgLine;

import bean.dto.frontend.obj.cache.updateShoppingCartMsgLine.UpdateShoppingCartMsgLineOBJDTO;
import bean.obj.frontend.cache.updateShoppingCartMsgLine.UpdateShoppingCartMsgLineOBJ;
import template.memory.cache.CacheTransformerTemplate;

public class UpdateShoppingCartMsgLineOBJTransformer extends CacheTransformerTemplate<UpdateShoppingCartMsgLineOBJ, UpdateShoppingCartMsgLineOBJDTO> {

	private static final UpdateShoppingCartMsgLineOBJTransformer INSTANCE = new UpdateShoppingCartMsgLineOBJTransformer();

	private UpdateShoppingCartMsgLineOBJTransformer() {
	}
	
	public static UpdateShoppingCartMsgLineOBJTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	protected UpdateShoppingCartMsgLineOBJDTO objToDtoTransform(UpdateShoppingCartMsgLineOBJ obj) {
		
		UpdateShoppingCartMsgLineOBJDTO dto = new UpdateShoppingCartMsgLineOBJDTO();
		
		dto.setName(obj.getName());
		dto.setBuyQuantity(obj.getBuyQuantity());
		
		return dto;
	}

	@Override
	protected UpdateShoppingCartMsgLineOBJ dtoToObjTransform(UpdateShoppingCartMsgLineOBJDTO dto) {
		
		UpdateShoppingCartMsgLineOBJ obj = new UpdateShoppingCartMsgLineOBJ();
		
		obj.setName(dto.getName());
		obj.setBuyQuantity(dto.getBuyQuantity());
		
		return obj;
	}
}
