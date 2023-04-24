package dao.memory.memoryDb.frontend;

import bean.dto.frontend.obj.memoryDb.illegalMsg.IllegalMsgOBJDTO;
import bean.obj.frontend.memoryDb.illegalMsg.IllegalMsgOBJ;
import memory.database.frontend.IllegalMsgMemoryDb;
import template.memory.database.MemoryDbDAOTemplate;
import transformer.frontend.obj.memoryDb.shoppingCart.IllegalMsgOBJTransformer;

public class IllegalMsgMemoryDbDAO extends MemoryDbDAOTemplate<Integer, 
				IllegalMsgOBJ, IllegalMsgMemoryDb, IllegalMsgOBJDTO, 
				IllegalMsgOBJTransformer> {

	protected IllegalMsgMemoryDbDAO(IllegalMsgMemoryDb memory) {
		
		super(memory);
	}

	@Override
	protected IllegalMsgOBJTransformer getTransformer() {
		
		return IllegalMsgOBJTransformer.getInstance();
	}
	
	public void resetIdCounter() {
		
		this.transformer.resetIdCounter();
	}
}
