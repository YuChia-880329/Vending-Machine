package template.memory.cache;

import java.util.List;

public abstract class CacheDAOTemplate<O, C extends CacheTemplate<O>, D, T extends CacheTransformerTemplate<O, D>> {

	protected C cache;
	protected T transformer;
	
	protected CacheDAOTemplate(C cache) {
		
		this.cache = cache;
		this.transformer = getTransformer();
	}
	
	public void save(D dto) {
		
		cache.save(transformer.dtoToObj(dto));
	}
	public List<D> use(boolean needClear){
		
		return transformer.objListToDtoList(cache.use(needClear));
	}
	public void clearCache() {
		
		cache.clearCache();
	}
	
	
	protected abstract T getTransformer();
}
