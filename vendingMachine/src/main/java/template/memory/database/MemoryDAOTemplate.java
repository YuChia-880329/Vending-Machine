package template.memory.database;

import java.util.List;

public abstract class MemoryDAOTemplate<P, O, M extends MemoryTemplate<P, O>, D, T extends MemoryTransformerTemplate<P, O, D>> {

	protected M memory;
	protected T transformer;
	
	protected MemoryDAOTemplate() {
		
		memory = getMemory();
		transformer = getTransformer();
	}
	
	public List<D> searchAll(){
		
		return transformer.paoMapToDtoList(memory.getAll());
	}
	public D searchByPk(P pk) {
		
		return transformer.paoToDto(
				new PKAndObject<>(pk, memory.getByPK(pk)));
	}
	public D insert(D dto) {
		
		P pk = transformer.getPkByDto(dto);
		
		return transformer.paoToDto(
				new PKAndObject<>(pk, memory.add(pk, transformer.getObjByDto(dto))));
	}
	public D update(D dto) {
		
		P pk = transformer.getPkByDto(dto);
		
		return transformer.paoToDto(
				new PKAndObject<>(pk, memory.update(pk, transformer.getObjByDto(dto))));
	}
	public D delete(D dto) {
		
		P pk = transformer.getPkByDto(dto);
		
		return transformer.paoToDto(
				new PKAndObject<>(pk, memory.delete(pk)));
	}
	
	
	protected abstract M getMemory();
	protected abstract T getTransformer();
}
