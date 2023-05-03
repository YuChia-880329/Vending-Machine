package template.memory.statusCache;

public abstract class StatusCacheDAOTemplate<O, C extends StatusCacheTemplate<O>, D, T extends StatusCacheTransformerTemplate<O, D>> {

	protected C cache;
	protected T transformer;
	
	protected StatusCacheDAOTemplate(C cache) {
		
		this.cache = cache;
		this.transformer = getTransformer();
	}
	
	
	public D getStatus() {
		
		return transformer.objToDto(cache.getStatus());
	}
	public void setStatus(D dto) {
		
		cache.setStatus(transformer.dtoToObj(dto));
	}
	public void clearStatus() {
		
		cache.clearStatus();
	}
	
	
	
	protected abstract T getTransformer();
}
