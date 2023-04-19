package transformer.frontend.vo.readin.checker;

import bean.vo.frontend.readin.ShoppingCartGoodsVO;
import template.CheckerTemplate;
import template.exception.CheckerException;
import util.CheckUtil;
import util.StringConcatUtil;

public class ShoppingCartGoodsVOChecker extends CheckerTemplate<ShoppingCartGoodsVO, CheckerException> {

	private static final String NAME_PREFIX = "frontend, shopping cart form, goods ";
	
	private static final ShoppingCartGoodsVOChecker INSTANCE = new ShoppingCartGoodsVOChecker();
	
	private ShoppingCartGoodsVOChecker() {
	}
	
	public static ShoppingCartGoodsVOChecker getInstance() {
		
		return INSTANCE;
	}

	@Override
	public void check(ShoppingCartGoodsVO vo) throws CheckerException {

		checkVo(vo);
		
		checkId(vo);
		checkQuantity(vo);
	}
	
	private void checkVo(ShoppingCartGoodsVO vo) throws CheckerException {
		
		CheckUtil.checkOther(vo, StringConcatUtil.concate(NAME_PREFIX, "vo"));
	}
	
	private void checkId(ShoppingCartGoodsVO vo) throws CheckerException {
		
		String id = vo.getId();
		
		CheckUtil.checkStringIsPositiveIntegerNumberString(id, StringConcatUtil.concate(NAME_PREFIX, "id"));
	}
	private void checkQuantity(ShoppingCartGoodsVO vo) throws CheckerException {
		
		String quantity = vo.getQuantity();
		
		CheckUtil.checkStringIsNonNegativeIntegerNumberString(quantity, StringConcatUtil.concate(NAME_PREFIX, "quantity"));
	}
}
