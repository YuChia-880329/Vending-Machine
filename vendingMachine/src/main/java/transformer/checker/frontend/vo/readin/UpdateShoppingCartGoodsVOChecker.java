package transformer.checker.frontend.vo.readin;

import bean.vo.frontend.readin.UpdateShoppingCartGoodsVO;
import template.CheckerTemplate;
import template.exception.CheckerException;
import util.CheckUtil;
import util.StringConcatUtil;

public class UpdateShoppingCartGoodsVOChecker extends CheckerTemplate<UpdateShoppingCartGoodsVO, CheckerException> {

	private static final String NAME_PREFIX = "frontend, update shopping cart form, goods ";
	
	
	private static final UpdateShoppingCartGoodsVOChecker INSTANCE = new UpdateShoppingCartGoodsVOChecker();
	
	private UpdateShoppingCartGoodsVOChecker() {
	}
	
	public static UpdateShoppingCartGoodsVOChecker getInstance() {
		
		return INSTANCE;
	}

	@Override
	public void check(UpdateShoppingCartGoodsVO vo) throws CheckerException {
		
		checkVo(vo);
		
		checkId(vo);
		checkName(vo);
		checkBuyQuantity(vo);
		checkQuantity(vo);
	}
	
	private void checkVo(UpdateShoppingCartGoodsVO vo) throws CheckerException {
		
		CheckUtil.checkOther(vo, StringConcatUtil.concate(NAME_PREFIX, "vo"));
	}
	
	private void checkName(UpdateShoppingCartGoodsVO vo) {
	}
	private void checkId(UpdateShoppingCartGoodsVO vo) throws CheckerException {
		
		String id = vo.getId();
		
		CheckUtil.checkStringIsPositiveIntegerNumberString(id, StringConcatUtil.concate(NAME_PREFIX, "id"));
	}
	private void checkBuyQuantity(UpdateShoppingCartGoodsVO vo) throws CheckerException {
		
		String buyQuantity = vo.getBuyQuantity();
		
		CheckUtil.checkStringIsNonNegativeIntegerNumberString(buyQuantity, StringConcatUtil.concate(NAME_PREFIX, "buyQuantity"));
	}
	private void checkQuantity(UpdateShoppingCartGoodsVO vo) throws CheckerException {
		
		String quantity = vo.getQuantity();
		
		CheckUtil.checkStringIsNonNegativeIntegerNumberString(quantity, StringConcatUtil.concate(NAME_PREFIX, "quantity"));
	}
}
