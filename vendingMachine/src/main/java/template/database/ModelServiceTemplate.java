package template.database;

import java.util.List;

public abstract class ModelServiceTemplate<M, P, D, A extends ModelDAOTemplate<M, P>, T extends ModelTransformerTemplate<M, D>> {

	protected A modelDAO;
	protected T modelTransformer;
	
	protected ModelServiceTemplate() {
		
		modelDAO = getModelDAO();
		modelTransformer = getModelTransformer();
	}
	
	public List<D> searchAll(){
		
		return modelTransformer.modelListToDtoList(modelDAO.searchAll());
	}
	public D searchById(P pk) {
		
		return modelTransformer.modelToDto(modelDAO.searchById(pk));
	};
	public D add(D dto) {
		
		return modelTransformer.modelToDto(modelDAO.add(modelTransformer.dtoToModel(dto)));
	}
	public int update(D dto) {
		
		return modelDAO.update(modelTransformer.dtoToModel(dto));
	}
	public int delete(P pk) {
		
		return modelDAO.delete(pk);
	}
	
	protected abstract A getModelDAO();
	protected abstract T getModelTransformer();
}
