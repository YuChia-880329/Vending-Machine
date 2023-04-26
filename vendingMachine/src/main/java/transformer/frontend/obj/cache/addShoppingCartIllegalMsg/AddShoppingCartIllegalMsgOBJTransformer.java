package transformer.frontend.obj.cache.addShoppingCartIllegalMsg;

import bean.dto.frontend.obj.cache.addShoppingCartIllegalMsg.AddShoppingCartIllegalMsgOBJDTO;
import bean.obj.frontend.cache.addShoppingCartIllegalMsg.AddShoppingCartIllegalMsgOBJ;
import template.memory.cache.CacheTransformerTemplate;

public class AddShoppingCartIllegalMsgOBJTransformer extends CacheTransformerTemplate<AddShoppingCartIllegalMsgOBJ, AddShoppingCartIllegalMsgOBJDTO> {

	private static final AddShoppingCartIllegalMsgOBJTransformer INSTANCE = new AddShoppingCartIllegalMsgOBJTransformer();

	private AddShoppingCartIllegalMsgOBJTransformer() {
	}
	
	public static AddShoppingCartIllegalMsgOBJTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	protected AddShoppingCartIllegalMsgOBJDTO objToDtoTransform(AddShoppingCartIllegalMsgOBJ obj) {
		
		AddShoppingCartIllegalMsgOBJDTO dto = new AddShoppingCartIllegalMsgOBJDTO();
		
		dto.setName(obj.getName());
		
		return dto;
	}
	@Override
	protected AddShoppingCartIllegalMsgOBJ dtoToObjTransform(AddShoppingCartIllegalMsgOBJDTO dto) {
		
		AddShoppingCartIllegalMsgOBJ obj = new AddShoppingCartIllegalMsgOBJ();
		
		obj.setName(dto.getName());
		
		return obj;
	}
}
