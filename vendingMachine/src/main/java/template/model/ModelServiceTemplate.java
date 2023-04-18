package template.model;

import java.sql.SQLException;
import java.util.List;

import template.transformer.bean.model.ModelTransformerTemplate;

public abstract class ModelServiceTemplate<M, P, D, A extends ModelDAOTemplate<M, P>, T extends ModelTransformerTemplate<M, D>> {

	protected A modelDAO;
	protected T modelTransformer;
	
	protected ModelServiceTemplate() {
		
		modelDAO = getModelDAO();
		modelTransformer = getModelTransformer();
	}
	
	public List<D> searchAll() throws SQLException{
		
		return modelTransformer.modelListToDtoList(modelDAO.searchAll());
	}
	public D searchById(P pk) throws SQLException {
		
		return modelTransformer.modelToDto(modelDAO.searchById(pk));
	};
	public D add(D dto) throws SQLException {
		
		return modelTransformer.modelToDto(modelDAO.add(modelTransformer.dtoToModel(dto)));
	}
	public int update(D dto) throws SQLException {
		
		return modelDAO.update(modelTransformer.dtoToModel(dto));
	}
	public int delete(P pk) throws SQLException {
		
		return modelDAO.delete(pk);
	}
	
	protected abstract A getModelDAO();
	protected abstract T getModelTransformer();
}
