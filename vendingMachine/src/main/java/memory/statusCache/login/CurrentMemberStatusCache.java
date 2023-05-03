package memory.statusCache.login;

import bean.obj.login.statusCache.currentMember.CurrentMemberOBJ;
import template.memory.statusCache.StatusCacheTemplate;

public class CurrentMemberStatusCache extends StatusCacheTemplate<CurrentMemberOBJ> {

	@Override
	protected CurrentMemberOBJ ifNull() {
		
		return null;
	}

}
