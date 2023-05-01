package template.memory.statusCache;

public abstract class StatusCacheDAOTemplate<O, C extends StatusCacheTemplate<O>, D, T extends StatusCacheTransformerTemplate<O, D>> {

	protected C cache;
	protected T transformer;
	
	protected StatusCacheDAOTemplate(C cache) {
		
		this.cache = cache;
		this.transformer = getTransformer();
	}
	
	
	public D getStatus() {
		
		return transformer.objToDtoTransform(cache.getStatus());
	}
	public void setStatus(D dto) {
		
		cache.setStatus(transformer.dtoToObjTransform(dto));
	}
	
	
	
	protected abstract T getTransformer();
}
