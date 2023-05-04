package dao.memory.statusCache;

import bean.dto.obj.statusCache.currentMember.CurrentMemberOBJDTO;
import bean.obj.statusCache.currentMember.CurrentMemberOBJ;
import memory.statusCache.CurrentMemberStatusCache;
import template.memory.statusCache.StatusCacheDAOTemplate;
import transformer.obj.statusCache.currentMemberOBJ.CurrentMemberOBJTransformer;

public class CurrentMemberStatusCacheDAO extends StatusCacheDAOTemplate<CurrentMemberOBJ, CurrentMemberStatusCache, CurrentMemberOBJDTO, CurrentMemberOBJTransformer> {

	public static final String SESSION_ATTR_DAO = "currentMemberStatusCacheDAO";
	
	public CurrentMemberStatusCacheDAO() {
		
		super(getInitialStatusCache());
	}
	
	private static CurrentMemberStatusCache getInitialStatusCache() {
		
		CurrentMemberStatusCache statusCache = new CurrentMemberStatusCache();
		
		return statusCache;
	}

	@Override
	protected CurrentMemberOBJTransformer getTransformer() {
		
		return CurrentMemberOBJTransformer.getInstance();
	}

}
