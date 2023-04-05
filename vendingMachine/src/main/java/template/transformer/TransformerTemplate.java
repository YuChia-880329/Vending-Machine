package template.transformer;

import java.util.List;
import java.util.stream.Collectors;

public abstract class TransformerTemplate<A, B> {

	
	public List<B> aListToBList(List<A> aList){
		
		return aList.stream().map(a -> aToB(a)).collect(Collectors.toList());
	}
	
	public abstract B aToB(A a);
}
