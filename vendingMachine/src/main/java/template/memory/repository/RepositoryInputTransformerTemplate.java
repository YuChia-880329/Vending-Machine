package template.memory.repository;

import java.util.List;

import template.transformer.TransformerTemplate;

public abstract class RepositoryInputTransformerTemplate<P, I> extends TransformerTemplate<P, I> {

	public List<I> dtoListToInputList(List<P> dtoList){
		
		return aListToBList(dtoList);
	}
	
	@Override
	public I aToB(P dto) {
		
		return dtoToInput(dto);
	}

	public abstract I dtoToInput(P dto);
}
