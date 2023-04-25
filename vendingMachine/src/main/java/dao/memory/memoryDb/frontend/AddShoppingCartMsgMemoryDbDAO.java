package dao.memory.memoryDb.frontend;

import java.util.List;

import bean.dto.frontend.obj.memoryDb.msg.NameOBJDTO;
import bean.obj.frontend.memoryDb.addShoppingCartMsg.NameOBJ;
import memory.database.frontend.AddShoppingCartMsgMemoryDb;
import template.memory.database.MemoryDbDAOTemplate;
import transformer.frontend.obj.memoryDb.shoppingCart.AddShoppingCartMsgOBJTransformer;

public class AddShoppingCartMsgMemoryDbDAO extends MemoryDbDAOTemplate<Integer, 
				NameOBJ, AddShoppingCartMsgMemoryDb, NameOBJDTO, 
				AddShoppingCartMsgOBJTransformer> {

	public static final String DAO = "addShoppingCartMsgMemoryDbDAO";
	
	
	public AddShoppingCartMsgMemoryDbDAO(AddShoppingCartMsgMemoryDb memory) {
		
		super(memory);
	}
	
	public void resetMemoryDb() {
		
		deleteAll();
	}
	
	private void deleteAll() {
		
		List<NameOBJDTO> nameOBJDTOs = searchAll();
		
		for(NameOBJDTO nameOBJDTO : nameOBJDTOs) {
			
			delete(nameOBJDTO.getId());
		}
	}

	@Override
	protected AddShoppingCartMsgOBJTransformer getTransformer() {
		
		return AddShoppingCartMsgOBJTransformer.getInstance();
	}
	

}
