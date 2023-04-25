package dao.memory.memoryDb.frontend;

import java.util.List;

import bean.dto.frontend.obj.memoryDb.addShoppingCartMsg.AddShoppingCartMsgOBJDTO;
import bean.obj.frontend.memoryDb.addShoppingCartMsg.AddShoppingCartMsgOBJ;
import memory.database.frontend.AddShoppingCartMsgMemoryDb;
import template.memory.database.MemoryDbDAOTemplate;
import transformer.frontend.obj.memoryDb.addShoppingCartMsg.AddShoppingCartMsgOBJTransformer;

public class AddShoppingCartMsgMemoryDbDAO extends MemoryDbDAOTemplate<Integer, 
				AddShoppingCartMsgOBJ, AddShoppingCartMsgMemoryDb, AddShoppingCartMsgOBJDTO, 
				AddShoppingCartMsgOBJTransformer> {

	public static final String DAO = "addShoppingCartMsgMemoryDbDAO";
	
	
	public AddShoppingCartMsgMemoryDbDAO(AddShoppingCartMsgMemoryDb memory) {
		
		super(memory);
	}
	
	public void resetMemoryDb() {
		
		deleteAll();
	}
	
	private void deleteAll() {
		
		List<AddShoppingCartMsgOBJDTO> nameOBJDTOs = searchAll();
		
		for(AddShoppingCartMsgOBJDTO nameOBJDTO : nameOBJDTOs) {
			
			delete(nameOBJDTO.getId());
		}
	}

	@Override
	protected AddShoppingCartMsgOBJTransformer getTransformer() {
		
		return AddShoppingCartMsgOBJTransformer.getInstance();
	}
	

}
