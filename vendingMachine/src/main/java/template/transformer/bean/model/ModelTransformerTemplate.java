package template.transformer.bean.model;

import java.util.List;

import template.transformer.BiTransformerTemplate;

public abstract class ModelTransformerTemplate<M, D> extends BiTransformerTemplate<M, D> {

	public List<D> modelListToDtoList(List<M> modelList){
	
		return aListToBList(modelList);
	}
	public List<M> dtoListToModelList(List<D> dtoList){
		
		return bListToAList(dtoList);
	}

	public D modelToDto(M model) {
		
		return aToB(model);
	}
	public M dtoToModel(D dto) {
		
		return bToA(dto);
	}
	

	@Override
	protected D aToBTransform(M model) {
		
		return modelToDtoTransform(model);
	}
	@Override
	protected M bToATransform(D dto) {
		
		return dtoToModelTransform(dto);
	}
	
	
	protected abstract D modelToDtoTransform(M model);
	protected abstract M dtoToModelTransform(D dto);
}
