package template.transformer;

import java.util.List;
import java.util.stream.Collectors;

public abstract class TransformerTemplate<A, B> {

	
	public List<B> aListToBList(List<A> aList){
		
		if(aList == null)
			return null;
		
		return aList.stream().map(a -> aToB(a)).collect(Collectors.toList());
	}
	
	public B aToB(A a) {
	
		if(a == null)
			return null;
		return aToBTransform(a);
	}
	
	protected abstract B aToBTransform(A a);
}
