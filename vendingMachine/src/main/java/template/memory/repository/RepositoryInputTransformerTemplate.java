package template.memory.repository;

import java.util.List;

import template.transformer.TransformerTemplate;

public abstract class RepositoryInputTransformerTemplate<P, I> extends TransformerTemplate<P, I> {

	public List<I> dtoListToInputList(List<P> dtoList){
		
		return aListToBList(dtoList);
	}
	public I dtoToInput(P dto) {
		
		return aToB(dto);
	}
	
	
	@Override
	protected I aToBTransform(P dto) {
		
		return dtoToInputTransform(dto);
	}
	
	protected abstract I dtoToInputTransform(P dto);
}
