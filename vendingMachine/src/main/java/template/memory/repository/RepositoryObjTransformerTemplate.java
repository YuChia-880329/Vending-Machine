package template.memory.repository;

import java.util.List;

import template.transformer.TransformerTemplate;

public abstract class RepositoryObjTransformerTemplate<O, D> extends TransformerTemplate<O, D> {

	public List<D> objListToDtoList(List<O> objList){
		
		return aListToBList(objList);
	}
	public D objToDto(O obj) {
		
		return aToB(obj);
	}
	
	
	@Override
	protected D aToBTransform(O obj) {
		
		return objToDtoTransform(obj);
	}
	
	
	protected abstract D objToDtoTransform(O obj);
}
