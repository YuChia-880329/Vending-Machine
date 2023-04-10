package template.memory.repository;


import java.util.List;

import template.transformer.TransformerTemplate;

public abstract class RepositoryObjTransformerTemplate<O, D> extends TransformerTemplate<O, D> {

	
	public List<D> objListToDtoList(List<O> objList){
		
		return aListToBList(objList);
	}
	
	@Override
	public D aToB(O obj) {

		return objToDto(obj);
	}

	
	public abstract D objToDto(O obj);
}
