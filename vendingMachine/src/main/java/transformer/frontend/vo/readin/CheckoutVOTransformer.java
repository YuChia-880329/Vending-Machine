package transformer.frontend.vo.readin;

import bean.dto.frontend.vo.readin.CheckoutVODTO;
import bean.vo.frontend.readin.CheckoutVO;
import template.exception.CheckerException;
import template.transformer.bean.vo.VOReanInTransformerTemplate;
import transformer.frontend.vo.readin.checker.CheckoutVOChecker;

public class CheckoutVOTransformer extends VOReanInTransformerTemplate<CheckoutVO, CheckoutVODTO, CheckerException, CheckoutVOChecker> {

	private CheckoutFormVOTransformer checkoutFormVOTransformer;
	private AddShoppingCartGoodsVOTransformer addShoppingCartGoodsVOTransformer;
	
	
	private static final CheckoutVOTransformer INSTANCE = new CheckoutVOTransformer();
	
	private CheckoutVOTransformer() {
		
		checkoutFormVOTransformer = CheckoutFormVOTransformer.getInstance();
		addShoppingCartGoodsVOTransformer = AddShoppingCartGoodsVOTransformer.getInstance();
	}
	
	public static CheckoutVOTransformer getInstance() {
		
		return INSTANCE;
	}

	@Override
	protected CheckoutVODTO voToDtoTransform(CheckoutVO vo) throws CheckerException {
		
		CheckoutVODTO dto = new CheckoutVODTO();
		
		dto.setQueryString(vo.getQueryString());
		dto.setCheckoutForm(checkoutFormVOTransformer.voToDto(vo.getCheckoutForm()));
		dto.setAddShoppingCartGoodsList(addShoppingCartGoodsVOTransformer.voArrayToDtoList(vo.getAddShoppingCartGoodsArray()));
		
		return dto;
	}

	@Override
	protected CheckoutVOChecker getChecker() {
		
		return CheckoutVOChecker.getInstance();
	}
}
