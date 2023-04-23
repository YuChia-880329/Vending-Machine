package template.transformer.bean.vo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import template.CheckerTemplate;
import template.exception.CheckerException;
import template.transformer.bean.BeanReanInTransformerTemplate;

public abstract class VOReanInTransformerTemplate<V, D, E extends CheckerException, C extends CheckerTemplate<V, E>> extends BeanReanInTransformerTemplate<V, D, E, C> {

	public List<D> voListToDtoList(List<V> voList) throws E{
		
		return beanListToDtoList(voList);
	}
	public List<D> voArrayToDtoList(V[] voArray) throws E{
		
		return beanListToDtoList(new ArrayList<>(Arrays.asList(voArray)));
	}
	public D voToDto(V vo) throws E{
		
		return beanToDto(vo);
	}
	
	
	@Override
	protected D beanToDtoTramsform(V bean) throws E {
		
		return voToDtoTransform(bean);
	}

	
	protected abstract D voToDtoTransform(V vo) throws E;
}
