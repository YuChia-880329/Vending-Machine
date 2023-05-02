package transformer.frontend.vo.readin;

import bean.dto.frontend.vo.readin.CheckoutAddShoppingCartVODTO;
import bean.vo.frontend.readin.CheckoutAddShoppingCartVO;
import template.exception.CheckerException;
import template.transformer.bean.vo.VOReanInTransformerTemplate;
import transformer.checker.frontend.vo.readin.CheckoutAddShoppingCartVOChecker;

public class CheckoutAddShoppingCartVOTransformer extends VOReanInTransformerTemplate<CheckoutAddShoppingCartVO, CheckoutAddShoppingCartVODTO, CheckerException, CheckoutAddShoppingCartVOChecker> {

	private AddShoppingCartGoodsVOTransformer addShoppingCartGoodsVOTransformer;
	
	
	private static final CheckoutAddShoppingCartVOTransformer INSTANCE = new CheckoutAddShoppingCartVOTransformer();
	
	private CheckoutAddShoppingCartVOTransformer() {
		
		addShoppingCartGoodsVOTransformer = AddShoppingCartGoodsVOTransformer.getInstance();
	}
	
	public static CheckoutAddShoppingCartVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	protected CheckoutAddShoppingCartVODTO voToDtoTransform(CheckoutAddShoppingCartVO vo) throws CheckerException {
		
		CheckoutAddShoppingCartVODTO dto = new CheckoutAddShoppingCartVODTO();
		
		dto.setAddShoppingCartGoodsList(addShoppingCartGoodsVOTransformer.voArrayToDtoList(vo.getAddShoppingCartGoodsArray()));
		
		return dto;
	}

	@Override
	protected CheckoutAddShoppingCartVOChecker getChecker() {
		
		return CheckoutAddShoppingCartVOChecker.getInstance();
	}
	
	
}
