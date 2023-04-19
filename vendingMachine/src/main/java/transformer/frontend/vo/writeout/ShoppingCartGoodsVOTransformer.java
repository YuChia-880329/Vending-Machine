package transformer.frontend.vo.writeout;

import bean.dto.frontend.vo.writeout.ShoppingCartGoodsVODTO;
import bean.vo.frontend.writeout.ShoppingCartGoodsVO;
import template.transformer.bean.vo.VOWriteOutTransformerTemplate;

public class ShoppingCartGoodsVOTransformer extends VOWriteOutTransformerTemplate<ShoppingCartGoodsVODTO, ShoppingCartGoodsVO> {

	private static final ShoppingCartGoodsVOTransformer INSTANCE = new ShoppingCartGoodsVOTransformer();
	
	private ShoppingCartGoodsVOTransformer() {
	}
	
	public static ShoppingCartGoodsVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	protected ShoppingCartGoodsVO dtoToVoTransform(ShoppingCartGoodsVODTO dto) {

		ShoppingCartGoodsVO vo = new ShoppingCartGoodsVO();
		
		vo.setName(dto.getName());
		vo.setBuyQuantity(String.valueOf(dto.getBuyQuantity()));
		vo.setPrice(String.valueOf(dto.getPrice()));
		
		return vo;
	}
}