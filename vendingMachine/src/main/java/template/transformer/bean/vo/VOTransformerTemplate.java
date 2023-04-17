package template.transformer.bean.vo;

import java.util.List;

import template.CheckerTemplate;
import template.exception.CheckerException;
import template.transformer.bean.BeanTransformerTemplate;

public abstract class VOTransformerTemplate<V, D, E extends CheckerException, C extends CheckerTemplate<V, E>> extends BeanTransformerTemplate<V, D, E, C> {

	public List<D> voListToDtoList(List<V> voList) throws E{
		
		return beanListToDtoList(voList);
	}
	public List<V> dtoListToVoList(List<D> dtoList){
		
		return dtoListToBeanList(dtoList);
	}
	public D voToDto(V vo) throws E{
		
		return beanToDto(vo);
	}
	public V dtoToVo(D dto) {
		
		return dtoToBean(dto);
	}
	

	@Override
	protected D beanToDtoTransform(V vo) throws E {
		
		return voToDtoTransform(vo);
	}
	@Override
	protected V dtoToBeanTransform(D dto) {
		
		return dtoToVoTransform(dto);
	}
	
	
	protected abstract D voToDtoTransform(V vo) throws E;
	protected abstract V dtoToVoTransform(D dto);
}
