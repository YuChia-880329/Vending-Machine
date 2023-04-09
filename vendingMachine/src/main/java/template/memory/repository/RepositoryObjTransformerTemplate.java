package template.memory.repository;

import template.transformer.TransformerTemplate;

public abstract class RepositoryObjTransformerTemplate<O, D> extends TransformerTemplate<O, D> {

	@Override
	public D aToB(O obj) {

		return objToObjDto(obj);
	}


	public abstract D objToObjDto(O obj);
}
