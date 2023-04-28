package template.memory.cache;

import java.util.ArrayList;
import java.util.List;

import util.CollectionUtil;

public abstract class CacheTemplate<O> {

	protected List<O> cachePool;
	
	protected CacheTemplate() {
		
		cachePool = new ArrayList<>();
	}
	
	public void save(O obj) {
		
		cachePool.add(obj);
	}
	public List<O> use(boolean needClear){
		
		List<O> copy = CollectionUtil.copy(cachePool, () -> new ArrayList<>());
		
		if(needClear)
			clearCache();
		return copy;
	}
	public void clearCache() {
		
		cachePool.removeIf(obj -> true);
	}
}
