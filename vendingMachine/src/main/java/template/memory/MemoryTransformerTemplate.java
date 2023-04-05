package template.memory;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import template.transformer.BiTransformerTemplate;

public abstract class MemoryTransformerTemplate<P, O, D> extends BiTransformerTemplate<PKAndObject<P, O>, D> {

	
	public PKAndObject<P, O> dtoToPao(D dto){
		
		return new PKAndObject<>(getPkByDto(dto), getObjByDto(dto));
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
	public D aToB(PKAndObject<P, O> a) {
		
		return paoToDto(a);
	}
	@Override
	public PKAndObject<P, O> bToA(D b) {
		
		return new PKAndObject<>(getPkByDto(b), getObjByDto(b));
	}
	
	protected abstract P getPkByDto(D dto);
	protected abstract O getObjByDto(D dto);
	protected abstract D paoToDto(PKAndObject<P, O> pao);
}
