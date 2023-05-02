package transformer.checker.frontend.vo.readin;

import bean.vo.frontend.readin.AddShoppingCartGoodsVO;
import bean.vo.frontend.readin.CheckoutAddShoppingCartVO;
import template.CheckerTemplate;
import template.exception.CheckerException;
import util.CheckUtil;
import util.StringConcatUtil;

public class CheckoutAddShoppingCartVOChecker extends CheckerTemplate<CheckoutAddShoppingCartVO, CheckerException> {

	private static final String NAME_PREFIX = "frontend, checkout add shopping cart, ";
	
	
	private AddShoppingCartGoodsVOChecker addShoppingCartGoodsVOChecker;
	
	
	private static final CheckoutAddShoppingCartVOChecker INSTANCE = new CheckoutAddShoppingCartVOChecker();
	
	private CheckoutAddShoppingCartVOChecker() {
		
		addShoppingCartGoodsVOChecker = AddShoppingCartGoodsVOChecker.getInstance();
	}
	public static CheckoutAddShoppingCartVOChecker getInstance() {
		
		return INSTANCE;
	}
	
	
	@Override
	public void check(CheckoutAddShoppingCartVO vo) throws CheckerException {

		checkVo(vo);
		
		checkAddShoppingCartGoodsArray(vo);
	}
	
	private void checkVo(CheckoutAddShoppingCartVO vo) throws CheckerException {
		
		CheckUtil.checkOther(vo, StringConcatUtil.concate(NAME_PREFIX, "vo"));
	}
	
	private void checkAddShoppingCartGoodsArray(CheckoutAddShoppingCartVO vo) throws CheckerException {
		
		AddShoppingCartGoodsVO[] addShoppingCartGoodsVOs = vo.getAddShoppingCartGoodsArray();
		
		for(AddShoppingCartGoodsVO addShoppingCartGoodsVO : addShoppingCartGoodsVOs) {
			
			addShoppingCartGoodsVOChecker.check(addShoppingCartGoodsVO);
		}
	}
}
