package dao.memory.memoryDb.frontend;

import bean.dto.frontend.obj.memoryDb.shoppingCart.ShoppingCartOBJDTO;
import bean.obj.frontend.memoryDb.shoppingCart.ShoppingCartOBJ;
import memory.database.frontend.ShoppingCartMemoryDb;
import template.memory.database.MemoryDbDAOTemplate;
import transformer.frontend.obj.memoryDb.shoppingCart.ShoppingCartOBJTransformer;

public class ShoppingCartMemoryDbDAO extends MemoryDbDAOTemplate<Integer, ShoppingCartOBJ, ShoppingCartMemoryDb, ShoppingCartOBJDTO, ShoppingCartOBJTransformer> {

	public static final String DAO = "shoppingCartMemoryDbDAO";
	
	
	public ShoppingCartMemoryDbDAO(ShoppingCartMemoryDb memory) {
		
		super(memory);
	}

	@Override
	protected ShoppingCartOBJTransformer getTransformer() {

		return ShoppingCartOBJTransformer.getInstance();
	}
}
