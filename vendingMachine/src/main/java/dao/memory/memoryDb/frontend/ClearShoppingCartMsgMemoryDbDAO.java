package dao.memory.memoryDb.frontend;

import java.util.List;

import bean.dto.frontend.obj.memoryDb.addShoppingCartMsg.AddShoppingCartMsgOBJDTO;
import bean.dto.frontend.obj.memoryDb.clearShoppingCartMsg.ClearShoppingCartMsgOBJDTO;
import bean.obj.frontend.memoryDb.clearShoppingCartMsg.ClearShoppingCartMsgOBJ;
import memory.database.frontend.ClearShoppingCartMsgMemoryDb;
import template.memory.database.MemoryDbDAOTemplate;
import transformer.frontend.obj.memoryDb.clearShoppingCartMsg.ClearShoppingCartMsgOBJTransformer;

public class ClearShoppingCartMsgMemoryDbDAO extends MemoryDbDAOTemplate<Integer, ClearShoppingCartMsgOBJ, 
					ClearShoppingCartMsgMemoryDb, ClearShoppingCartMsgOBJDTO, ClearShoppingCartMsgOBJTransformer> {

	public ClearShoppingCartMsgMemoryDbDAO(ClearShoppingCartMsgMemoryDb memory) {
		
		super(memory);
	}
	
	public void resetMemoryDb() {
		
		deleteAll();
	}
	
	private void deleteAll() {
		
		delete(ClearShoppingCartMsgOBJTransformer.ID);
	}

	@Override
	protected ClearShoppingCartMsgOBJTransformer getTransformer() {
		
		return ClearShoppingCartMsgOBJTransformer.getInstance();
	}

}
