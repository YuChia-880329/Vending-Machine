package transformer.login.obj.statusCache.currentMemberOBJ;

import bean.dto.login.obj.statusCache.currentMember.CurrentMemberOBJDTO;
import bean.obj.login.statusCache.currentMember.CurrentMemberOBJ;
import template.memory.statusCache.StatusCacheTransformerTemplate;

public class CurrentMemberOBJTransformer extends StatusCacheTransformerTemplate<CurrentMemberOBJ, CurrentMemberOBJDTO> {

	private static final CurrentMemberOBJTransformer INSTANCE = new CurrentMemberOBJTransformer();

	private CurrentMemberOBJTransformer() {
	}
	
	public static CurrentMemberOBJTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	protected CurrentMemberOBJDTO objToDtoTransform(CurrentMemberOBJ obj) {
		
		CurrentMemberOBJDTO dto = new CurrentMemberOBJDTO();
		
		dto.setId(obj.getId());
		dto.setName(obj.getName());
		
		return dto;
	}

	@Override
	protected CurrentMemberOBJ dtoToObjTransform(CurrentMemberOBJDTO dto) {
		
		CurrentMemberOBJ obj = new CurrentMemberOBJ();
		
		obj.setId(dto.getId());
		obj.setName(dto.getName());
		
		return obj;
	}
}
