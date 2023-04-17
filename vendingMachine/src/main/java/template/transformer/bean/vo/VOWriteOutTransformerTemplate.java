package template.transformer.bean.vo;

import java.util.List;

import template.transformer.bean.BeanWriteOutTransformerTemplate;

public abstract class VOWriteOutTransformerTemplate<D, V> extends BeanWriteOutTransformerTemplate<D, V> {

	public List<V> dtoListToVoList(List<D> dtoList){
		
		return dtoListToBeanList(dtoList);
	}
	
	public V dtoToVo(D dto) {
		
		return dtoToBean(dto);
	}
	
	
	@Override
	protected V dtoToBeanTransform(D dto) {
		
		return dtoToVoTransform(dto);
	}
	

	protected abstract V dtoToVoTransform(D dto);
}
