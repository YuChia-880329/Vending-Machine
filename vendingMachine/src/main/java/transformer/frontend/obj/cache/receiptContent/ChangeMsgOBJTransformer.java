package transformer.frontend.obj.cache.receiptContent;

import bean.dto.frontend.obj.cache.receiptContent.ChangeMsgOBJDTO;
import bean.obj.frontend.cache.receiptContent.ChangeMsgOBJ;
import template.memory.cache.CacheTransformerTemplate;

public class ChangeMsgOBJTransformer extends CacheTransformerTemplate<ChangeMsgOBJ, ChangeMsgOBJDTO> {

	private static final ChangeMsgOBJTransformer INSTANCE = new ChangeMsgOBJTransformer();
	
	private ChangeMsgOBJTransformer() {
	}
	
	public static ChangeMsgOBJTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	protected ChangeMsgOBJDTO objToDtoTransform(ChangeMsgOBJ obj) {

		ChangeMsgOBJDTO dto = new ChangeMsgOBJDTO();
		
		dto.setHasMsg(obj.getHasMsg());
		dto.setChange(obj.getChange());
		
		return dto;
	}

	@Override
	protected ChangeMsgOBJ dtoToObjTransform(ChangeMsgOBJDTO dto) {
		
		ChangeMsgOBJ obj = new ChangeMsgOBJ();
		
		obj.setHasMsg(dto.getHasMsg());
		obj.setChange(dto.getChange());
		
		return obj;
	}

}
