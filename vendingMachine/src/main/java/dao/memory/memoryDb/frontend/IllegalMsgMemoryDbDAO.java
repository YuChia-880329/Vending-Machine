package dao.memory.memoryDb.frontend;

import java.util.List;

import bean.dto.frontend.obj.memoryDb.illegalMsg.IllegalMsgOBJDTO;
import bean.obj.frontend.memoryDb.illegalMsg.IllegalMsgOBJ;
import memory.database.frontend.IllegalMsgMemoryDb;
import template.memory.database.MemoryDbDAOTemplate;
import transformer.frontend.obj.memoryDb.shoppingCart.IllegalMsgOBJTransformer;

public class IllegalMsgMemoryDbDAO extends MemoryDbDAOTemplate<Integer, 
				IllegalMsgOBJ, IllegalMsgMemoryDb, IllegalMsgOBJDTO, 
				IllegalMsgOBJTransformer> {

	public IllegalMsgMemoryDbDAO(IllegalMsgMemoryDb memory) {
		
		super(memory);
	}
	
	public void resetMemoryDb() {
		
		deleteAll();
		resetIdCounter();
	}
	
	private void resetIdCounter() {
		
		this.transformer.resetIdCounter();
	}
	
	private void deleteAll() {
		
		List<IllegalMsgOBJDTO> illegalMsgOBJDTOs = searchAll();
		
		for(IllegalMsgOBJDTO illegalMsgOBJDTO : illegalMsgOBJDTOs) {
			
			delete(illegalMsgOBJDTO);
		}
	}

	@Override
	protected IllegalMsgOBJTransformer getTransformer() {
		
		return IllegalMsgOBJTransformer.getInstance();
	}
	

}
