package transformer.frontend.vo.readin.checker;

import bean.vo.frontend.readin.AddShoppingCartGoodsVO;
import bean.vo.frontend.readin.CheckoutFormVO;
import bean.vo.frontend.readin.CheckoutVO;
import template.CheckerTemplate;
import template.exception.CheckerException;
import util.CheckUtil;
import util.StringConcatUtil;

public class CheckoutVOChecker extends CheckerTemplate<CheckoutVO, CheckerException> {

	private static final String NAME_PREFIX = "frontend, checkout , ";
	
	
	private CheckoutFormVOChecker checkoutFormVOChecker;
	private AddShoppingCartGoodsVOChecker addShoppingCartGoodsVOChecker;
	
	
	private static final CheckoutVOChecker INSTANCE = new CheckoutVOChecker();
	
	private CheckoutVOChecker() {
		
		checkoutFormVOChecker = CheckoutFormVOChecker.getInstance();
		addShoppingCartGoodsVOChecker = AddShoppingCartGoodsVOChecker.getInstance();
	}
	
	public static CheckoutVOChecker getInstance() {
		
		return INSTANCE;
	}

	@Override
	public void check(CheckoutVO vo) throws CheckerException {
		
		checkVo(vo);
		
		checkQueryString(vo);
		checkCheckoutForm(vo);
		checkAddShoppingCartGoodsArray(vo);
	}

	private void checkVo(CheckoutVO vo) throws CheckerException {
		
		CheckUtil.checkOther(vo, StringConcatUtil.concate(NAME_PREFIX, "vo"));
	}
	
	private void checkQueryString(CheckoutVO vo) throws CheckerException {
		
		String queryString = vo.getQueryString();
		
		CheckUtil.checkString(queryString, StringConcatUtil.concate(NAME_PREFIX, "vo"));
	}
	private void checkCheckoutForm(CheckoutVO vo) throws CheckerException {
		
		CheckoutFormVO checkoutForm = vo.getCheckoutForm();
		
		checkoutFormVOChecker.check(checkoutForm);
	}
	private void checkAddShoppingCartGoodsArray(CheckoutVO vo) throws CheckerException {
		
		AddShoppingCartGoodsVO[] addShoppingCartGoodsVOs = vo.getAddShoppingCartGoodsArray();
		
		for(AddShoppingCartGoodsVO addShoppingCartGoodsVO : addShoppingCartGoodsVOs) {
			
			addShoppingCartGoodsVOChecker.check(addShoppingCartGoodsVO);
		}
	}
}
