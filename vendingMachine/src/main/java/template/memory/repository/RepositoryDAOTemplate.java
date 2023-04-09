package template.memory.repository;

public abstract class RepositoryDAOTemplate<I, O, P, D, R extends RepositoryTemplate<I, O>, 
	T extends RepositoryInputTransformerTemplate<P, I>, S extends RepositoryObjTransformerTemplate<O, D>> {

	protected R repository;
	protected T inputTransformer;
	protected S objTransformer;
	
	protected RepositoryDAOTemplate() {
		
		repository = getRepository();
		inputTransformer = getInputTransformer();
		objTransformer = getObjTransformer();
	}
	
	public D getObjDto(P inputDto) {
		
		return objTransformer.objToObjDto(
				repository.getObj(
						inputTransformer.inputDtoToInput(inputDto)));
	}
	
	
	
	
	protected abstract R getRepository();
	protected abstract T getInputTransformer();
	protected abstract S getObjTransformer();
}
