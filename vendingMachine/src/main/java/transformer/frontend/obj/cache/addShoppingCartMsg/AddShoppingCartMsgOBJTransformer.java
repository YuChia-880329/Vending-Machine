package transformer.frontend.obj.cache.addShoppingCartMsg;

import bean.dto.frontend.obj.cache.addShoppingCartMsg.AddShoppingCartMsgOBJDTO;
import bean.obj.frontend.cache.addShoppingCartMsg.AddShoppingCartMsgOBJ;
import template.memory.cache.CacheTransformerTemplate;

public class AddShoppingCartMsgOBJTransformer extends CacheTransformerTemplate<AddShoppingCartMsgOBJ, AddShoppingCartMsgOBJDTO> {

	private static final AddShoppingCartMsgOBJTransformer INSTANCE = new AddShoppingCartMsgOBJTransformer();

	private AddShoppingCartMsgOBJTransformer() {
	}
	
	public static AddShoppingCartMsgOBJTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	protected AddShoppingCartMsgOBJDTO objToDtoTransform(AddShoppingCartMsgOBJ obj) {
		
		AddShoppingCartMsgOBJDTO dto = new AddShoppingCartMsgOBJDTO();
		
		dto.setAddQuantity(obj.getAddQuantity());
		dto.setName(obj.getName());
		
		return dto;
	}

	@Override
	protected AddShoppingCartMsgOBJ dtoToObjTransform(AddShoppingCartMsgOBJDTO dto) {
		
		AddShoppingCartMsgOBJ obj = new AddShoppingCartMsgOBJ();
		
		obj.setAddQuantity(dto.getAddQuantity());
		obj.setName(dto.getName());
		
		return obj;
	}
}
