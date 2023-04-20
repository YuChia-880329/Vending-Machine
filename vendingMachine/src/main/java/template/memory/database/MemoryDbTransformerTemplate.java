package template.memory.database;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import template.transformer.BiTransformerTemplate;

public abstract class MemoryDbTransformerTemplate<P, O, D> extends BiTransformerTemplate<PKAndObject<P, O>, D> {

	
	public PKAndObject<P, O> dtoToPao(D dto){
		
		return bToA(dto);
	}
	public D paoToDto(PKAndObject<P, O> pao) {
		
		return aToB(pao);
	}
	public List<D> paoListToDtoList(List<PKAndObject<P, O>> paoList){
		
		return aListToBList(paoList);
	}
	public List<D> paoMapToDtoList(Map<P, O> paoMap){
		
		return aListToBList(paoMap.keySet().stream()
				.map(pk -> new PKAndObject<>(pk, paoMap.get(pk)))
				.collect(Collectors.toList()));
	}
	public List<PKAndObject<P, O>> dtoListToPaoList(List<D> dtoList){
		
		return bListToAList(dtoList);
	}
	public Map<P, O> dtoListToPaoMap(List<D> dtoList){
		
		return bListToAList(dtoList).stream()
			.collect(Collectors.toMap(pao -> pao.getPk(), pao -> pao.getObj()));
	}
	
	
	@Override
	protected D aToBTransform(PKAndObject<P, O> pao) {
		
		return paoToDtoTransform(pao);
	}
	@Override
	protected PKAndObject<P, O> bToATransform(D dto) {
		
		return new PKAndObject<>(getPkByDto(dto), getObjByDto(dto));
	}

	
	protected abstract P getPkByDto(D dto);
	protected abstract O getObjByDto(D dto);
	protected abstract D paoToDtoTransform(PKAndObject<P, O> pao);
}
