package template.transformer.bean;

import java.util.List;

import template.transformer.TransformerTemplate;

public abstract class BeanWriteOutTransformerTemplate<D, B> extends TransformerTemplate<D, B> {

	public List<B> dtoListToBeanList(List<D> dList){
		
		return aListToBList(dList);
	}
	
	@Override
	public B aToB(D a) {
		
		return dtoToBean(a);
	}

	public abstract B dtoToBean(D dto);
}
