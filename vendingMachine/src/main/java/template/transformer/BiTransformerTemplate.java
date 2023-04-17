package template.transformer;

import java.util.List;
import java.util.stream.Collectors;

public abstract class BiTransformerTemplate<A, B> extends TransformerTemplate<A, B> {

	
	public List<A> bListToAList(List<B> bList){
		
		return bList.stream().map(b -> bToA(b)).collect(Collectors.toList());
	}
	public A bToA(B b) {
		
		return bToATransform(b);
	}
	
	protected abstract A bToATransform(B b);
}
