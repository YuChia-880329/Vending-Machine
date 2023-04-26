package transformer.frontend.obj.cache.addShoppingCartMsgLine;

import bean.dto.frontend.obj.cache.addShoppingCartMsgLine.AddShoppingCartMsgLineOBJDTO;
import bean.obj.frontend.cache.addShoppingCartMsgLine.AddShoppingCartMsgLineOBJ;
import template.memory.cache.CacheTransformerTemplate;

public class AddShoppingCartMsgLineOBJTransformer extends CacheTransformerTemplate<AddShoppingCartMsgLineOBJ, AddShoppingCartMsgLineOBJDTO> {

	private static final AddShoppingCartMsgLineOBJTransformer INSTANCE = new AddShoppingCartMsgLineOBJTransformer();

	private AddShoppingCartMsgLineOBJTransformer() {
	}
	
	public static AddShoppingCartMsgLineOBJTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	protected AddShoppingCartMsgLineOBJDTO objToDtoTransform(AddShoppingCartMsgLineOBJ obj) {
		
		AddShoppingCartMsgLineOBJDTO dto = new AddShoppingCartMsgLineOBJDTO();
		
		dto.setAddQuantity(obj.getAddQuantity());
		dto.setName(obj.getName());
		
		return dto;
	}

	@Override
	protected AddShoppingCartMsgLineOBJ dtoToObjTransform(AddShoppingCartMsgLineOBJDTO dto) {
		
		AddShoppingCartMsgLineOBJ obj = new AddShoppingCartMsgLineOBJ();
		
		obj.setAddQuantity(dto.getAddQuantity());
		obj.setName(dto.getName());
		
		return obj;
	}
}
