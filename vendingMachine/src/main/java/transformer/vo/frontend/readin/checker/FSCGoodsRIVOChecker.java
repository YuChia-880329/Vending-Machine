package transformer.vo.frontend.readin.checker;

import bean.vo.frontend.readin.FSCGoodsRIVO;
import template.CheckerTemplate;
import template.exception.CheckerException;
import util.CheckUtil;
import util.StringConcatUtil;

public class FSCGoodsRIVOChecker extends CheckerTemplate<FSCGoodsRIVO, CheckerException> {

	private static final String NAME_PREFIX = "frontend, shopping cart form, goods ";
	
	private static final FSCGoodsRIVOChecker INSTANCE = new FSCGoodsRIVOChecker();
	
	private FSCGoodsRIVOChecker() {
	}
	
	public static FSCGoodsRIVOChecker getInstance() {
		
		return INSTANCE;
	}

	@Override
	public void check(FSCGoodsRIVO vo) throws CheckerException {

		checkVo(vo);
		
		checkId(vo);
		checkQuantity(vo);
	}
	
	private void checkVo(FSCGoodsRIVO vo) throws CheckerException {
		
		CheckUtil.checkOther(vo, StringConcatUtil.concate(NAME_PREFIX, "vo"));
	}
	
	private void checkId(FSCGoodsRIVO vo) throws CheckerException {
		
		String id = vo.getId();
		
		CheckUtil.checkStringIsPositiveIntegerNumberString(id, StringConcatUtil.concate(NAME_PREFIX, "id"));
	}
	private void checkQuantity(FSCGoodsRIVO vo) throws CheckerException {
		
		String quantity = vo.getQuantity();
		
		CheckUtil.checkStringIsNonNegativeIntegerNumberString(quantity, StringConcatUtil.concate(NAME_PREFIX, "quantity"));
	}
}
