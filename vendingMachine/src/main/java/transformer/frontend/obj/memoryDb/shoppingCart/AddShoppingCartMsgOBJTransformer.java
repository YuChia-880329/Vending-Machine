package transformer.frontend.obj.memoryDb.shoppingCart;

import bean.dto.frontend.obj.memoryDb.msg.NameOBJDTO;
import bean.obj.frontend.memoryDb.addShoppingCartMsg.NameOBJ;
import template.memory.database.MemoryDbTransformerTemplate;
import template.memory.database.PKAndObject;

public class AddShoppingCartMsgOBJTransformer extends MemoryDbTransformerTemplate<Integer, NameOBJ, NameOBJDTO> {

	private static final AddShoppingCartMsgOBJTransformer INSTANCE = new AddShoppingCartMsgOBJTransformer();

	private AddShoppingCartMsgOBJTransformer() {
	}
	
	public static AddShoppingCartMsgOBJTransformer getInstance() {
		
		return INSTANCE;
	}
	
	
	@Override
	protected Integer getPkByDto(NameOBJDTO dto) {
		
		return dto.getId();
	}
	@Override
	protected NameOBJ getObjByDto(NameOBJDTO dto) {
		
		NameOBJ obj = new NameOBJ();
		
		obj.setName(dto.getName());
		
		return obj;
	}
	@Override
	protected NameOBJDTO paoToDtoTransform(PKAndObject<Integer, NameOBJ> pao) {
		
		NameOBJDTO dto = new NameOBJDTO();
		
		NameOBJ nameOBJ = pao.getObj();
		if(nameOBJ == null)
			nameOBJ = new NameOBJ(null);
		
		dto.setId(pao.getPk());
		dto.setName(nameOBJ.getName());
		
		return dto;
	}

}
