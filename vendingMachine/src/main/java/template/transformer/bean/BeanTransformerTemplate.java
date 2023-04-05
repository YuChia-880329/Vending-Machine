package template.transformer.bean;

import java.util.ArrayList;
import java.util.List;

import template.CheckerTemplate;
import template.exception.CheckerException;
import template.transformer.BiTransformerExceptionTemplate;

public abstract class BeanTransformerTemplate<B, D, E extends CheckerException, C extends CheckerTemplate<B, E>> extends BiTransformerExceptionTemplate<B, D, E> {

	protected C checker;
	
	protected BeanTransformerTemplate() {
		
		checker = getChecker();
	}
	
	public List<D> beanListToDtoList(List<B> bList) throws E{
		
		return aListToBList(bList);
	}
	public List<B> dtoListToBeanList(List<D> dList) {
		
		try {
			return bListToAList(dList);
		} catch (CheckerException ex) {
		}
		
		return new ArrayList<>();
	}
	
	
	@Override
	public D aToB(B a) throws E {
		
		return beanToDto(a);
	}
	@Override
	public B bToA(D b) {
		
		return dtoToBean(b);
	}
	

	public abstract D beanToDto(B bean) throws E;
	public abstract B dtoToBean(D dto);
	
	protected abstract C getChecker();
}
