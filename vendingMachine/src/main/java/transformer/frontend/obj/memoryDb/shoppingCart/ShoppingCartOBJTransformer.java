package transformer.frontend.obj.memoryDb.shoppingCart;

import bean.dto.frontend.obj.memoryDb.shoppingCart.ShoppingCartOBJDTO;
import bean.obj.frontend.memoryDb.shoppingCart.ShoppingCartOBJ;
import template.memory.database.MemoryDbTransformerTemplate;
import template.memory.database.PKAndObject;

public class ShoppingCartOBJTransformer extends MemoryDbTransformerTemplate<Integer, ShoppingCartOBJ, ShoppingCartOBJDTO> {

	private static final ShoppingCartOBJTransformer INSTANCE = new ShoppingCartOBJTransformer();

	private ShoppingCartOBJTransformer() {
	}
	
	public static ShoppingCartOBJTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	protected Integer getPkByDto(ShoppingCartOBJDTO dto) {
		
		return dto.getId();
	}

	@Override
	protected ShoppingCartOBJ getObjByDto(ShoppingCartOBJDTO dto) {
		
		ShoppingCartOBJ obj = new ShoppingCartOBJ();
		
		obj.setBuyQuantity(dto.getBuyQuantity());
		
		return obj;
	}

	@Override
	protected ShoppingCartOBJDTO paoToDtoTransform(PKAndObject<Integer, ShoppingCartOBJ> pao) {
		
		ShoppingCartOBJDTO dto = new ShoppingCartOBJDTO();
		
		ShoppingCartOBJ shoppingCartOBJ = pao.getObj();
		
		dto.setId(pao.getPk());
		dto.setBuyQuantity(shoppingCartOBJ==null ? 0 : shoppingCartOBJ.getBuyQuantity());
		
		return dto;
	}
}
