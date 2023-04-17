package template.transformer.bean;

import java.util.List;

import template.transformer.TransformerTemplate;

public abstract class BeanWriteOutTransformerTemplate<D, B> extends TransformerTemplate<D, B> {

	public List<B> dtoListToBeanList(List<D> dList){
		
		return aListToBList(dList);
	}
	
	public B dtoToBean(D dto) {
		
		return aToB(dto);
	}
	
	
	@Override
	public B aToBTransform(D dto) {
		
		return dtoToBeanTransform(dto);
	}

	protected abstract B dtoToBeanTransform(D dto);
}
