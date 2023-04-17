package template.transformer.bean;

import java.util.List;

import template.CheckerTemplate;
import template.exception.CheckerException;
import template.transformer.TransformerExceptionTemplate;

public abstract class BeanReanInTransformerTemplate<B, D, E extends CheckerException, C extends CheckerTemplate<B, E>> extends TransformerExceptionTemplate<B, D, E> {

	protected C checker;
	
	protected BeanReanInTransformerTemplate() {
		
		checker = getChecker();
	}
	

	public List<D> beanListToDtoList(List<B> bList) throws E{
		
		return aListToBList(bList);
	}
	
	public D beanToDto(B bean) throws E{
		
		checker.check(bean);
		return aToB(bean);
	}
	
	
	

	@Override
	public D aToBTransform(B bean) throws E {
		
		return beanToDtoTramsform(bean);
	}


	protected abstract D beanToDtoTramsform(B bean) throws E;
	protected abstract C getChecker();
}
