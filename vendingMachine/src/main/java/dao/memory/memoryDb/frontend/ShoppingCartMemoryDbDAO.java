package dao.memory.memoryDb.frontend;

import bean.dto.frontend.obj.memoryDb.shoppingCart.ShoppingCartOBJDTO;
import bean.obj.frontend.memoryDb.shoppingCart.ShoppingCartOBJ;
import memory.database.frontend.ShoppingCartMemoryDB;
import template.memory.database.MemoryDbDAOTemplate;
import transformer.frontend.obj.memoryDb.shoppingCart.ShoppingCartOBJTransformer;

public class ShoppingCartMemoryDbDAO extends MemoryDbDAOTemplate<Integer, ShoppingCartOBJ, ShoppingCartMemoryDB, ShoppingCartOBJDTO, ShoppingCartOBJTransformer> {

	public ShoppingCartMemoryDbDAO(ShoppingCartMemoryDB memory) {
		
		super(memory);
	}

	@Override
	protected ShoppingCartOBJTransformer getTransformer() {

		return ShoppingCartOBJTransformer.getInstance();
	}
}
