package transformer.login.obj.statusCache.notLoginMsg;

import bean.dto.login.obj.statusCache.notLoginMsg.NotLoginMsgOBJDTO;
import bean.obj.login.statusCache.notLoginMsg.NotLoginMsgOBJ;
import template.memory.statusCache.StatusCacheTransformerTemplate;

public class NotLoginMsgOBJTransformer extends StatusCacheTransformerTemplate<NotLoginMsgOBJ, NotLoginMsgOBJDTO> {

	private static final NotLoginMsgOBJTransformer INSTANCE = new NotLoginMsgOBJTransformer();

	private NotLoginMsgOBJTransformer() {
	}
	
	public static NotLoginMsgOBJTransformer getInstance() {
		
		return INSTANCE;
	}

	
	@Override
	protected NotLoginMsgOBJDTO objToDtoTransform(NotLoginMsgOBJ obj) {
		
		NotLoginMsgOBJDTO dto = new NotLoginMsgOBJDTO();
		
		dto.setHasMsg(obj.getHasMsg());
		
		return dto;
	}

	@Override
	protected NotLoginMsgOBJ dtoToObjTransform(NotLoginMsgOBJDTO dto) {

		NotLoginMsgOBJ obj = new NotLoginMsgOBJ();
		
		obj.setHasMsg(dto.getHasMsg());
		
		return obj;
	}
}
