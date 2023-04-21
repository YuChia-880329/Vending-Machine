package template.transformer;

import java.util.ArrayList;
import java.util.List;

public abstract class TransformerExceptionTemplate<A, B, E extends Exception> {

	public List<B> aListToBList(List<A> aList) throws E{
		
		if(aList == null)
			return  new ArrayList<>();
		
		List<B> bList = new ArrayList<>();
		
		for(int i=0; i<aList.size(); i++) {
			
			bList.add(aToB(aList.get(i)));
		}
		
		return bList;
	}
	
	public B aToB(A a) throws E{
		
		if(a == null)
			return null;
		return aToBTransform(a);
	}
	
	protected abstract B aToBTransform(A a) throws E;
}
