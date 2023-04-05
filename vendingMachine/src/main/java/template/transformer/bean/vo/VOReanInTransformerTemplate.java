package template.transformer.bean.vo;

import java.util.List;

import template.CheckerTemplate;
import template.exception.CheckerException;
import template.transformer.bean.BeanReanInTransformerTemplate;

public abstract class VOReanInTransformerTemplate<V, D, E extends CheckerException, C extends CheckerTemplate<V, E>> extends BeanReanInTransformerTemplate<V, D, E, C> {

	public List<D> voListToDtoList(List<V> voList) throws E{
		
		return beanListToDtoList(voList);
	}
	
	@Override
	public D beanToDto(V bean) throws E {
		
		return voToDto(bean);
	}
	
	public abstract D voToDto(V vo) throws E;
}
