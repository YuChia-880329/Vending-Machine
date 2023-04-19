package transformer.frontend.vo.readin.checker;

import bean.vo.frontend.readin.CheckoutVO;
import template.CheckerTemplate;
import template.exception.CheckerException;
import util.CheckUtil;
import util.StringConcatUtil;

public class CheckoutVOChecker extends CheckerTemplate<CheckoutVO, CheckerException> {

	private static final String NAME_PREFIX = "frontend, checkout form, ";
	
	private static final CheckoutVOChecker INSTANCE = new CheckoutVOChecker();
	
	private CheckoutVOChecker() {
	}
	
	public static CheckoutVOChecker getInstance() {
		
		return INSTANCE;
	}

	@Override
	public void check(CheckoutVO vo) throws CheckerException {

		checkVo(vo);
		
		checkPaidMoney(vo);
	}
	
	private void checkVo(CheckoutVO vo) throws CheckerException {
		
		CheckUtil.checkOther(vo, StringConcatUtil.concate(NAME_PREFIX, "vo"));
	}
	
	private void checkPaidMoney(CheckoutVO vo) throws CheckerException {
		
		String paidMoney = vo.getPaidMoney();
		
		CheckUtil.checkStringIsNonNegativeIntegerNumberString(paidMoney, StringConcatUtil.concate(NAME_PREFIX, "paidMoney"));
	}
}
