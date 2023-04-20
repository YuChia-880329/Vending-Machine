package template.memory.database;

import java.util.HashMap;
import java.util.Map;

public abstract class MemoryDbTemplate<P, O> {

	protected Map<P, O> memory;
	
	protected MemoryDbTemplate() {
		
		memory = new HashMap<>();
	}
	
	public Map<P, O> getAll(){
		
		return memory;
	}
	
	public O getByPK(P pk) {
		
		return memory.get(pk);
	}
	
	public O add(P pk, O obj) {
		
		O o = getByPK(pk);
		
		if(o == null) {
			
			memory.put(pk, obj);
			return obj;
		}else {
			
			return null;
		}
	}
	
	public O update(P pk, O obj) {
		
		return memory.put(pk, obj);
	}
	
	public O delete(P pk) {
		
		return memory.remove(pk);
	}
}
