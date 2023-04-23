package transformer.frontend.vo.writeout;

import bean.dto.frontend.vo.writeout.ShoppingCartVODTO;
import bean.vo.frontend.writeout.ShoppingCartGoodsVO;
import bean.vo.frontend.writeout.ShoppingCartVO;
import template.transformer.bean.vo.VOWriteOutTransformerTemplate;

public class ShoppingCartVOTransformer extends VOWriteOutTransformerTemplate<ShoppingCartVODTO, ShoppingCartVO> {

	private ShoppingCartGoodsVOTransformer shoppingCartGoodsVOTransformer;
	
	
	private static final ShoppingCartVOTransformer INSTANCE = new ShoppingCartVOTransformer();
	
	private ShoppingCartVOTransformer() {
		
		shoppingCartGoodsVOTransformer = ShoppingCartGoodsVOTransformer.getInstance();
	}
	
	public static ShoppingCartVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	protected ShoppingCartVO dtoToVoTransform(ShoppingCartVODTO dto) {

		ShoppingCartVO vo = new ShoppingCartVO();
		
		vo.setShoppingCartGoodsArray(shoppingCartGoodsVOTransformer.dtoListToVoArray(dto.getShoppingCartGoodsList(), size -> new ShoppingCartGoodsVO[size]));
		
		return vo;
	}
}
