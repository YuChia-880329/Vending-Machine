package template.memory.repository;

public abstract class RepositoryTemplate<I, O> {

	protected O obj;
	
	protected RepositoryTemplate() {
		
		init();
		obj = update(initialInput());
	}
	
	public O getObj(I i) {
		
		if(needUpdate(i))
			update(i);
		return obj;
	}
	
	protected void init() {
		
	}
	
	protected abstract I initialInput();
	protected abstract boolean needUpdate(I i);
	protected abstract O update(I i);
}
