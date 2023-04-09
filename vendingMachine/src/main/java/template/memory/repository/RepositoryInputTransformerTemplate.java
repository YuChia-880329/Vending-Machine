package template.memory.repository;

import template.transformer.TransformerTemplate;

public abstract class RepositoryInputTransformerTemplate<P, I> extends TransformerTemplate<P, I> {

	@Override
	public I aToB(P inputDto) {
		
		return inputDtoToInput(inputDto);
	}

	public abstract I inputDtoToInput(P inputDto);
}
