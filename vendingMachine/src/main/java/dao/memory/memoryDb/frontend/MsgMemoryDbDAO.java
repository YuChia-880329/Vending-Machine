package dao.memory.memoryDb.frontend;

import java.util.List;

import bean.dto.frontend.obj.memoryDb.msg.MsgOBJDTO;
import bean.obj.frontend.memoryDb.msg.MsgOBJ;
import memory.database.frontend.MsgMemoryDb;
import template.memory.database.MemoryDbDAOTemplate;
import transformer.frontend.obj.memoryDb.shoppingCart.MsgOBJTransformer;

public class MsgMemoryDbDAO extends MemoryDbDAOTemplate<Integer, 
				MsgOBJ, MsgMemoryDb, MsgOBJDTO, 
				MsgOBJTransformer> {

	public MsgMemoryDbDAO(MsgMemoryDb memory) {
		
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
		
		List<MsgOBJDTO> illegalMsgOBJDTOs = searchAll();
		
		for(MsgOBJDTO illegalMsgOBJDTO : illegalMsgOBJDTOs) {
			
			delete(illegalMsgOBJDTO);
		}
	}

	@Override
	protected MsgOBJTransformer getTransformer() {
		
		return MsgOBJTransformer.getInstance();
	}
	

}
