package memory.statusCache.login;

import bean.obj.login.statusCache.notLoginMsg.NotLoginMsgOBJ;
import template.memory.statusCache.StatusCacheTemplate;

public class NotLoginMsgStatusCache extends StatusCacheTemplate<NotLoginMsgOBJ> {

	@Override
	protected NotLoginMsgOBJ ifNull() {
		
		return new NotLoginMsgOBJ(false);
	}
}
