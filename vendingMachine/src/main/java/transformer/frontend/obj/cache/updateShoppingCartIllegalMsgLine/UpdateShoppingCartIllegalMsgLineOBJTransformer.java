package transformer.frontend.obj.cache.updateShoppingCartIllegalMsgLine;

import bean.dto.frontend.obj.cache.updateShoppingCartIllegalMsgLine.UpdateShoppingCartIllegalMsgLineOBJDTO;
import bean.obj.frontend.cache.updateShoppingCartIllegalMsgLine.UpdateShoppingCartIllegalMsgLineOBJ;
import template.memory.cache.CacheTransformerTemplate;

public class UpdateShoppingCartIllegalMsgLineOBJTransformer extends CacheTransformerTemplate<UpdateShoppingCartIllegalMsgLineOBJ, UpdateShoppingCartIllegalMsgLineOBJDTO> {

	private static final UpdateShoppingCartIllegalMsgLineOBJTransformer INSTANCE = new UpdateShoppingCartIllegalMsgLineOBJTransformer();

	private UpdateShoppingCartIllegalMsgLineOBJTransformer() {
	}
	
	public static UpdateShoppingCartIllegalMsgLineOBJTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	protected UpdateShoppingCartIllegalMsgLineOBJDTO objToDtoTransform(UpdateShoppingCartIllegalMsgLineOBJ obj) {
		
		UpdateShoppingCartIllegalMsgLineOBJDTO dto = new UpdateShoppingCartIllegalMsgLineOBJDTO();
		
		dto.setName(obj.getName());
		
		return dto;
	}

	@Override
	protected UpdateShoppingCartIllegalMsgLineOBJ dtoToObjTransform(UpdateShoppingCartIllegalMsgLineOBJDTO dto) {
		
		UpdateShoppingCartIllegalMsgLineOBJ obj = new UpdateShoppingCartIllegalMsgLineOBJ();
		
		obj.setName(dto.getName());
		
		return obj;
	}
	
	
}
