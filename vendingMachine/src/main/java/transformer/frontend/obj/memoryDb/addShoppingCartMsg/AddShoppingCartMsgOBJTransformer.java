package transformer.frontend.obj.memoryDb.addShoppingCartMsg;

import bean.dto.frontend.obj.memoryDb.addShoppingCartMsg.AddShoppingCartMsgOBJDTO;
import bean.obj.frontend.memoryDb.addShoppingCartMsg.AddShoppingCartMsgOBJ;
import template.memory.database.MemoryDbTransformerTemplate;
import template.memory.database.PKAndObject;

public class AddShoppingCartMsgOBJTransformer extends MemoryDbTransformerTemplate<Integer, AddShoppingCartMsgOBJ, AddShoppingCartMsgOBJDTO> {

	private static final AddShoppingCartMsgOBJTransformer INSTANCE = new AddShoppingCartMsgOBJTransformer();

	private AddShoppingCartMsgOBJTransformer() {
	}
	
	public static AddShoppingCartMsgOBJTransformer getInstance() {
		
		return INSTANCE;
	}
	
	
	@Override
	protected Integer getPkByDto(AddShoppingCartMsgOBJDTO dto) {
		
		return dto.getId();
	}
	@Override
	protected AddShoppingCartMsgOBJ getObjByDto(AddShoppingCartMsgOBJDTO dto) {
		
		AddShoppingCartMsgOBJ obj = new AddShoppingCartMsgOBJ();
		
		obj.setName(dto.getName());
		
		return obj;
	}
	@Override
	protected AddShoppingCartMsgOBJDTO paoToDtoTransform(PKAndObject<Integer, AddShoppingCartMsgOBJ> pao) {
		
		AddShoppingCartMsgOBJDTO dto = new AddShoppingCartMsgOBJDTO();
		
		AddShoppingCartMsgOBJ nameOBJ = pao.getObj();
		if(nameOBJ == null)
			nameOBJ = new AddShoppingCartMsgOBJ(null);
		
		dto.setId(pao.getPk());
		dto.setName(nameOBJ.getName());
		
		return dto;
	}

}
