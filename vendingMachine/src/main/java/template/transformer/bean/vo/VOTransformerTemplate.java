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
	
	
	@Override
	public D beanToDto(V bean) throws E {
		
		return voToDto(bean);
	}
	@Override
	public V dtoToBean(D dto) {
		
		return dtoToVo(dto);
	}

	
	public abstract D voToDto(V vo) throws E;
	public abstract V dtoToVo(D dto);
}
