package transformer.frontend.vo.readin;

import bean.dto.frontend.vo.readin.ShoppingCartVODTO;
import bean.vo.frontend.readin.ShoppingCartVO;
import template.exception.CheckerException;
import template.transformer.bean.vo.VOReanInTransformerTemplate;
import transformer.frontend.vo.readin.checker.ShoppingCartVOChecker;

public class ShoppingCartVOTransformer extends VOReanInTransformerTemplate<ShoppingCartVO, ShoppingCartVODTO, CheckerException, ShoppingCartVOChecker>  {

	private ShoppingCartGoodsVOTransformer fscGoodsRIVOTransformer;
	
	
	private static final ShoppingCartVOTransformer INSTANCE = new ShoppingCartVOTransformer();
	
	private ShoppingCartVOTransformer() {
		
		fscGoodsRIVOTransformer = ShoppingCartGoodsVOTransformer.getInstance();
	}
	
	public static ShoppingCartVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	protected ShoppingCartVODTO voToDtoTransform(ShoppingCartVO vo) throws CheckerException {

		ShoppingCartVODTO dto = new ShoppingCartVODTO();
		
		dto.setShoppingCartGoodsList(fscGoodsRIVOTransformer.voListToDtoList(vo.getShoppingCartGoodsList()));
		
		return dto;
	}

	@Override
	protected ShoppingCartVOChecker getChecker() {

		return ShoppingCartVOChecker.getInstance();
	}
}
