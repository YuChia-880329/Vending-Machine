package dao.memory.memoryDb.frontend;

import java.util.List;

import bean.dto.frontend.obj.memoryDb.shoppingCart.ShoppingCartOBJDTO;
import bean.obj.frontend.memoryDb.shoppingCart.ShoppingCartOBJ;
import memory.database.frontend.ShoppingCartMemoryDb;
import template.memory.database.MemoryDbDAOTemplate;
import transformer.frontend.obj.memoryDb.shoppingCart.ShoppingCartOBJTransformer;

public class ShoppingCartMemoryDbDAO extends MemoryDbDAOTemplate<Integer, ShoppingCartOBJ, ShoppingCartMemoryDb, ShoppingCartOBJDTO, ShoppingCartOBJTransformer> {

	public static final String SESSION_ATTR_DAO = "shoppingCartMemoryDbDAO";
	
	
	public ShoppingCartMemoryDbDAO() {
		
		super(getInitialMemoryDb());
	}
	
	private static ShoppingCartMemoryDb getInitialMemoryDb() {
		
		ShoppingCartMemoryDb memoryDb = new ShoppingCartMemoryDb();
		
		return memoryDb;
	}
	
	public void deleteAll() {
		
		List<ShoppingCartOBJDTO> shoppingCartOBJDTOs = searchAll();
		
		for(ShoppingCartOBJDTO shoppingCartOBJDTO : shoppingCartOBJDTOs) {
			
			delete(shoppingCartOBJDTO.getId());
		}
	}

	@Override
	protected ShoppingCartOBJTransformer getTransformer() {

		return ShoppingCartOBJTransformer.getInstance();
	}
}
