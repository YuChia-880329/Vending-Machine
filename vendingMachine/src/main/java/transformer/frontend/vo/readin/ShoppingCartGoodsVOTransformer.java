package transformer.frontend.vo.readin;

import bean.dto.frontend.vo.readin.ShoppingCartGoodsVODTO;
import bean.vo.frontend.readin.ShoppingCartGoodsVO;
import template.exception.CheckerException;
import template.transformer.bean.vo.VOReanInTransformerTemplate;
import transformer.frontend.vo.readin.checker.ShoppingCartGoodsVOChecker;

public class ShoppingCartGoodsVOTransformer extends VOReanInTransformerTemplate<ShoppingCartGoodsVO, ShoppingCartGoodsVODTO, CheckerException, ShoppingCartGoodsVOChecker>  {

	private static final ShoppingCartGoodsVOTransformer INSTANCE = new ShoppingCartGoodsVOTransformer();
	
	private ShoppingCartGoodsVOTransformer() {
	}
	
	public static ShoppingCartGoodsVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	protected ShoppingCartGoodsVODTO voToDtoTransform(ShoppingCartGoodsVO vo) throws CheckerException {

		ShoppingCartGoodsVODTO dto = new ShoppingCartGoodsVODTO();
		
		dto.setId(Integer.parseInt(vo.getId()));
		dto.setQuantity(Integer.parseInt(vo.getQuantity()));
		
		return dto;
	}

	@Override
	protected ShoppingCartGoodsVOChecker getChecker() {

		return ShoppingCartGoodsVOChecker.getInstance();
	}
}
