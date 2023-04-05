package template.transformer;

import java.util.ArrayList;
import java.util.List;

public abstract class TransformerExceptionTemplate<A, B, E extends Exception> {

	public List<B> aListToBList(List<A> aList) throws E{
		
		List<B> bList = new ArrayList<>();
		
		for(int i=0; i<aList.size(); i++) {
			
			bList.add(aToB(aList.get(i)));
		}
		
		return bList;
	}
	
	public abstract B aToB(A a) throws E;
}
