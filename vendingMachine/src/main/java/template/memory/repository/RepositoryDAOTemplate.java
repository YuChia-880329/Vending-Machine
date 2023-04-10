package template.memory.repository;

public abstract class RepositoryDAOTemplate<I, O, P, D, R extends RepositoryTemplate<I, O>, 
	T extends RepositoryInputTransformerTemplate<P, I>, S extends RepositoryObjTransformerTemplate<O, D>> {

	protected R repository;
	protected T inputTransformer;
	protected S objTransformer;
	
	protected RepositoryDAOTemplate(R repository) {
		
		this.repository = repository;
		inputTransformer = getInputTransformer();
		objTransformer = getObjTransformer();
	}
	
	public D getObjDto(P inputDto) {
		
		return objTransformer.objToDto(
				repository.getObj(
						inputTransformer.dtoToInput(inputDto)));
	}
	

	protected abstract T getInputTransformer();
	protected abstract S getObjTransformer();
}
