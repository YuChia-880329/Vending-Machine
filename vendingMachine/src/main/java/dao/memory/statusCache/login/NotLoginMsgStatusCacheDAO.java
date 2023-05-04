package dao.memory.statusCache.login;

import bean.dto.login.obj.statusCache.notLoginMsg.NotLoginMsgOBJDTO;
import bean.obj.login.statusCache.notLoginMsg.NotLoginMsgOBJ;
import memory.statusCache.login.NotLoginMsgStatusCache;
import template.memory.statusCache.StatusCacheDAOTemplate;
import transformer.login.obj.statusCache.notLoginMsg.NotLoginMsgOBJTransformer;

public class NotLoginMsgStatusCacheDAO extends StatusCacheDAOTemplate<NotLoginMsgOBJ, NotLoginMsgStatusCache, NotLoginMsgOBJDTO, NotLoginMsgOBJTransformer> {

	public static final String SESSION_ATTR_DAO = "notLoginMsgStatusCacheDAO";
	
	public NotLoginMsgStatusCacheDAO() {
		
		super(getInitialStatusCache());
	}
	
	private static NotLoginMsgStatusCache getInitialStatusCache() {
		
		NotLoginMsgStatusCache statusCache = new NotLoginMsgStatusCache();
		
		return statusCache;
	}

	@Override
	protected NotLoginMsgOBJTransformer getTransformer() {
		
		return NotLoginMsgOBJTransformer.getInstance();
	}
}
