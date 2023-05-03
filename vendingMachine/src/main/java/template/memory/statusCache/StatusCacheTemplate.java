package template.memory.statusCache;

public abstract class StatusCacheTemplate<O> {

	private O status;
	
	protected StatusCacheTemplate() {
		
		status = null;
	}
	
	public O getStatus() {
		
		if(status == null)
			return ifNull();
		return status;
	}
	
	public void setStatus(O status) {
		
		this.status = status;
	}
	
	protected abstract O ifNull();
}
