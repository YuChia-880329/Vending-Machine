package template.transformer.bean.vo;

import java.util.List;

import template.transformer.bean.BeanWriteOutTransformerTemplate;

public abstract class VOWriteOutTransformerTemplate<D, V> extends BeanWriteOutTransformerTemplate<D, V> {

	public List<V> dtoListToVoList(List<D> dtoList){
		
		return dtoListToBeanList(dtoList);
	}
	@Override
	public V dtoToBean(D dto) {
		
		return dtoToVo(dto);
	}
	
	public abstract V dtoToVo(D dto);
}
