package transformer.frontend.obj.memoryDb.clearShoppingCartMsg;

import bean.dto.frontend.obj.memoryDb.clearShoppingCartMsg.ClearShoppingCartMsgOBJDTO;
import bean.obj.frontend.memoryDb.clearShoppingCartMsg.ClearShoppingCartMsgOBJ;
import enumeration.Has;
import template.memory.database.MemoryDbTransformerTemplate;
import template.memory.database.PKAndObject;

public class ClearShoppingCartMsgOBJTransformer extends MemoryDbTransformerTemplate<Integer, ClearShoppingCartMsgOBJ, ClearShoppingCartMsgOBJDTO> {

	public static final int ID = 1;
	
	
	private static final ClearShoppingCartMsgOBJTransformer INSTANCE = new ClearShoppingCartMsgOBJTransformer();

	private ClearShoppingCartMsgOBJTransformer() {
	}
	
	public static ClearShoppingCartMsgOBJTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	protected Integer getPkByDto(ClearShoppingCartMsgOBJDTO dto) {
		
		return ID;
	}

	@Override
	protected ClearShoppingCartMsgOBJ getObjByDto(ClearShoppingCartMsgOBJDTO dto) {
		
		ClearShoppingCartMsgOBJ obj = new ClearShoppingCartMsgOBJ();
		
		obj.setSuccess(dto.getSuccess());
		
		return obj;
	}

	@Override
	protected ClearShoppingCartMsgOBJDTO paoToDtoTransform(PKAndObject<Integer, ClearShoppingCartMsgOBJ> pao) {
		
		ClearShoppingCartMsgOBJDTO dto = new ClearShoppingCartMsgOBJDTO();
		
		ClearShoppingCartMsgOBJ obj = pao.getObj();
		
		if(obj == null)
			obj = new ClearShoppingCartMsgOBJ(Has.FALSE);
		
		dto.setSuccess(obj.getSuccess());
		
		return dto;
	}
}
