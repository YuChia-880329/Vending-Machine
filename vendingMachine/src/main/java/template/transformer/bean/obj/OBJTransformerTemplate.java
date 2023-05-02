package template.transformer.bean.obj;

import java.util.List;

import template.transformer.BiTransformerTemplate;

public abstract class OBJTransformerTemplate<O, D> extends BiTransformerTemplate<O, D> {

	public D objToDto(O obj) {
		
		return aToB(obj);
	}
	public O dtoToObj(D dto) {
		
		return bToA(dto);
	}
	public List<D> objListToDtoList(List<O> objList) {
		
		return aListToBList(objList);
	}
	public List<O> dtoListToObjList(List<D> dtoList) {
		
		return bListToAList(dtoList);
	}
	
	@Override
	protected D aToBTransform(O obj) {
		
		return objToDtoTransform(obj);
	}
	@Override
	protected O bToATransform(D dto) {
		
		return dtoToObjTransform(dto);
	}

	protected abstract D objToDtoTransform(O obj);
	protected abstract O dtoToObjTransform(D dto);
}
