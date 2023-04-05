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

	
	@Override
	public D aToB(M model) {
		
		return modelToDto(model);
	}
	@Override
	public M bToA(D dto) {
		
		return dtoToModel(dto);
	}

	public abstract D modelToDto(M model);
	public abstract M dtoToModel(D dto);
}
