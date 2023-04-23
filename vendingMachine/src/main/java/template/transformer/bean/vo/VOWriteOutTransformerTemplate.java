package template.transformer.bean.vo;

import java.util.List;
import java.util.function.Function;

import template.transformer.bean.BeanWriteOutTransformerTemplate;

public abstract class VOWriteOutTransformerTemplate<D, V> extends BeanWriteOutTransformerTemplate<D, V> {

	public List<V> dtoListToVoList(List<D> dtoList){
		
		return dtoListToBeanList(dtoList);
	}
	public V[] dtoListToVoArray(List<D> dtoList, Function<Integer, V[]> arrayFctn){
		
		List<V> voList = dtoListToBeanList(dtoList);
		return voList.toArray(arrayFctn.apply(voList.size()));
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
