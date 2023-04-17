package template.transformer.bean;

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
		
		return bListToAList(dList);
	}
	
	public D beanToDto(B bean) throws E{
		
		checker.check(bean);
		return aToB(bean);
	}
	public B dtoToBean(D dto) {
		
		return bToA(dto);
	}
	
	
	@Override
	public D aToBTransform(B bean) throws E {
		
		return beanToDtoTransform(bean);
	}
	@Override
	public B bToATransform(D dto) {
		
		return dtoToBeanTransform(dto);
	}


	protected abstract D beanToDtoTransform(B bean) throws E;
	protected abstract B dtoToBeanTransform(D dto);
	protected abstract C getChecker();
}
