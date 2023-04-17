package template.transformer;

import java.util.ArrayList;
import java.util.List;

public abstract class BiTransformerExceptionTemplate<A, B, E extends Exception> extends TransformerExceptionTemplate<A, B, E> {

	public List<A> bListToAList(List<B> bList){
		
		List<A> aList = new ArrayList<>();
		
		for(int i=0; i<bList.size(); i++) {
			
			aList.add(bToA(bList.get(i)));
		}
		
		return aList;
	}
	
	public A bToA(B b){
		
		return bToATransform(b);
	}
	
	protected abstract A bToATransform(B b);
}
