package template.memory.statusCache;

public abstract class StatusCacheTemplate<O> {

	private O status;
	
	protected StatusCacheTemplate() {
		
		status = initStatus();
	}
	
	public O getStatus() {
		
		return status;
	}
	
	public void setStatus(O status) {
		
		this.status = status;
	}
	
	protected abstract O initStatus();
}
