package transformer.checker.frontend.vo.readin;

import bean.vo.frontend.readin.AddShoppingCartGoodsVO;
import template.CheckerTemplate;
import template.exception.CheckerException;
import util.CheckUtil;
import util.StringConcatUtil;

public class AddShoppingCartGoodsVOChecker extends CheckerTemplate<AddShoppingCartGoodsVO, CheckerException> {

	private static final String NAME_PREFIX = "frontend, shopping cart form, goods ";
	
	private static final AddShoppingCartGoodsVOChecker INSTANCE = new AddShoppingCartGoodsVOChecker();
	
	private AddShoppingCartGoodsVOChecker() {
	}
	
	public static AddShoppingCartGoodsVOChecker getInstance() {
		
		return INSTANCE;
	}

	@Override
	public void check(AddShoppingCartGoodsVO vo) throws CheckerException {

		checkVo(vo);
		
		checkId(vo);
		checkName(vo);
		checkAddQuantity(vo);
		checkQuantity(vo);
	}
	
	private void checkVo(AddShoppingCartGoodsVO vo) throws CheckerException {
		
		CheckUtil.checkOther(vo, StringConcatUtil.concate(NAME_PREFIX, "vo"));
	}
	
	private void checkName(AddShoppingCartGoodsVO vo) {
	}
	private void checkId(AddShoppingCartGoodsVO vo) throws CheckerException {
		
		String id = vo.getId();
		
		CheckUtil.checkStringIsPositiveIntegerNumberString(id, StringConcatUtil.concate(NAME_PREFIX, "id"));
	}
	private void checkAddQuantity(AddShoppingCartGoodsVO vo) throws CheckerException {
		
		String addQuantity = vo.getAddQuantity();
		
		CheckUtil.checkStringIsNonNegativeIntegerNumberString(addQuantity, StringConcatUtil.concate(NAME_PREFIX, "buyQuantity"));
	}
	private void checkQuantity(AddShoppingCartGoodsVO vo) throws CheckerException {
		
		String quantity = vo.getQuantity();
		
		CheckUtil.checkStringIsNonNegativeIntegerNumberString(quantity, StringConcatUtil.concate(NAME_PREFIX, "quantity"));
	}
}
