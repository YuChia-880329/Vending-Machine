package transformer.frontend.obj.cache.addShoppingCartIllegalMsgLine;

import bean.dto.frontend.obj.cache.addShoppingCartIllegalMsgLine.AddShoppingCartIllegalMsgLineOBJDTO;
import bean.obj.frontend.cache.addShoppingCartIllegalMsgLine.AddShoppingCartIllegalMsgLineOBJ;
import template.memory.cache.CacheTransformerTemplate;

public class AddShoppingCartIllegalMsgLineOBJTransformer extends CacheTransformerTemplate<AddShoppingCartIllegalMsgLineOBJ, AddShoppingCartIllegalMsgLineOBJDTO> {

	private static final AddShoppingCartIllegalMsgLineOBJTransformer INSTANCE = new AddShoppingCartIllegalMsgLineOBJTransformer();

	private AddShoppingCartIllegalMsgLineOBJTransformer() {
	}
	
	public static AddShoppingCartIllegalMsgLineOBJTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	protected AddShoppingCartIllegalMsgLineOBJDTO objToDtoTransform(AddShoppingCartIllegalMsgLineOBJ obj) {
		
		AddShoppingCartIllegalMsgLineOBJDTO dto = new AddShoppingCartIllegalMsgLineOBJDTO();
		
		dto.setName(obj.getName());
		
		return dto;
	}
	@Override
	protected AddShoppingCartIllegalMsgLineOBJ dtoToObjTransform(AddShoppingCartIllegalMsgLineOBJDTO dto) {
		
		AddShoppingCartIllegalMsgLineOBJ obj = new AddShoppingCartIllegalMsgLineOBJ();
		
		obj.setName(dto.getName());
		
		return obj;
	}
}
